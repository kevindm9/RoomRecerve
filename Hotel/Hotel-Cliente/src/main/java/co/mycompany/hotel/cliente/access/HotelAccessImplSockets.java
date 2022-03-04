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
import co.mycompany.hotel.commons.domain.Persona;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

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
    public String addReserva(int idHotel, Habitacion habitacion, Date fecha_inicio, Date fecha_fin, Persona sesion) {
        String jsonResponse = null;
        String requestJson = addReservaRequestJson(idHotel, habitacion, fecha_inicio, fecha_fin, sesion);
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
    private String addReservaRequestJson(int idHotel, Habitacion habitacion, Date fecha_inicio, Date fecha_fin, Persona sesion) {

        Protocol protocol = new Protocol();
        protocol.setResource("habitacionReserva");
        protocol.setAction("set");
        protocol.addParameter("rest_Id", String.valueOf(idHotel));
        protocol.addParameter("Id", Integer.toString(habitacion.getId()));
        protocol.addParameter("Nombre", habitacion.getDescripcion());
        protocol.addParameter("Precio", Integer.toString(habitacion.getPrecio()));
        protocol.addParameter("Tipo", habitacion.getTipo().name());
        System.out.println("Ide antes de mandar: " + String.valueOf(sesion.getId()));
        protocol.addParameter("sesion_idPe", String.valueOf(sesion.getId()));
        protocol.addParameter("fecha_inicio", String.valueOf(fecha_inicio));
        protocol.addParameter("fecha_fin", String.valueOf(fecha_fin));
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    @Override
    public String addPersona(Persona persona, String tipo) {
        String jsonResponse = null;
        String requestJson = addPersonaRequestJson(persona, tipo);
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

    private String addPersonaRequestJson(Persona persona, String tipo) {

        Protocol protocol = new Protocol();
        protocol.setResource("Persona");
        protocol.setAction("set");
        protocol.addParameter("Id", Integer.toString(persona.getId()));
        protocol.addParameter("Nombre", persona.getNombre());
        protocol.addParameter("Telefono", persona.getTelefono());
        protocol.addParameter("Direccion", persona.getDireccion());
        protocol.addParameter("Usuario", persona.getUsuario());
        protocol.addParameter("Clave", persona.getClave());
        protocol.addParameter("Tipo", tipo);
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
        protocol.addParameter("Foto", habitacion.getFoto());
        protocol.addParameter("Tipo", habitacion.getTipo().name());
        protocol.addParameter("Id_hotel", Integer.toString(habitacion.getId_hotel()));

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    private String modfHabitacionRequestJson(Habitacion habitacion) {

        Protocol protocol = new Protocol();
        protocol.setResource("habitacion");
        protocol.setAction("modificar");
        protocol.addParameter("Id", Integer.toString(habitacion.getId()));
        protocol.addParameter("Descripcio", habitacion.getDescripcion());
        protocol.addParameter("Precio", Integer.toString(habitacion.getPrecio()));
        protocol.addParameter("Foto", habitacion.getFoto());
        protocol.addParameter("Tipo", habitacion.getTipo().name());
        protocol.addParameter("Id_hotel", Integer.toString(habitacion.getId_hotel()));

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;
    }

    @Override
    public ArrayList<Hotel> getHotels(String ses_usuario) {
        String jsonResponse = null;
        String requestJson = getHotelRequestJson(ses_usuario);
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

    private String getHotelRequestJson(String ses_usuario) {
        Protocol protocol = new Protocol();
        protocol.setResource("Hoteles");
        protocol.setAction("get");
        protocol.addParameter("ses_usuario", (ses_usuario));
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
        Hotel hotel = gson.fromJson(jsonHotel, Hotel.class);
        return hotel;

    }

    @Override
    public ArrayList<Habitacion> getHabitaciones(int id_hotel, Date fechaInicio, Date fechafin) {
        String jsonResponse = null;
        //{"resource":"habitacions","action":"get","parameters":[{"name":"rest_id","value":"1"},{"name":"dia","value":"LUNES"}]}
        String requestJson = getHabitacionsRequestJson(id_hotel, fechaInicio, fechafin);
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

    @Override
    public Habitacion getHabitacion(int id) {
        String jsonResponse = null;
        String requestJson = gethabtRequestJson(id);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(HotelAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            return null;
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(HotelAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                return null;
            } else {
                if (jsonResponse.contains("vacio")) {
                    return null;
                }
                Habitacion h = jsonToHabitacion(jsonResponse);
                return h;
            }
        }
    }

    private String gethabtRequestJson(int id) {
        Protocol protocol = new Protocol();
        protocol.setResource("habitacion");
        protocol.setAction("get");
        protocol.addParameter("habt_id", Integer.toString(id));
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    @Override
    public String ModificarHabitacion(Habitacion habitacion) {
        String jsonResponse = null;
        String requestJson = modfHabitacionRequestJson(habitacion);
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

    private String getHabitacionsRequestJson(int id_hotel, Date fechaInicio, Date fechafin) {
        Protocol protocol = new Protocol();
        protocol.setResource("habitaciones");
        protocol.setAction("get");
        protocol.addParameter("Id_Hotel", Integer.toString(id_hotel));
        protocol.addParameter("fechaInicio", fechaInicio.toString());
        protocol.addParameter("fechaFin", fechafin.toString());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    @Override
    public ArrayList<Habitacion> getDiaHabitaciones(int idPersona) {
        String jsonResponse = null;
        //{"resource":"habitacions","action":"get","parameters":[{"name":"rest_id","value":"1"},{"name":"dia","value":"LUNES"}]}
        String requestJson = getHabitacionsRequestJson(idPersona);
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

    private String getHabitacionsRequestJson(int idPersona) {
        Protocol protocol = new Protocol();
        protocol.setResource("habitaciones");
        protocol.setAction("getReserva");
        protocol.addParameter("hotel_id", String.valueOf(idPersona));

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
            if (jsonToHabitacion(jsonRes) != null) {
                habitacions.add(jsonToHabitacion(jsonRes));
            }
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
        Habitacion habitacion = null;
        Gson gson = new Gson();
        try {
            habitacion = gson.fromJson(jsonHabitacion, Habitacion.class);
        } catch (Exception e) {
            System.out.println("Elemento vacio");
        }
        return habitacion;
    }

    @Override
    public ArrayList<Integer> getReserva() {
        String jsonResponse = null;
        //{"resource":"habitacions","action":"get","parameters":[{"name":"rest_id","value":"1"},{"name":"dia","value":"LUNES"}]}
        String requestJson = getReservaRequestJson();
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
                return jsonToArrayReserva(jsonResponse);
            }
        }
    }

    private ArrayList<Integer> jsonToArrayReserva(String jsonResponse) {
        ArrayList<Integer> IdHabitaciones = new ArrayList<>();
        String jsonAux = jsonResponse.replace("[", "");
        jsonAux = jsonAux.replace("]", "");
        List<String> jsonHabitacions = Arrays.asList(jsonAux.split("},"));
        for (String jsonRes : jsonHabitacions) {
            if (jsonRes.contains("}") == false) {
                jsonRes += "}";
            }
            IdHabitaciones.add(jsonToReserva(jsonRes));
        }
        return IdHabitaciones;
    }

    private int jsonToReserva(String jsonHabitacion) {
        Gson gson = new Gson();
        int habitacion = gson.fromJson(jsonHabitacion, int.class);
        return habitacion;
    }

    /**
     *
     * @param usuario
     * @return
     */
    @Override
    public Persona getPersona(String usuario) {
        String jsonResponse = null;
        String requestJson = getPersRequestJson(usuario);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(HotelAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            return null;
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(HotelAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                return null;
            } else {
                if (jsonResponse.contains("vacio")) {
                    return null;
                }
                Persona p = jsonToPersona(jsonResponse);
                return p;
            }
        }
    }

    private Persona jsonToPersona(String jsonResponse) {
        Gson gson = new Gson();
        Persona p = gson.fromJson(jsonResponse, Persona.class);
        return p;

    }

    private String getPersRequestJson(String usuario) {
        Protocol protocol = new Protocol();
        protocol.setResource("Persona");
        protocol.setAction("get");
        protocol.addParameter("ses_usuario", usuario);
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    @Override
    public String getSecionTipo(String usuario) {
        String jsonResponse = null;
        String requestJson = getSecionTipoRequestJson(usuario);
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

    private String getSecionTipoRequestJson(String usuario) {
        Protocol protocol = new Protocol();
        protocol.setResource("tipoSesion");
        protocol.setAction("get");
        protocol.addParameter("ses_usuario", usuario);
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    @Override
    public String getSecionClave(String usuario) {
        String jsonResponse = null;
        //{"resource":"administrador","action":"get","parameters":[{"name":"rest_id","value":"1"},{"name":"dia","value":"LUNES"}]}
        String requestJson = getSecionClaveRequestJson(usuario);
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

    private String getSecionClaveRequestJson(String usuario) {
        Protocol protocol = new Protocol();
        protocol.setResource("login");
        protocol.setAction("get");
        protocol.addParameter("ses_usuario", usuario);
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
    public String addHotel(Hotel hotel, String usuario) {
        String jsonResponse = null;
        String requestJson = HotelRequestJson(hotel, usuario,"add");
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

    @Override
    public String updateHotel(Hotel hotel, String usuario) {
        String jsonResponse = null;
        String requestJson = HotelRequestJson(hotel, usuario, "update");
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
        return jsonResponse;
    }

    private String HotelRequestJson(Hotel hotel, String usuario, String metodo) {
        Protocol protocol = new Protocol();
        protocol.setResource("Hotel");
        protocol.setAction(metodo);
        protocol.addParameter("Id", Integer.toString(hotel.getId()));
        protocol.addParameter("Nombre", hotel.getNombre());
        protocol.addParameter("Direccion", hotel.getDirecccion());
        protocol.addParameter("Ciudad", hotel.getCiudad());
        protocol.addParameter("Telefono", hotel.getTelefono());
        protocol.addParameter("Foto", hotel.getFoto());
        protocol.addParameter("User", usuario);
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

    private String getReservaRequestJson() {
        Protocol protocol = new Protocol();
        protocol.setResource("habitacionReserva");
        protocol.setAction("get");
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        return requestJson;
    }

}
