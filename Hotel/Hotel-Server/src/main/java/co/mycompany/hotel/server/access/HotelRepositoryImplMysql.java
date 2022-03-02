package co.mycompany.hotel.server.access;

import co.mycompany.hotel.commons.domain.Persona;
import co.mycompany.hotel.commons.domain.DiaSemana;
import co.mycompany.hotel.commons.domain.Hotel;
import co.mycompany.hotel.commons.domain.Habitacion;
import co.mycompany.hotel.commons.domain.TipoHabitacion;
import co.mycompany.hotel.commons.infra.Utilities;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Repositorio de Clientes en MySWL
 *
 * @author Kevin Morales
 */
public class HotelRepositoryImplMysql implements IHotelRepository {

    /**
     * Conección con Mysql
     */
    private Connection conn;

    public HotelRepositoryImplMysql() {
    }

    @Override
    public ArrayList<Habitacion> getDiaHabitaciones(int idHotel, DiaSemana dia) {
        ArrayList<Habitacion> menu = new ArrayList();
        try {
            this.connect();

            String sql = "select * from hotelhabt natural join habitacion where hotel_id=? and dia=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Integer.toString(idHotel));
            pstmt.setString(2, dia.name());
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                Habitacion habitacion = new Habitacion();
                habitacion.setId(Integer.parseInt(res.getString("habt_id")));
                habitacion.setDescripcion(res.getString("habt_descripcion"));
                habitacion.setPrecio(Integer.parseInt(res.getString("habt_precio")));
                habitacion.setTipo(TipoHabitacion.valueOf(res.getString("habt_tipo")));
                habitacion.setFoto(res.getString("habt_foto"));
                menu.add(habitacion);
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(HotelRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar getMenuDia de la base de datos", ex);
        }
        return menu;
    }

    @Override
    public ArrayList<Hotel> getHoteles() {
        ArrayList<Hotel> hoteles = new ArrayList();
        try {
            this.connect();
            String sql = "SELECT * from hotel";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                Hotel hotel = new Hotel();
                hotel.setId(Integer.parseInt(res.getString("hotel_id")));
                hotel.setNombre(res.getString("hotel_nombre"));
                hotel.setDirecccion(res.getString("hotel_direccion"));
                hotel.setCiudad(res.getString("hotel_ciudad"));
                hotel.setTelefono(res.getString("hotel_telefono"));
                hotel.setFoto(res.getString("hotel_foto"));
                hoteles.add(hotel);
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(HotelRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Customer de la base de datos", ex);
        }
        return hoteles;
    }

    @Override
    public String addHabitacion(Habitacion habitacion) {
        try {
            this.connect();
            int cont;
            String sql = "insert into habitacion values(null,?,?,?,?,1)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            cont = 1;
            //pstmt.setInt(cont, habitacion.getId());
            //cont++;
            pstmt.setString(cont, habitacion.getDescripcion());
            cont++;
            pstmt.setInt(cont, habitacion.getPrecio());
            cont++;
            pstmt.setString(cont, habitacion.getTipo().name());
            cont++;
            pstmt.setString(cont, habitacion.getFoto());
            System.out.println(pstmt.toString());

            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(HotelRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
            return "Error, el componente con ese id y nombre ya existe";
        }
        return "Componente añadido correctamente";
    }

    @Override
    public String addReserva(int idHotel, Habitacion habitacion, LocalDate fecha_inicio, LocalDate fecha_fin, Persona sesion) {
        try {
            this.connect();
            int cont;
            String sql = "insert into reserva values(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            cont = 1;
            pstmt.setInt(cont, idHotel);
            cont++;
            pstmt.setInt(cont, habitacion.getId());
            cont++;
            pstmt.setInt(cont, sesion.getId());
            cont++;
            pstmt.setString(cont, fecha_inicio.toString());
            cont++;
            pstmt.setString(cont, fecha_fin.toString());
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(HotelRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        return "Habitacion añadido correctamente";
    }

    @Override
    public String deleteHabitacionSemanal(int idHotel, Habitacion habitacion, DiaSemana dia) {
        try {
            this.connect();
            int cont;
            String sql = "delete from hotelhabt where hotel_id=? and habt_id=? and dia=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            cont = 1;
            pstmt.setInt(cont, idHotel);
            cont++;
            pstmt.setInt(cont, habitacion.getId());
            cont++;
            pstmt.setString(cont, dia.name());
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(HotelRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        return "Habitacion se ha reservado correctamente";
    }
    @Override
    public Persona getPersona(String usuario) {
        Persona p=new Persona();
        try {
            this.connect();
            String sql = "SELECT * from persona inner join sesion on persona.persona_id=sesion.persona_id where sesion.ses_usuario=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, usuario);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                p.setId(res.getInt("persona_id"));
                p.setNombre(res.getString("persona_nombre"));
                p.setTelefono(res.getString("persona_tel"));
                p.setDireccion(res.getString("persona_dir"));
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(HotelRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar getMenuDia de la base de datos", ex);
        }
        return p;
    }

    @Override
    public String getSesionClave(String usuario) {
        String clave = null;
        try {
            this.connect();
            String sql = "select * from sesion where ses_usuario=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, usuario);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                clave = res.getString("ses_clave");
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(HotelRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar getMenuDia de la base de datos", ex);
        }
        return clave;
    }

    @Override
    public ArrayList<Habitacion> getHabitaciones() {
        ArrayList<Habitacion> habitacion = new ArrayList<>();
        try {
            this.connect();
            String sql = "select * from habitacion";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                Habitacion c = new Habitacion();
                c.setId(res.getInt("habt_id"));
                c.setDescripcion(res.getString("habt_descripcion"));
                c.setPrecio(res.getInt("habt_precio"));
                c.setTipo(TipoHabitacion.valueOf(res.getString("habt_tipo")));
                c.setFoto(res.getString("habt_foto"));
                habitacion.add(c);
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(HotelRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar getComponentes de la base de datos", ex);
        }
        return habitacion;
    }

    @Override
    public String addHotel(Hotel hotel) {
        try {

            this.connect();
            int cont;
            String sql = "insert into hotel values(?,?,?,?,?,'customer')";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            cont = 1;
            pstmt.setInt(cont, hotel.getId());
            cont++;
            pstmt.setString(cont, hotel.getNombre());
            cont++;
            pstmt.setString(cont, hotel.getDirecccion());
            cont++;
            pstmt.setString(cont, hotel.getCiudad());
            cont++;
            pstmt.setString(cont, hotel.getTelefono());
            System.out.println(pstmt.toString());
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(HotelRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
            return "Error, el hotel con ese id ya existe";
        }

        return "Hotel añadido correctamente";
    }

    @Override
    public String addPersona(Persona persona, String tipo) {
        try {

            this.connect();
            int cont;
            String sql = "insert into persona values(?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            cont = 1;
            pstmt.setInt(cont, persona.getId());
            cont++;
            pstmt.setString(cont, persona.getNombre());
            cont++;
            pstmt.setString(cont, persona.getTelefono());
            cont++;
            pstmt.setString(cont, persona.getDireccion());
            System.out.println(pstmt.toString());
            pstmt.executeUpdate();
            pstmt.close();
            String sql2 = "insert into Sesion values(?,?,?,?)";
            PreparedStatement pstmt2 = conn.prepareStatement(sql2);
            cont = 1;
            pstmt2.setString(cont, persona.getUsuario());
            cont++;
            pstmt2.setString(cont, persona.getClave());
            cont++;
            pstmt2.setString(cont, tipo);
            cont++;
            pstmt2.setInt(cont, persona.getId());
            System.out.println(pstmt2.toString());
            pstmt2.executeUpdate();
            pstmt2.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(HotelRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
            return "Error, la persona con ese id ya existe";
        }

        return "Persona añadido correctamente";
    }

    /**
     * Permite hacer la conexion con la base de datos
     *
     * @return
     */
    public int connect() {
        try {
            Class.forName(Utilities.loadProperty("server.db.driver"));
            //crea una instancia de la controlador de la base de datos
            String url = Utilities.loadProperty("server.db.url");
            String username = Utilities.loadProperty("server.db.username");
            String pwd = Utilities.loadProperty("server.db.password");
            conn = DriverManager.getConnection(url, username, pwd);
            return 1;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(HotelRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Customer de la base de datos", ex);
        }
        return -1;
    }

    /**
     * Cierra la conexion con la base de datos
     *
     */
    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(HotelRepositoryImplMysql.class.getName()).log(Level.FINER, "Error al cerrar Connection", ex);
        }
    }


}
