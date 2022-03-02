package co.mycompany.hotel.server.access;

import co.mycompany.hotel.commons.domain.Persona;
import co.mycompany.hotel.commons.domain.DiaSemana;
import co.mycompany.hotel.commons.domain.Hotel;
import co.mycompany.hotel.commons.domain.Habitacion;
import co.mycompany.hotel.commons.domain.TipoHabitacion;
import co.mycompany.hotel.commons.infra.Utilities;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 * Interface del respositorio de clientes
 * @author Kevin Morales
 */
public interface IHotelRepository {

    /**
     * Adiciona un componenete a la base de datos
     * @param habitacion
     * @return
     */
    public String addHabitacion(Habitacion habitacion);
    /**
     * obtiene todos los componentes registrados
     * @return 
     */
    public ArrayList<Habitacion> getHabitaciones();
    /**
     * Obtiene las habitaciones en un Hotel y Fecha determinada
     * @param id_persona
     * @return 
     */
    public ArrayList<Habitacion> getDiaHabitaciones(int id_persona);
    /**
     * Adiciona un componente en un restuarante determinado y dia determinado
     * @param idHotel
     * @param habitacion
     * @param fecha_inicio
     * @param fecha_fin
     * @param sesion
     * @return
     */
    public String addReserva(int idHotel, Habitacion habitacion, LocalDate fecha_inicio,LocalDate fecha_fin,Persona sesion);
    /**
     * Elimina un componente de un restaurante determinado en un dia determinado
     * @param idHotel
     * @param habitacion
     * @param dia
     * @return
     */
    public String deleteHabitacionSemanal(int idHotel,Habitacion habitacion,DiaSemana dia);
   
    /**
     * obtiene la lista de todos los restaurantes
     * @return 
     */
    public ArrayList<Hotel> getHoteles();
    /**
     * obtiene la clave del administrador en caso de existir
     * @param usuario
     * @return 
     */
    public String getSesionClave(String usuario);
    public String getSesionTipo(String usuario);
        /**
     * Adiciona un componenete a la base de datos
     * @param hotel
     * @return
     */
    public String addHotel(Hotel hotel);
    
    /**
     *Adicionar una nueva persona a la base de datos
     * @param persona
     * @param tipo
     * @return
     */
    public String addPersona(Persona persona,String tipo);
   
    public Persona getPersona(String usuario);

    /**
     *
     *
     * @return 
     */
    public ArrayList<Integer> getReserva();
}
