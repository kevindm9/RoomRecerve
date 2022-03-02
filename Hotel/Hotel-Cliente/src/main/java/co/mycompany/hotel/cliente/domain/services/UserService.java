package co.mycompany.hotel.cliente.domain.services;

import co.mycompany.hotel.cliente.access.Factory;
import co.mycompany.hotel.cliente.domain.User;
import static co.mycompany.hotel.cliente.infra.Messages.successMessage;
import co.mycompany.hotel.cliente.infra.Security;

/**
 * Servicio de usuarios del sistema
 * @author Kevin Morales
 */
public class UserService {
    /**
     * autentica el usuario si y solo si existe el username y la contraseña
     * es correcta.
     * @param login username
     * @param password constraseña
     * @return true si inicio seccion, false si no inicio seccion
     */
    public static String autenticacion(String login, String password) {
        String validar = "";
        HotelService hotelService =new HotelService();       
        try {
            String clave = hotelService.getSecionClave(login);
            if (clave.equals("null")){
                successMessage("Username no existe.", "Atención");

            }
            else{
                if(clave.equals(password)){
                    String tipo = hotelService.getSecionTipo(login);
                    successMessage("Inicio de seccion valido Bienvenido "+login, "Atención");
                    validar = tipo;
                }
                else{
                    successMessage("Contraseña Incorrecta.", "Atención");
                }
            }
         
        } catch (Exception e) {
            successMessage("Error al conectar con el servidor.", "Error");
        }
        return validar;
    }
    
}
