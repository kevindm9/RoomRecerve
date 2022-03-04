package co.mycompany.hotel.server.infra;

import co.mycompany.hotel.server.domain.services.HotelService;
import co.mycompany.hotel.commons.domain.DiaSemana;
import co.mycompany.hotel.commons.domain.Hotel;
import co.mycompany.hotel.commons.domain.Habitacion;
import co.mycompany.hotel.commons.domain.Persona;
import co.mycompany.hotel.commons.domain.Reserva;
import co.mycompany.hotel.commons.domain.TipoHabitacion;
import co.mycompany.hotel.commons.infra.JsonError;
import co.mycompany.hotel.commons.infra.Protocol;
import co.mycompany.hotel.commons.infra.Utilities;
import co.mycompany.hotel.server.access.Factory;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import co.mycompany.hotel.server.access.IHotelRepository;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Servidor Socket que está escuchando permanentemente solicitudes de los
 * clientes. Cada solicitud la atiende en un hilo de ejecución
 *
 * @author Kevin Morales
 */
public class HotelServerSocket implements Runnable {

    /**
     * Servicio de clientes
     */
    private final HotelService service;
    /**
     * Server Socket, la orejita
     */
    private static ServerSocket ssock;
    /**
     * Socket por donde se hace la petición/respuesta
     */
    private static Socket socket;
    /**
     * Permite leer un flujo de datos del socket
     */
    private Scanner input;
    /**
     * Permite escribir un flujo de datos del scoket
     */
    private PrintStream output;
    /**
     * Puerto por donde escucha el server socket
     */
    private static final int PORT = Integer.parseInt(Utilities.loadProperty("server.port"));

    /**
     * Constructor
     */
    public HotelServerSocket() {
        // Se hace la inyección de dependencia
        IHotelRepository repository = Factory.getInstance().getRepository();
        service = new HotelService(repository);
    }

    /**
     * Arranca el servidor y hace la estructura completa
     */
    public void start() {
        openPort();

        while (true) {
            waitToClient();
            throwThread();
        }
    }

    /**
     * Lanza el hilo
     */
    private static void throwThread() {
        new Thread(new HotelServerSocket()).start();
    }

    /**
     * Instancia el server socket y abre el puerto respectivo
     */
    private static void openPort() {
        try {
            ssock = new ServerSocket(PORT);
            Logger.getLogger("Server").log(Level.INFO, "Servidor iniciado, escuchando por el puerto {0}", PORT);
        } catch (IOException ex) {
            Logger.getLogger(HotelServerSocket.class.getName()).log(Level.SEVERE, "Error del server socket al abrir el puerto", ex);
        }
    }

    /**
     * Espera que el cliente se conecta y le devuelve un socket
     */
    private static void waitToClient() {
        try {
            socket = ssock.accept();
            Logger.getLogger("Socket").log(Level.INFO, "Socket conectado");
        } catch (IOException ex) {
            Logger.getLogger(HotelServerSocket.class.getName()).log(Level.SEVERE, "Eror al abrir un socket", ex);
        }
    }

    /**
     * Cuerpo del hilo
     */
    @Override
    public void run() {
        try {
            createStreams();
            readStream();
            closeStream();

        } catch (IOException ex) {
            Logger.getLogger(HotelServerSocket.class.getName()).log(Level.SEVERE, "Eror al leer el flujo", ex);
        }
    }

    /**
     * Crea los flujos con el socket
     *
     * @throws IOException
     */
    private void createStreams() throws IOException {
        output = new PrintStream(socket.getOutputStream());
        input = new Scanner(socket.getInputStream());
    }

    /**
     * Lee el flujo del socket
     */
    private void readStream() {
        if (input.hasNextLine()) {
            // Extrae el flujo que envió la aplicación cliente
            String request = input.nextLine();
            processRequest(request);

        } else {
            output.flush();
            String errorJson = generateErrorJson();
            output.println(errorJson);
        }
    }

