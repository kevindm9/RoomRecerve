package co.mycompany.hotel.cliente.access;

import co.mycompany.hotel.commons.domain.Habitacion;
import co.mycompany.hotel.commons.domain.DiaSemana;
import java.util.ArrayList;
import co.mycompany.hotel.commons.domain.Hotel;

/**
 * Interface que define los servicios de persistencia de Clientes de la agencia
 *
 * @author Kevin Morales
 */
public interface IHotelAccess {

    /**
     * Adiciona un componenete a la base de datos
     * @param habitacion
     * @return
     */
    public String addHabitacion(Habitacion habitacion);
    /**
     * obtiene todos los habitacions registrados
     * @return 
     */
    public ArrayList<Habitacion> getHabitaciones();
    /**
     * Obtiene el menu de los componenetes en un hotel y dia determinado
     * @param idHotel
     * @param dia
     * @return 
     */
    public ArrayList<Habitacion> getDiaHabitaciones(int idHotel,DiaSemana dia);
    /**
     * Adiciona un habitacion en un hotel determinado y dia determinado
     * @param idHotel
     * @param habitacion
     * @param dia
     * @return
     */
    public String addHabitacionSemanal(int idHotel,Habitacion habitacion,DiaSemana dia);
    /**
     * Elimina un habitacion de un hotel determinado en un dia determinado
     * @param idHotel
     * @param habitacion
     * @param dia
     * @return
     */
    public String deleteHabitacionSemanal(int idHotel,Habitacion habitacion,DiaSemana dia);
    /**
     * obtiene la lista de todos los hotels
     * @return 
     */
    public ArrayList<Hotel> getHotels();
    /**
     * obtiene la clave del administrador en caso de existir
     * @param usuario
     * @return 
     */
    public String getAdministrador(String usuario);
    
     public String addHotel(Hotel hotel);
}
