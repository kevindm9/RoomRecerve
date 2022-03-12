package co.mycompany.hotel.server.access;

import co.mycompany.hotel.commons.domain.Persona;
import co.mycompany.hotel.commons.domain.DiaSemana;
import co.mycompany.hotel.commons.domain.Hotel;
import co.mycompany.hotel.commons.domain.Habitacion;
import co.mycompany.hotel.commons.domain.Reserva;
import co.mycompany.hotel.commons.domain.TipoHabitacion;
import co.mycompany.hotel.commons.infra.Utilities;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    public ArrayList<Habitacion> getDiaHabitaciones(int idPersona) {
        ArrayList<Habitacion> menu = new ArrayList();
        try {
            this.connect();

            String sql = "select * from reserva natural join habitacion where persona_id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Integer.toString(idPersona));
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
    public ArrayList<Hotel> getHoteles(String usuario) {
        ArrayList<Hotel> hoteles = new ArrayList();

        try {
            this.connect();
            PreparedStatement pstmt;
            if (usuario.equals("All_Hotels")) {
                String sql = "SELECT * from hotel";
                pstmt = conn.prepareStatement(sql);
            } else {
                String sql = "SELECT * from hotel where ses_usuario = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, usuario);
            }

            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                Hotel hotel = new Hotel();
                hotel.setId(Integer.parseInt(res.getString("hotel_id")));
                hotel.setNombre(res.getString("hotel_nombre"));
                hotel.setDirecccion(res.getString("hotel_direccion"));
                hotel.setCiudad(res.getString("hotel_ciudad"));
                hotel.setTelefono(res.getString("hotel_telefono"));
                hotel.setFoto(res.getString("hotel_foto"));
                hotel.setAdministrador(res.getString("ses_usuario"));
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
            String sql = "insert into habitacion values(null,?,?,?,?,?)";
            System.out.println(sql);
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
            cont++;
            pstmt.setInt(cont, habitacion.getId_hotel());
            System.out.println(pstmt.toString());

            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(HotelRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
            return "Error,la habitacion con ese id y nombre ya existe";
        }
        return "Habitacion añadida correctamente";
    }

    @Override
    public Habitacion getHabitacion(int id) {
        Habitacion habitacion = new Habitacion();
        try {
            this.connect();
            int cont = 0;
            String sql = "SELECT * FROM habitacion where  habt_id = ? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            cont = 1;
            pstmt.setInt(cont, id);
            System.out.println(pstmt.toString());
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                Habitacion c = new Habitacion();
                c.setId(res.getInt("habt_id"));
                c.setDescripcion(res.getString("habt_descripcion"));
                c.setPrecio(res.getInt("habt_precio"));
                c.setTipo(TipoHabitacion.valueOf(res.getString("habt_tipo")));
                c.setFoto(res.getString("habt_foto"));
                c.setId_hotel(res.getInt("hotel_id"));
                habitacion = c;
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(HotelRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar getComponentes de la base de datos", ex);
        }
        return habitacion;
    }

    @Override
    public String ModificarHabitacion(Habitacion habitacion) {
        System.out.println(" aqui si ");
        try {
            this.connect();
            int cont;
            String sql = "UPDATE habitacion SET habt_descripcion = ?, habt_precio = ?, habt_tipo = ?, habt_foto=?  WHERE habt_id = ?";
            System.out.println(sql);
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
            cont++;
            pstmt.setInt(cont, habitacion.getId());
            System.out.println(pstmt.toString());

            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(HotelRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
            return "Error, el componente con ese id y nombre ya existe";
        }
        return "Habitacion modificada correctamente";
    }

    @Override
    public String addReserva(int idHotel, Habitacion habitacion,Date fecha_inicio, Date fecha_fin, Persona sesion) {
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
            System.out.println("psmt :"+pstmt.toString());
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(HotelRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        return "Habitacion añadido correctamente";
    }

    @Override
    public ArrayList<Reserva> getReserva() {
        ArrayList<Reserva> reservas = new ArrayList();
        try {
            this.connect();
            String sql = "SELECT * from reserva";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                Reserva reserva=new Reserva();
                reserva.setId_hotel(Integer.parseInt(res.getString("hotel_id")));
                reserva.setId_habitacion(Integer.parseInt(res.getString("habt_id")));
                reserva.setFechaInicio(res.getDate("fecha_inicio"));
                reserva.setFechaFin(res.getDate("fecha_fin"));
                reserva.setId_persona(Integer.parseInt(res.getString("persona_id")));
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(HotelRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Customer de la base de datos", ex);
        }
        return reservas;
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
    public String deleteHabitacion(Habitacion habitacion) {
            try {
            this.connect();
            int cont;
            String sql = "delete from habitacion where  habt_id=? and hotel_id=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            cont = 1;
            pstmt.setInt(cont, habitacion.getId());
            cont++;
            pstmt.setInt(cont, habitacion.getId_hotel());
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(HotelRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        return "Habitacion se ha eliminado correctamente";
    }
    @Override
    public Persona getPersona(String usuario) {
        Persona p = new Persona();
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
    public String getSesionTipo(String usuario) {
        String tipo = null;
        try {
            this.connect();
            String sql = "select * from sesion where ses_usuario=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, usuario);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                tipo = res.getString("ses_rango");
            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(HotelRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar getMenuDia de la base de datos", ex);
        }
        return tipo;
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
    public ArrayList<Habitacion> getHabitaciones(int id_hotel, Date fechaInicio, Date fechafin) {
        ArrayList<Habitacion> habitacion = new ArrayList<>();
        try {
            this.connect();
            int cont = 0;
            String sql = "SELECT * FROM habitacion where  hotel_id = ? and habt_id not in "
                    + "(select distinct habt_id from reserva "
                    + "where  hotel_id = ? and ((fecha_inicio<= ? and fecha_fin >= ?) "
                    + "or (fecha_inicio<= ? and fecha_fin >= ?)or ((fecha_inicio>= ? and fecha_fin <= ?))))";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            cont = 1;
            pstmt.setInt(cont, id_hotel);
            cont++;
            pstmt.setInt(cont, id_hotel);
            cont++;
            pstmt.setDate(cont, fechaInicio);
            cont++;
            pstmt.setDate(cont, fechaInicio);
            cont++;
            pstmt.setDate(cont, fechafin);
            cont++;
            pstmt.setDate(cont, fechafin);
            cont++;
            pstmt.setDate(cont, fechaInicio);
            cont++;
            pstmt.setDate(cont, fechafin);
            System.out.println(pstmt.toString());
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
    public String addHotel(Hotel hotel,String usuario) {
        try {

            this.connect();
            int cont;
            String sql = "insert into hotel values(null,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            cont = 1;
//            pstmt.setInt(cont, hotel.getId());
//            cont++;
            pstmt.setString(cont, hotel.getNombre());
            cont++;
            pstmt.setString(cont, hotel.getDirecccion());
            cont++;
            pstmt.setString(cont, hotel.getCiudad());
            cont++;
            pstmt.setInt(cont, Integer.parseInt(hotel.getTelefono()));
            cont++;
            pstmt.setString(cont, hotel.getFoto());
            cont++;
            pstmt.setString(cont, usuario);
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
    public String updatePersona(Persona persona, String tipo) {
        try {
            this.connect();
            int cont;
            String sql = "UPDATE persona SET persona_tel = ?, persona_dir = ? where persona_id = ?";
            System.out.println(sql);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            cont = 1;
            pstmt.setString(cont, persona.getTelefono());
            cont++;
            pstmt.setString(cont, persona.getDireccion());
            cont++;
            pstmt.setInt(cont, persona.getId());
            System.out.println(pstmt.toString());
            pstmt.executeUpdate();
            pstmt.close();
            String sql2 = "UPDATE sesion SET ses_clave = ?, ses_rango = ? where ses_usuario = ? and persona_id = ?";
            PreparedStatement pstmt2 = conn.prepareStatement(sql2);
            cont = 1;
            pstmt2.setString(cont, persona.getClave());
            cont++;
            pstmt2.setString(cont, tipo);
            cont++;
            pstmt2.setString(cont, persona.getUsuario());
            cont++;
            pstmt2.setInt(cont, persona.getId());
            System.out.println(pstmt2.toString());
            pstmt2.executeUpdate();
            pstmt2.close();
            this.disconnect();
            
        } catch (SQLException ex) {
            Logger.getLogger(HotelRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
            return "Error, el componente con ese id y nombre ya existe";
        }
        return "Habitacion modificada correctamente";
    }
    @Override
    public String updateHotel(Hotel hotel,String usuario) {
        try {
            this.connect();
            int cont;
            String sql = "update hotel set hotel_nombre = ?, hotel_direccion = ?"
                    + ", hotel_ciudad = ?, hotel_telefono = ?, hotel_foto=?"
                    + ", ses_usuario = ? where hotel_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            cont = 1;
            pstmt.setString(cont, hotel.getNombre());
            cont++;
            pstmt.setString(cont, hotel.getDirecccion());
            cont++;
            pstmt.setString(cont, hotel.getCiudad());
            cont++;
            pstmt.setInt(cont, Integer.parseInt(hotel.getTelefono()));
            cont++;
            pstmt.setString(cont, hotel.getFoto());
            cont++;
            pstmt.setString(cont, hotel.getAdministrador());
            cont++;
            pstmt.setInt(cont, hotel.getId());  
            System.out.println("Actualizacion: "+ pstmt.toString());
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(HotelRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        return "Hotel Actualizado con exito";
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

    @Override
    public String deleteHotel(int id_hotel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deleteReserva(Reserva reserva) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deletePersona(int id, String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String updateReserva(Reserva reserva) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }





}