    /**
     * Procesar la solicitud que proviene de la aplicación cliente
     *
     * @param requestJson petición que proviene del cliente socket en formato
     * json que viene de esta manera:
     * "{"resource":"restaurante","action":"get","parameters":[{"name":"id","value":"1"}]}"
     *
     */
    private void processRequest(String requestJson) {
        // Convertir la solicitud a objeto Protocol para poderlo procesar
        Gson gson = new Gson();
        Protocol protocolRequest = gson.fromJson(requestJson, Protocol.class);
        System.out.println(protocolRequest.getResource());
        switch (protocolRequest.getResource()) {
            case "habitacion":

                if (protocolRequest.getAction().equals("set")) {
                    processSetHabitacion(protocolRequest);
                } else if (protocolRequest.getAction().equals("get")) {
                    processGethabitacion(protocolRequest);
                } else if(protocolRequest.getAction().equals("modificar")) {
                    processModfhabitacion(protocolRequest);
                }
                break;
                
            case "Hoteles":
                if (protocolRequest.getAction().equals("get")) {
                    // Obtener datos de hoteles
                    processGetHotel(protocolRequest);
                }
                break;
            case "Hotel":
                processaddHotel(protocolRequest);

                break;
            case "habitaciones":
                if (protocolRequest.getAction().equals("getReserva")) {
                    //{"resource":"componentes","action":"get","parameters":[{"name":"rest_id","value":"1"},{"name":"dia","value":"LUNES"}]}
                    processGetDiaHabitaciones(protocolRequest);
                } else if (protocolRequest.getAction().equals("get")) {
                    processGethabitaciones(protocolRequest);
                }

                break;
            case "login":
                processGetSesionClave(protocolRequest);
                break;
            case "tipoSesion":
                processGetSesionTipo(protocolRequest);
                break;
            case "habitacionReserva":
                if (protocolRequest.getAction().equals("delete")) {
                    processDeleteHabitacionSemanal(protocolRequest);
                } else if (protocolRequest.getAction().equals("set")) {
                    processSetHabitacionReserva(protocolRequest);
                } else if (protocolRequest.getAction().equals("get")) {
                    processGetReserva(protocolRequest);
                }
            case "Persona":
                if (protocolRequest.getAction().equals("set")) {
                    processSetPersona(protocolRequest);
                } else if (protocolRequest.getAction().equals("get")) {
                    processGetPersona(protocolRequest);
                }
        }

    }

    private void processSetPersona(Protocol protocolRequest) {
        Persona persona = new Persona();
        String tipo;
        int cont = 0;
        persona.setId(Integer.parseInt(protocolRequest.getParameters().get(cont++).getValue()));
        persona.setNombre(protocolRequest.getParameters().get(cont++).getValue());
        persona.setTelefono(protocolRequest.getParameters().get(cont++).getValue());
        persona.setDireccion(protocolRequest.getParameters().get(cont++).getValue());
        persona.setUsuario(protocolRequest.getParameters().get(cont++).getValue());
        persona.setClave(protocolRequest.getParameters().get(cont++).getValue());
        tipo = protocolRequest.getParameters().get(cont++).getValue();
        String response = service.addPersona(persona, tipo);
        output.println(response);
    }

