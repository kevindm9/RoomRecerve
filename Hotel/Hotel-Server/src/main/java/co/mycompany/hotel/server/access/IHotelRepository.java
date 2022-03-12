package co.mycompany.hotel.server.access;

import co.mycompany.hotel.commons.domain.Persona;
import co.mycompany.hotel.commons.domain.DiaSemana;
import co.mycompany.hotel.commons.domain.Hotel;
import co.mycompany.hotel.commons.domain.Habitacion;
import co.mycompany.hotel.commons.domain.Reserva;
import co.mycompany.hotel.commons.domain.TipoHabitacion;
import co.mycompany.hotel.commons.infra.Utilities;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Interface del respositorio de clientes
 *
 * @author Kevin Morales
 */
public interface IHotelRepository {

    /**
     * Adiciona un componenete a la base de datos
     *
     * @param habitacion
     * @return
     */
    public String addHabitacion(Habitacion habitacion);

    /**
     * obtiene una habitacion
     *
     * @param id
     * @return
     */
    public Habitacion getHabitacion(int id);

    /**
     * actualiza datos de una habitacion
     *
     * @param habitacion
     * @return
     */
    public String ModificarHabitacion(Habitacion habitacion);

    /**
     * obtiene todos los componentes registrados
     *
     * @param id
     * @param fechaInicio
     * @return
     */

    public ArrayList<Habitacion> getHabitaciones(int id, Date fechaInicio, Date fechafin);

    /**
     * Obtiene las habitaciones en un Hotel y Fecha determinada
     *
     * @param id_persona
     * @return
     */
    public ArrayList<Habitacion> getDiaHabitaciones(int id_persona);

    /**
     * Adiciona un componente en un restuarante determinado y dia determinado
     *
     * @param idHotel
     * @param habitacion
     * @param fecha_inicio
     * @param fecha_fin
     * @param sesion
     * @return
     */
    public String addReserva(int idHotel, Habitacion habitacion, Date fecha_inicio, Date fecha_fin, Persona sesion);

    /**
     * Elimina un componente de un restaurante determinado en un dia determinado
     *
     * @param idHotel
     * @param habitacion
     * @param dia
     * @return
     */
    public String deleteHabitacionSemanal(int idHotel, Habitacion habitacion, DiaSemana dia);

    /**
     * elimina una habitacion
     *
     * @param habitacion
     * @return
     */
    public String deleteHabitacion(Habitacion habitacion);

    /**
     * obtiene la lista de todos los restaurantes
     *
     * @return
     */
    public ArrayList<Hotel> getHoteles(String usuario);

    /**
     * obtiene la clave del administrador en caso de existir
     *
     * @param usuario
     * @return
     */
    public String getSesionClave(String usuario);

    /**
     * obtiene el tipo del administrador en caso de existir
     *
     * @param usuario
     * @return
     */
    public String getSesionTipo(String usuario);

    /**
     * Adiciona un componenete a la base de datos
     *
     * @param hotel
     * @param sesion
     * @return
     */
    public String addHotel(Hotel hotel, String sesion);

    /**
     * actualiza los datos de hotel
     *
     * @param hotel
     * @param sesion
     * @return
     */

    public String updateHotel(Hotel hotel, String sesion);

    /**
     * Adicionar una nueva persona a la base de datos
     *
     * @param persona
     * @param tipo
     * @return
     */
    public String addPersona(Persona persona, String tipo);

    /**
     * actualiza los datos de una persona a la base de datos
     *
     * @param persona
     * @param tipo
     * @return
     */

    public String updatePersona(Persona persona, String tipo);

    /**
     * retorna los datos de una persona a la base de datos
     *
     * @param usuario
     * @return
     */
    public Persona getPersona(String usuario);

    /**
     *
     *
     * @return
     */
    public ArrayList<Reserva> getReserva();
    
    
     public String deleteHotel(int id_hotel);
     
      public String deleteReserva(Reserva reserva);
      
       public String deletePersona(int id,String tipo);
       
        public String updateReserva(Reserva reserva);
}
