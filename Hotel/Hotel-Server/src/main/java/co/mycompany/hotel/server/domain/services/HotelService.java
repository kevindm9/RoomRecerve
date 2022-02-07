package co.mycompany.hotel.server.domain.services;

import co.mycompany.hotel.commons.domain.DiaSemana;
import co.mycompany.hotel.commons.domain.Hotel;
import co.mycompany.hotel.commons.domain.Habitacion;
import java.util.ArrayList;
import co.mycompany.hotel.server.access.IHotelRepository;

/**
 * Servicio de clientes. Da acceso a la lógica de negocio
 *
 * @author Kevin Morales
 */
public class HotelService {

    /**
     * Repositorio de clientes
     */
    IHotelRepository repo;

    /**
     * Constructor parametrizado. Hace inyeccion de dependencias
     *
     * @param repo repositorio de tipo IHotelRepository
     */
    public HotelService(IHotelRepository repo) {
        this.repo = repo;
    }

    public ArrayList<Habitacion> getDiaHabitaciones(int idHotel, DiaSemana dia) {
        return repo.getDiaHabitaciones(idHotel, dia);
    }

    public ArrayList<Hotel> getHoteles() {
        return repo.getHoteles();
    }

    public String addHabitacion(Habitacion habitacion) {
        return repo.addHabitacion(habitacion);
    }

    public String addHotel(Hotel hotel) {
        return repo.addHotel(hotel);
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return repo.getHabitaciones();
    }

    public String getAdministrador(String usuario) {
        return repo.getAdministrador(usuario);
    }

    public String addHabitacionSemanal(int idHotel, Habitacion habitacion, DiaSemana dia) {
        return repo.addHabitacionSemanal(idHotel, habitacion, dia);
    }

    public String deleteHabitacionSemanal(int idHotel, Habitacion habitacion, DiaSemana dia) {
        return repo.deleteHabitacionSemanal(idHotel, habitacion, dia);
    }

}
