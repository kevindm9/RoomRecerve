package co.mycompany.hotel.cliente.domain.services;

import co.mycompany.hotel.cliente.access.Factory;
import co.mycompany.hotel.commons.domain.Hotel;
import co.mycompany.hotel.cliente.access.IHotelAccess;
import co.mycompany.hotel.cliente.infra.Subject;
import co.mycompany.hotel.commons.domain.Habitacion;
import co.mycompany.hotel.commons.domain.DiaSemana;
import java.util.ArrayList;

/**
 * Es una fachada para comunicar la presentación con el
 * dominio
 *
 * @author Kevin Morales
 */
public class HotelService extends Subject{

    private final IHotelAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     */
    public HotelService() {
        this.service = Factory.getInstance().getHotelService();
    }

    /**
     * Adiciona un componenete a la base de datos
     * @param habitacion
     * @return
     */
    public String addHabitacion(Habitacion habitacion){
        return service.addHabitacion(habitacion);
    }
    /**
     * obtiene todos los habitacions registrados
     * @return 
     */
    public ArrayList<Habitacion> getHabitaciones(){
        return service.getHabitaciones();
    }   
    /**
     * Obtiene el menu de los componenetes en un hotel y dia determinado
     * @param idHotel
     * @param dia
     * @return 
     */
    public ArrayList<Habitacion> getDiaHabitaciones(int idHotel,DiaSemana dia){
        return service.getDiaHabitaciones(idHotel, dia);
    }
    /**
     * Adiciona un habitacion en un restuarante determinado y dia determinado
     * @param idHotel
     * @param habitacion
     * @param dia
     * @return
     */
    public String addHabitacionSemanal(int idHotel,Habitacion habitacion,DiaSemana dia){
        return service.addHabitacionSemanal(idHotel, habitacion,dia);
    }
    /**
     * Elimina un habitacion de un hotel determinado en un dia determinado
     * @param idHotel
     * @param habitacion
     * @param dia
     * @return
     */
    public String deleteHabitacionSemanal(int idHotel,Habitacion habitacion,DiaSemana dia){
        return service.deleteHabitacionSemanal(idHotel, habitacion,dia);
    }
    
    /**
     * obtiene la lista de todos los hotels
     * @return 
     */
    public ArrayList<Hotel> getHotels(){ 
        return service.getHotels();
    }
    /**
     * obtiene el plato del un hotel con id
     * @param hotel
     * @return 
     */
        public String addHotel(Hotel hotel){
        return service.addHotel(hotel);
    }
    /**
     * obtiene la clave del administrador en caso de existir
     * @param usuario
     * @return 
     */
    public String getAdministrador(String usuario){
        return service.getAdministrador(usuario);
    }
}
