package co.mycompany.hotel.server.access;

import co.mycompany.hotel.commons.domain.Administrador;
import co.mycompany.hotel.commons.domain.DiaSemana;
import co.mycompany.hotel.commons.domain.Hotel;
import co.mycompany.hotel.commons.domain.Habitacion;
import co.mycompany.hotel.commons.domain.TipoHabitacion;
import co.mycompany.hotel.commons.infra.Utilities;
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
     * Obtiene el menu de las habitaciones en un restaurante y dia determinado
     * @param idRestaurante
     * @param dia
     * @return 
     */
    public ArrayList<Habitacion> getDiaHabitaciones(int idHotel,DiaSemana dia);
    /**
     * Adiciona un componente en un restuarante determinado y dia determinado
     * @param idRestaurante
     * @param componente
     * @param dia
     * @return
     */
    public String addHabitacionSemanal(int idiHotel,Habitacion habitacion,DiaSemana dia);
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
    public String getAdministrador(String usuario);
        /**
     * Adiciona un componenete a la base de datos
     * @param hotel
     * @return
     */
    public String addHotel(Hotel hotel);
}
