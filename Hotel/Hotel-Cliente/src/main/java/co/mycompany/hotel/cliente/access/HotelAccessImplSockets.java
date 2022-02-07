package co.mycompany.hotel.cliente.access;

import co.mycompany.hotel.cliente.access.IHotelAccess;
import co.mycompany.hotel.commons.infra.Protocol;
import co.mycompany.hotel.commons.infra.JsonError;
import co.mycompany.hotel.cliente.infra.SocketHotel;
import co.mycompany.hotel.commons.domain.Habitacion;
import co.mycompany.hotel.commons.domain.DiaSemana;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import co.mycompany.hotel.commons.domain.Hotel;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Servicio de Cliente. Permite hacer el CRUD de clientes solicitando los
 * servicios con la aplicación server. Maneja los errores devueltos
 *
 * @author Kevin Morales
 */
public class HotelAccessImplSockets implements IHotelAccess {

    /**
     * El servicio utiliza un socket para comunicarse con la aplicación server
     */
    private SocketHotel mySocket;

    public HotelAccessImplSockets() {
        mySocket = new SocketHotel();
    }

    @Override
    public String deleteHabitacionSemanal(int idHotel, Habitacion habitacion, DiaSemana dia) {
        String jsonResponse = null;
        String requestJson = deleteHabitacionSemanalRequestJson(idHotel, habitacion, dia);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(HotelAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            return "No se pudo conectar con el servidor";
        }
        if (jsonResponse.contains("error")) {
            //Devolvió algún error                
            Logger.getLogger(HotelAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
            return extractMessages(jsonResponse);
        }
        //Agregó correctamente el menu, devuelve los nombres de los platos
        return jsonResponse;
    }

    /**
     * Crea una solicitud json para ser enviada por el socket
     *
     * @param habitacion habitacion del plato
     * @return
     */
    private String deleteHabitacionSemanalRequestJson(int idHotel, Habitacion habitacion, DiaSemana dia) {

        Protocol protocol = new Protocol();
        protocol.setResource("habitacionSemanal");
        protocol.setAction("delete");
        protocol.addParameter("rest_Id", String.valueOf(idHotel));
        protocol.addParameter("dia", dia.name());
        protocol.addParameter("Id", Integer.toString(habitacion.getId()));
        protocol.addParameter("Nombre", habitacion.getDescripcion());
        protocol.addParameter("Id", Integer.toString(habitacion.getPrecio()));
        protocol.addParameter("Tipo", habitacion.getTipo().name());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    @Override
    public String addHabitacionSemanal(int idHotel, Habitacion habitacion, DiaSemana dia) {
        String jsonResponse = null;
        String requestJson = addHabitacionSemanalRequestJson(idHotel, habitacion, dia);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(HotelAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            return "No se pudo conectar con el servidor";
        }
        if (jsonResponse.contains("error")) {
            //Devolvió algún error                
            Logger.getLogger(HotelAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
            return extractMessages(jsonResponse);
        }
        //Agregó correctamente el menu, devuelve los nombres de los platos
        return jsonResponse;
    }

    /**
     * Crea una solicitud json para ser enviada por el socket
     *
     * @param habitacion habitacion del plato
     * @return
     */
    private String addHabitacionSemanalRequestJson(int idHotel, Habitacion habitacion, DiaSemana dia) {

        Protocol protocol = new Protocol();
        protocol.setResource("habitacionSemanal");
        protocol.setAction("set");
        protocol.addParameter("rest_Id", String.valueOf(idHotel));
        protocol.addParameter("dia", dia.name());
        protocol.addParameter("Id", Integer.toString(habitacion.getId()));
        protocol.addParameter("Nombre", habitacion.getDescripcion());
        protocol.addParameter("Id", Integer.toString(habitacion.getPrecio()));
        protocol.addParameter("Tipo", habitacion.getTipo().name());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    @Override
    public String addHabitacion(Habitacion habitacion) {
        String jsonResponse = null;
        String requestJson = addHabitacionRequestJson(habitacion);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(HotelAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            return "No se pudo conectar con el servidor";
        }
        if (jsonResponse.contains("error")) {
            //Devolvió algún error                
            Logger.getLogger(HotelAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
            return extractMessages(jsonResponse);
        }
        //Agregó correctamente el menu, devuelve los nombres de los platos
        return jsonResponse;
    }

    /**
     * Crea una solicitud json para ser enviada por el socket
     *
     * @param habitacion habitacion del plato
     * @return
     */
    private String addHabitacionRequestJson(Habitacion habitacion) {

        Protocol protocol = new Protocol();
        protocol.setResource("habitacion");
        protocol.setAction("set");
        protocol.addParameter("Id", Integer.toString(habitacion.getId()));
        protocol.addParameter("Descripcio", habitacion.getDescripcion());
        protocol.addParameter("Precio", Integer.toString(habitacion.getPrecio()));
        protocol.addParameter("Foto",habitacion.getFoto());
        protocol.addParameter("Tipo", habitacion.getTipo().name());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    @Override
    public ArrayList<Hotel> getHotels() {
        String jsonResponse = null;
        String requestJson = getHotelRequestJson();
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(HotelAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            return new ArrayList<>();
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(HotelAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                return new ArrayList<>();
            } else {
                if (jsonResponse.contains("vacio")) {
                    return null;
                }
                //Extrajo correctamente los platos para devolver un arrayList de estos
                return jsonResToArray(jsonResponse);
            }
        }
    }

    private String getHotelRequestJson() {
        Protocol protocol = new Protocol();
        protocol.setResource("Hoteles");
        protocol.setAction("get");
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private ArrayList<Hotel> jsonResToArray(String jsonHotel) {
        ArrayList<Hotel> hotels = new ArrayList<>();
        String jsonAux = jsonHotel.replace("[", "");
        jsonAux = jsonAux.replace("]", "");
        List<String> jsonHotels = Arrays.asList(jsonAux.split("},"));
        for (String jsonRes : jsonHotels) {
            if (jsonRes.contains("}") == false) {
                jsonRes += "}";
            }
            hotels.add(jsonToHotel(jsonRes));
        }
        return hotels;
    }

    /**
     * Convierte jsonHotel, proveniente del server socket, de json a un objeto
     * Hotel
     *
     * @param jsonHotel objeto cliente en formato json
     */
    private Hotel jsonToHotel(String jsonHotel) {

        Gson gson = new Gson();
        //{"id":1,"nombre":"LA COSECHA","direcccion":"Cra 11 # 3-45","ciudad":"Popayan","telefono":"800001","menuSemanal":,"plato":{"id":0,"precio":0,"cantidad":0}
        //{"id":1,"nombre":"LA COSECHA","direcccion":"Cra 11 # 3-45","ciudad":"Popayan","telefono":"800001"}
        Hotel hotel = gson.fromJson(jsonHotel, Hotel.class);
        return hotel;

    }

    @Override
    public ArrayList<Habitacion> getHabitaciones() {
        String jsonResponse = null;
        //{"resource":"habitacions","action":"get","parameters":[{"name":"rest_id","value":"1"},{"name":"dia","value":"LUNES"}]}
        String requestJson = getHabitacionsRequestJson();
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(HotelAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            return new ArrayList<>();
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(HotelAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                return new ArrayList<>();
            } else {
                if (jsonResponse.contains("vacio")) {
                    return null;
                }
                //Extrajo correctamente los platos para devolver un arrayList de estos
                return jsonCompToArray(jsonResponse);
            }
        }
    }

    private String getHabitacionsRequestJson() {
        Protocol protocol = new Protocol();
        protocol.setResource("habitaciones");
        protocol.setAction("get");
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    @Override
    public ArrayList<Habitacion> getDiaHabitaciones(int idHotel, DiaSemana dia) {
        String jsonResponse = null;
        //{"resource":"habitacions","action":"get","parameters":[{"name":"rest_id","value":"1"},{"name":"dia","value":"LUNES"}]}
        String requestJson = getHabitacionsRequestJson(idHotel, dia);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(HotelAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null || jsonResponse.equals("[]")) {
            return new ArrayList<>();
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(HotelAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                return new ArrayList<>();
            } else {
                if (jsonResponse.contains("vacio")) {
                    return null;
                }
                //Extrajo correctamente los platos para devolver un arrayList de estos
                return jsonCompToArray(jsonResponse);
            }
        }
    }

    private String getHabitacionsRequestJson(int idHotel, DiaSemana dia) {
        Protocol protocol = new Protocol();
        protocol.setResource("habitaciones");
        protocol.setAction("getMenu");
        protocol.addParameter("hotel_id", String.valueOf(idHotel));
        protocol.addParameter("dia", dia.name());
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private ArrayList<Habitacion> jsonCompToArray(String jsonHotel) {
        ArrayList<Habitacion> habitacions = new ArrayList<>();
        String jsonAux = jsonHotel.replace("[", "");
        jsonAux = jsonAux.replace("]", "");
        List<String> jsonHabitacions = Arrays.asList(jsonAux.split("},"));
        for (String jsonRes : jsonHabitacions) {
            if (jsonRes.contains("}") == false) {
                jsonRes += "}";
            }
            habitacions.add(jsonToHabitacion(jsonRes));
        }
        return habitacions;
    }

    /**
     * Convierte jsonHotel, proveniente del server socket, de json a un objeto
     * Hotel
     *
     * @param jsonHotel objeto cliente en formato json
     */
    private Habitacion jsonToHabitacion(String jsonHabitacion) {
        Gson gson = new Gson();
        Habitacion habitacion = gson.fromJson(jsonHabitacion, Habitacion.class);
        return habitacion;        
    }

    @Override
    public String getAdministrador(String usuario) {
        String jsonResponse = null;
        //{"resource":"administrador","action":"get","parameters":[{"name":"rest_id","value":"1"},{"name":"dia","value":"LUNES"}]}
        String requestJson = getAdministradorRequestJson(usuario);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(HotelAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            return "No se pudo conectar con el servidor";
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(HotelAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                return extractMessages(jsonResponse);
            } else {
                if (jsonResponse.contains("vacio")) {
                    return null;
                }
                //Extrajo correctamente los platos para devolver un arrayList de estos
                return jsonResponse;
            }
        }
    }

    private String getAdministradorRequestJson(String usuario) {
        Protocol protocol = new Protocol();
        protocol.setResource("administrador");
        protocol.setAction("get");
        protocol.addParameter("adm_usuario", usuario);
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    //------------------------------------------------------------------------------------------------------
    /**
     * Extra los mensajes de la lista de errores
     *
     * @param jsonResponse lista de mensajes json
     * @return Mensajes de error
     */
    private String extractMessages(String jsonResponse) {
        JsonError[] errors = jsonToErrors(jsonResponse);
        String msjs = "";
        for (JsonError error : errors) {
            msjs += error.getMessage();
        }
        return msjs;
    }

    /**
     * Convierte el jsonError a un array de objetos jsonError
     *
     * @param jsonError
     * @return objeto MyError
     */
    private JsonError[] jsonToErrors(String jsonError) {
        Gson gson = new Gson();
        JsonError[] error = gson.fromJson(jsonError, JsonError[].class);
        return error;
    }

    @Override
    public String addHotel(Hotel hotel) {
        String jsonResponse = null;
        String requestJson = addHotelRequestJson(hotel);
        try {

            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();
      
        } catch (IOException ex) {
            Logger.getLogger(HotelAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            return "No se pudo conectar con el servidor";
        }
        if (jsonResponse.contains("error")) {
            //Devolvió algún error                
            Logger.getLogger(HotelAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
            return extractMessages(jsonResponse);
        }
        //Agregó correctamente el menu, devuelve los nombres 

        return jsonResponse;
    }

    private String addHotelRequestJson(Hotel hotel) {
        Protocol protocol = new Protocol();
        protocol.setResource("Hotel");
        protocol.setAction("set");
        protocol.addParameter("Id", Integer.toString(hotel.getId()));
        protocol.addParameter("Nombre", hotel.getNombre());
        protocol.addParameter("Direccion", hotel.getDirecccion());
        protocol.addParameter("Ciudad", hotel.getCiudad());
        protocol.addParameter("Telefono", hotel.getTelefono());
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;

    }
}