    /**
     * Procesa la solicitud de agregar un Habitacion
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processSetHabitacionReserva(Protocol protocolRequest) {
        //Protocol{resource=habitacion, action=set, 
        //parameters=[Parameter{name=Id, value=12}, Parameter{name=Nombre, value=jugo de lulo}, Parameter{name=Tipo, value=BEBIDA}]}
        Habitacion habitacion = new Habitacion();
        Persona sesion = new Persona();
        LocalDate fecha_inicio;
        LocalDate fecha_fin;
        int cont = 0;
        int idHotel = Integer.parseInt(protocolRequest.getParameters().get(cont++).getValue());
        habitacion.setId(Integer.parseInt(protocolRequest.getParameters().get(cont++).getValue()));
        habitacion.setPrecio(Integer.parseInt(protocolRequest.getParameters().get(cont++).getValue()));
        habitacion.setDescripcion(protocolRequest.getParameters().get(cont++).getValue());
        habitacion.setTipo(TipoHabitacion.valueOf(protocolRequest.getParameters().get(cont).getValue()));
        sesion.setUsuario(protocolRequest.getParameters().get(cont++).getValue());
        sesion.setId(Integer.parseInt(protocolRequest.getParameters().get(cont++).getValue()));
        fecha_inicio = LocalDate.parse(protocolRequest.getParameters().get(cont++).getValue());
        fecha_fin = LocalDate.parse(protocolRequest.getParameters().get(cont++).getValue());
        String response = service.addReserva(idHotel, habitacion, fecha_inicio, fecha_fin, sesion);
        output.println(response);
    }

    /**
     * Procesa la solicitud de agregar un Habitacion
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processDeleteHabitacionSemanal(Protocol protocolRequest) {
        //Protocol{resource=componenteSemanal, action=delete, 
        //parameters=[Parameter{name=Id, value=12}, Parameter{name=Nombre, value=jugo de lulo}, Parameter{name=Tipo, value=BEBIDA}]}
        Habitacion habitacion = new Habitacion();
        int cont = 0;
        int idHotel = Integer.parseInt(protocolRequest.getParameters().get(cont++).getValue());
        DiaSemana dia = DiaSemana.valueOf(protocolRequest.getParameters().get(cont++).getValue());
        habitacion.setId(Integer.parseInt(protocolRequest.getParameters().get(cont++).getValue()));
        String response = service.deleteHabitacionSemanal(idHotel, habitacion, dia);
        output.println(response);
    }

    private void processGethabitacion(Protocol protocolRequest) {
        int cont = 0;
        int id = Integer.parseInt(protocolRequest.getParameters().get(cont++).getValue());
        Habitacion habitacion = service.getHabitacion(id);
        String response = objectHabtToJSON(habitacion);
        output.println(response);
    }

    /**
     * Procesa la solicitud de mostrar un Habitaciones
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processGethabitaciones(Protocol protocolRequest) {
        int cont = 0;
        int idHotel = Integer.parseInt(protocolRequest.getParameters().get(cont++).getValue());
        Date fechaInicio = Date.valueOf(protocolRequest.getParameters().get(cont++).getValue());
        Date fechafin = Date.valueOf(protocolRequest.getParameters().get(cont++).getValue());       
        ArrayList<Habitacion> habitacion = service.getHabitaciones(idHotel, fechaInicio, fechafin);
        String response = objectCompToJSON(habitacion);
        output.println(response);
    }

    private String objectHabtToJSON(Habitacion habitacion) {
        Gson gson = new Gson();
        String strObject = gson.toJson(habitacion);
        return strObject;
    }

    private void processGetReserva(Protocol protocolRequest) {
        ArrayList<Integer> idHabitaciones = service.getReserva();
        String response = objectIdHabtToJSON(idHabitaciones);
        output.println(response);
    }

    private String objectIdHabtToJSON(ArrayList<Integer> idHabitaciones) {
        Gson gson = new Gson();
        String strObject = gson.toJson(idHabitaciones);
        return strObject;
    }

    /**
     * Procesa la solicitud de agregar un Habitacion
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processGetDiaHabitaciones(Protocol protocolRequest) {
        ArrayList<Habitacion> habitacion = service.getDiaHabitaciones(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        String response = objectCompToJSON(habitacion);
        output.println(response);
    }

    private String objectCompToJSON(ArrayList<Habitacion> habitacion) {
        Gson gson = new Gson();
        String strObject = gson.toJson(habitacion);
        return strObject;
    }

    private void processGetPersona(Protocol protocolRequest) {
        Persona persona = service.getPersona(protocolRequest.getParameters().get(0).getValue());
        output.println(objectPersToJSON(persona));
    }

    private String objectPersToJSON(Persona p) {
        Gson gson = new Gson();
        String strObject = gson.toJson(p);
        return strObject;
    }

    private void processGetSesionTipo(Protocol protocolRequest) {
        String tipo = service.getSesionTipo(protocolRequest.getParameters().get(0).getValue());
        output.println(tipo);
    }

    private void processGetSesionClave(Protocol protocolRequest) {
        String clave = service.getSesionClave(protocolRequest.getParameters().get(0).getValue());
        output.println(clave);
    }
    private void processModfhabitacion(Protocol protocolRequest) {
       
        Habitacion habitacion = new Habitacion();
        int cont = 0;
        habitacion.setId(Integer.parseInt(protocolRequest.getParameters().get(cont).getValue()));
        cont++;
        habitacion.setDescripcion(protocolRequest.getParameters().get(cont).getValue());
        cont++;
        habitacion.setPrecio(Integer.parseInt(protocolRequest.getParameters().get(cont).getValue()));
        cont++;
        habitacion.setFoto(protocolRequest.getParameters().get(cont).getValue());
        cont++;
        habitacion.setTipo(TipoHabitacion.valueOf(protocolRequest.getParameters().get(cont).getValue()));
        cont++;
        habitacion.setId_hotel(Integer.parseInt(protocolRequest.getParameters().get(cont).getValue()));
        String response = service.ModificarHabitacion(habitacion);
        output.println(response);
    }

    /**
     * Procesa la solicitud de agregar un Habitacion
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processSetHabitacion(Protocol protocolRequest) {
        //Protocol{resource=habitacion, action=set, 
        //parameters=[Parameter{name=Id, value=12}, Parameter{name=Nombre, value=jugo de lulo}, Parameter{name=Tipo, value=BEBIDA}]}

        Habitacion habitacion = new Habitacion();

        int cont = 0;
        habitacion.setId(Integer.parseInt(protocolRequest.getParameters().get(cont).getValue()));
        cont++;
        habitacion.setDescripcion(protocolRequest.getParameters().get(cont).getValue());
        cont++;
        habitacion.setPrecio(Integer.parseInt(protocolRequest.getParameters().get(cont).getValue()));
        cont++;
        habitacion.setFoto(protocolRequest.getParameters().get(cont).getValue());
        cont++;
        habitacion.setTipo(TipoHabitacion.valueOf(protocolRequest.getParameters().get(cont).getValue()));
        cont++;
        habitacion.setId_hotel(Integer.parseInt(protocolRequest.getParameters().get(cont).getValue()));
        String response = service.addHabitacion(habitacion);
        output.println(response);
    }

    /**
     * Procesa la solicitud de agregar un Hotel
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processaddHotel(Protocol protocolRequest) {
        //parameters=[Parameter{name=Id, value=12}, Parameter{name=Nombre, value=jugo de lulo}, Parameter{name=Tipo, value=BEBIDA}]}
        Hotel hotel = new Hotel();
        String usuario="";
        int cont = 0;
        hotel.setId(Integer.parseInt(protocolRequest.getParameters().get(cont).getValue()));
        cont++;
        hotel.setNombre(protocolRequest.getParameters().get(cont).getValue());
        cont++;
        hotel.setDirecccion(protocolRequest.getParameters().get(cont).getValue());
        cont++;
        hotel.setCiudad(protocolRequest.getParameters().get(cont).getValue());
        cont++;
        hotel.setTelefono(protocolRequest.getParameters().get(cont).getValue());
        cont++;
        usuario = protocolRequest.getParameters().get(cont).getValue();
        String response = service.addHotel(hotel,usuario);
        output.println(response);
    }

    private void processGetHotel(Protocol protocolRequest) {
        String usuario = protocolRequest.getParameters().get(0).getValue();
        ArrayList<Hotel> Hotels = service.getHoteles(usuario);
        if (Hotels.isEmpty()) {
            output.println("Hotel vacio");
        } else {
            output.println(objectRestToJSON(Hotels));
        }
    }

    /**
     * Genera un ErrorJson genérico
     *
     * @return error en formato json
     */
    private String generateErrorJson() {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        error.setCode("400");
        error.setError("BAD_REQUEST");
        error.setMessage("Error en la solicitud");
        errors.add(error);

        Gson gson = new Gson();
        String errorJson = gson.toJson(errors);

        return errorJson;
    }

    /**
     * Cierra los flujos de entrada y salida
     *
     * @throws IOException
     */
    private void closeStream() throws IOException {
        output.close();
        input.close();
        socket.close();
    }

    private String objectRestToJSON(ArrayList<Hotel> hoteles) {
        Gson gson = new Gson();
        String strObject = gson.toJson(hoteles);
        return strObject;
    }


}
