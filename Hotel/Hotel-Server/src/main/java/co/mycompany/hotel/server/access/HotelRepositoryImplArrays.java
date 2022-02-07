package co.mycompany.hotel.server.access;

import co.mycompany.hotel.commons.domain.DiaSemana;
import co.mycompany.hotel.commons.domain.Habitacion;
import co.mycompany.hotel.commons.domain.Hotel;
import co.mycompany.hotel.commons.domain.Administrador;
import co.mycompany.hotel.commons.domain.TipoHabitacion;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de IRestauranteRepository. Utilliza arreglos en memoria
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public final class HotelRepositoryImplArrays implements IHotelRepository {

    /**
     * Array List de clientes
     */
    private ArrayList<Hotel> hotel;
    private ArrayList<Habitacion> habitacion;
    private ArrayList<Administrador> administradores;
    public HotelRepositoryImplArrays() {
        if (hotel == null){
            hotel = new ArrayList();
            
        }
        if (habitacion==null) {
            habitacion = new ArrayList<>();
        }
        if (administradores==null) {
            administradores = new ArrayList<>();
        }
        inicializarComponentes();
        inicializar();
        
    }
    private void inicializarComponentes(){
    Habitacion h1= new Habitacion(1,"individual",35000, TipoHabitacion.INDIVIDUAL);
    Habitacion h2 = new Habitacion(2,"individual",35000, TipoHabitacion.MATRIMONIAL);

    
        habitacion.add(h1);
        habitacion.add(h2);
        habitacion.add(h1);
   
    }
    private void addHabitacionesHotel(Hotel hotel){
        for (Habitacion habitacion : habitacion) {
            Habitacion c = new Habitacion(habitacion.getId(), habitacion.getDescripcion(),habitacion.getPrecio(), habitacion.getTipo());
            addHabitacionSemanal(hotel.getId(),c , DiaSemana.LUNES);
        }
    }
    public void inicializar() {
        Hotel h = new Hotel(1,"CESAR PALACE","Cra 11 # 3-45","Popayan","800001");
        
        
        hotel.add(h);
        addHabitacionesHotel(h);
        hotel.add(new Hotel(2,"Hotel Sucursal 2","Cra 11 # 3-45","Popayan","800001"));
        hotel.add(new Hotel(3,"Hotel Sucursal 3","Cra 11 # 3-45","Popayan","800001"));
        hotel.add(new Hotel(4,"Hotel Sucursal  4","Cra 11 # 3-45","Popayan","800001"));
        
        Administrador a = new Administrador("admin","1234");
        a.setRestaurantes(hotel);
        administradores.add(a);
    }

    @Override
    public String getAdministrador(String usuario) {
        for (Administrador administrador : administradores) {
            if (administrador.getUsuario().equals(usuario)) {
                return administrador.getClave();
            }
        }
        
        return "null";
    }

    @Override
    public String addHabitacion(Habitacion habitacion1) {
        System.out.println("Aqui entro");
        for (Habitacion h : habitacion) {
            if (h .getId()==habitacion1 .getId() && h .getDescripcion().equals(habitacion1.getDescripcion())) {
                return "Error, el componente con ese id y nombre ya existe";
            }
        }
        habitacion.add(habitacion1);
        return "Habitacion añadido correctamente";
    }

    
    @Override
    public ArrayList<Habitacion> getHabitaciones() {
        ArrayList<Habitacion> compons = new ArrayList<>();
        for (Habitacion habitacion1 : habitacion) {
            Habitacion h = new Habitacion();
            h.setId(habitacion1.getId());
            h.setDescripcion(habitacion1.getDescripcion());
            h.setPrecio(habitacion1.getPrecio());
            h.setTipo(habitacion1.getTipo());
            compons.add(h);
        }
        return compons;        
    }

    @Override
    public ArrayList<Habitacion> getDiaHabitaciones(int idHotel, DiaSemana dia) {
        ArrayList<Habitacion> menuhabitacion = new ArrayList<>();
        for (Hotel hotel1 : hotel) {
            if (hotel1.getId()==idHotel) {
                for (Habitacion habitacion1 : hotel1.getHabitaciones()) {
                    for (DiaSemana dia1 : habitacion1.getDias()) {
                        if (dia1.name().equals(dia.name())) {
                            Habitacion h = new Habitacion();
                            h.setId(habitacion1.getId());
                            h.setDescripcion(habitacion1.getDescripcion());
                            h.setPrecio(habitacion1.getPrecio());
                            h.setTipo(habitacion1.getTipo());
                            menuhabitacion.add(h);
                        }
                    }
                }
            }
        }
        return menuhabitacion;
    }

    @Override
    public String addHabitacionSemanal(int idHotel, Habitacion habitacion, DiaSemana dia) {
        for (Hotel hotel1 : hotel) {
            if (hotel1.getId() == idHotel) {
                for (Habitacion Habitacion1 : hotel1.getHabitaciones()) {
                    for (DiaSemana dia1 : Habitacion1.getDias()) {
                        if (dia1.name().equals(dia.name()) && Habitacion1.getDescripcion().equals(habitacion.getDescripcion())) {
                            return "Error el componente ya existe";
                        }
                    }
                }
                if (habitacion.getDias() == null) {
                    habitacion.setDias(new ArrayList<>());
                }
                habitacion.getDias().add(dia);
                hotel1.getHabitaciones().add(habitacion);

            }
        }
        return "Menu Componente añadido correctamente";
    }

    @Override
    public String deleteHabitacionSemanal(int idHotel, Habitacion habitacion, DiaSemana dia) {
         for (Hotel hotel1 : hotel) {
            if (hotel1.getId()==idHotel) {
                for (Habitacion Habitacion1: hotel1.getHabitaciones()) {
                    for (DiaSemana dia1 : Habitacion1.getDias()) {
                        if (dia1.equals(dia) && habitacion.getDescripcion().equals(Habitacion1.getDescripcion())) {
                            hotel1.getHabitaciones().remove(Habitacion1);
                            return "Menu Componente se elimino correctamente";
                        }
                    }
                    
                }
                
            }
        }
        return "No se pudo eliminar el componente semanal";
    }

    @Override
    public ArrayList<Hotel> getHoteles() {
        ArrayList<Hotel> hoteles = new ArrayList<>();
        for (Hotel h : hotel) {
            Hotel hotel1 = new Hotel();
            hotel1.setId(h.getId());
            hotel1.setNombre(h.getNombre());
            hotel1.setDirecccion(h.getDirecccion());
            hotel1.setCiudad(h.getCiudad());
            hotel1.setTelefono(h.getTelefono());
            hoteles.add(hotel1);
        }
        return hoteles;
    }

    @Override
    public String addHotel(Hotel hotel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
