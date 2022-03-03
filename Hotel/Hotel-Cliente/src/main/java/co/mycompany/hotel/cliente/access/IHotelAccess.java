package co.mycompany.hotel.cliente.access;

import co.mycompany.hotel.commons.domain.Habitacion;
import co.mycompany.hotel.commons.domain.DiaSemana;
import java.util.ArrayList;
import co.mycompany.hotel.commons.domain.Hotel;
import co.mycompany.hotel.commons.domain.Persona;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Interface que define los servicios de persistencia de Clientes de la agencia
 *
 * @author Kevin Morales
 */
public interface IHotelAccess {

    /**
     * Adiciona un componenete a la base de datos
     *
     * @param habitacion
     * @return
     */
    public String addHabitacion(Habitacion habitacion);

    /**
     * obtiene todos los habitacions registrados
     *
     * @return
     */
    public ArrayList<Habitacion> getHabitaciones(int id_hotel, Date fechaInicio, Date fechafin);

    /**
     *
     * @param usuario
     * @return
     */
    public Persona getPersona(String usuario);
    /**
     * Obtiene el menu de los componenetes en un hotel y dia determinado
     *
     * @param idHotel
     * @param dia
     * @return
     */
    public ArrayList<Habitacion> getDiaHabitaciones(int idPersona);

    /**
     * Adiciona un habitacion en un hotel determinado y dia determinado
     *
     * @param idHotel
     * @param habitacion
     * @param dia
     * @return
     */
    public String addReserva(int idHotel, Habitacion habitacion, LocalDate fecha_inicio, LocalDate fecha_fin, Persona sesion);

    /**
     * Elimina un habitacion de un hotel determinado en un dia determinado
     *
     * @param idHotel
     * @param habitacion
     * @param dia
     * @return
     */
    public String deleteHabitacionSemanal(int idHotel, Habitacion habitacion, DiaSemana dia);

    /**
     * obtiene la lista de todos los hotels
     *
     * @return
     */
    public ArrayList<Hotel> getHotels(String ses_usuario);

    /**
     * obtiene la clave del administrador en caso de existir
     *
     * @param usuario
     * @return
     */
    public String getSecionClave(String usuario);
    public String getSecionTipo(String usuario);

    public String addHotel(Hotel hotel);

    /**
     * Adicionar una nueva persona a la base de datos
     *
     * @param persona
     * @param tipo
     * @return
     */
    public String addPersona(Persona persona, String tipo);
    
    public ArrayList<Integer> getReserva();
}
