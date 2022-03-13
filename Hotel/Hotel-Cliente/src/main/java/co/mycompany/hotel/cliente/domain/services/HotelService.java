package co.mycompany.hotel.cliente.domain.services;

import co.mycompany.hotel.cliente.access.Factory;
import co.mycompany.hotel.commons.domain.Hotel;
import co.mycompany.hotel.cliente.access.IHotelAccess;
import co.mycompany.hotel.cliente.infra.Subject;
import co.mycompany.hotel.commons.domain.Habitacion;
import co.mycompany.hotel.commons.domain.DiaSemana;
import co.mycompany.hotel.commons.domain.Persona;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Es una fachada para comunicar la presentación con el dominio
 *
 * @author Kevin Morales
 */
public class HotelService extends Subject {

    private final IHotelAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     */
    public HotelService() {
        this.service = Factory.getInstance().getHotelService();
    }

    /**
     * Adiciona un componenete a la base de datos
     *
     * @param habitacion
     * @return
     */
    public String addHabitacion(Habitacion habitacion) {
        return service.addHabitacion(habitacion);
    }

    /**
     * obtiene todos los habitacions registrados
     *
     * @return
     */
    public ArrayList<Habitacion> getHabitaciones(int id_hotel, Date fechaInicio, Date fechafin) {
        return service.getHabitaciones(id_hotel, fechaInicio, fechafin);
    }

    /**
     * Obtiene el menu de los componenetes en un hotel y dia determinado
     *
     * @param idHotel
     * @param dia
     * @return
     */
    public ArrayList<Habitacion> getDiaHabitaciones(int idPersona) {
        return service.getDiaHabitaciones(idPersona);
    }

    /**
     *
     * @param persona
     * @param tipo
     * @return
     */
    public String addPersona(Persona persona, String tipo) {
        return service.addPersona(persona, tipo);
    }

    /**
     * Adiciona un habitacion en un restuarante determinado y dia determinado
     *
     * @param idHotel
     * @param habitacion
     * @param fecha_inicio
     * @param fecha_fin
     * @param sesion
     * @return
     */
    public String addReserva(int idHotel, Habitacion habitacion, Date fecha_inicio, Date fecha_fin, Persona sesion) {
        return service.addReserva(idHotel, habitacion, fecha_inicio, fecha_fin, sesion);
    }

    /**
     * Elimina un habitacion de un hotel determinado en un dia determinado
     *
     * @param idHotel
     * @param habitacion
     * @param dia
     * @return
     */
    public String deleteHabitacionSemanal(int idHotel, Habitacion habitacion, DiaSemana dia) {
        return service.deleteHabitacionSemanal(idHotel, habitacion, dia);
    }

    /**
     * obtiene la lista de todos los hotels
     *
     * @return
     */
    public ArrayList<Hotel> getHotels(String ses_usuario) {
        return service.getHotels(ses_usuario);
    }

    /**
     * obtiene el plato del un hotel con id
     *
     * @param hotel
     * @return
     */
    public String addHotel(Hotel hotel, String usuario) {
        return service.addHotel(hotel, usuario);
    }

    public String updateHotel(Hotel hotel, String usuario) {
        return service.updateHotel(hotel, usuario);
    }

    public String getSecionTipo(String usuario) {
        return service.getSecionTipo(usuario);
    }

    /**
     * obtiene la clave del administrador en caso de existir
     *
     * @param usuario
     * @return
     */
    public String getSecionClave(String usuario) {
        return service.getSecionClave(usuario);
    }

    public Persona getPersona(String usuario) {
        return service.getPersona(usuario);
    }


    public ArrayList<Integer> getReserva() {
        return service.getReserva();

    }

    /**
     *
     * @param id
     * @return
     */
    public Habitacion getHabitacion(int id) {
        return service.getHabitacion(id);
    }

    /**
     *
     * @param habitacion
     * @return
     */
    public String ModificarHabitacion(Habitacion habitacion) {
        return service.ModificarHabitacion(habitacion);
    }
}
