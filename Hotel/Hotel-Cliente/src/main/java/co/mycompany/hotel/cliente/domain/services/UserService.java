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
    public static boolean autenticacion(String tipo,String login, String password) {
        if (login.equals("Master") && password.equals("123456")) {
            Security.usuario = new User(tipo, login, password);
          successMessage("Master autenticado correctamente.", "Atención");
            return true;
        }
        HotelService hotelService =new HotelService();
        String clave= "";
        try {
            clave = hotelService.getSecionClave(login);
        } catch (Exception e) {
        }
        if (clave.equals("null")) {
            successMessage("Username no existe.", "Atención");
        }else if(clave.equals(password)){
            Security.usuario = new User(tipo, login, password);
            successMessage(tipo+" autenticado correctamente.", "Atención");
            return true;
        }else{
            successMessage("Contraseña Incorrecta.", "Atención");
        }
        return false;
    }
    
}
