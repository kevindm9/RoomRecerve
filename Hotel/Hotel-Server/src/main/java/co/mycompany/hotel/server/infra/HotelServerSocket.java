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
import co.unicauca.serversocket.serversockettemplate.infra.ServerSocketTemplate;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Servidor Socket que está escuchando permanentemente solicitudes de los
 * clientes. Cada solicitud la atiende en un hilo de ejecución
 *
 * @author Kevin Morales
 */
public class HotelServerSocket  extends ServerSocketTemplate {

    /**
     * Servicio de clientes
     */
    private  HotelService service;


    public HotelServerSocket() {
    }


    /**
     * Procesar la solicitud que proviene de la aplicación cliente
     *
     * @param requestJson petición que proviene del cliente socket en formato
     * json que viene de esta manera:
     * "{"resource":"restaurante","action":"get","parameters":[{"name":"id","value":"1"}]}"
     *
     */
     @Override
    protected void processRequest(String requestJson) {
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
                }else if(protocolRequest.getAction().equals("eliminar")) {
                    processDeletehabitacion(protocolRequest);
                }
                break;
                
            case "Hoteles":
                if (protocolRequest.getAction().equals("get")) {
                    // Obtener datos de hoteles
                    processGetHotel(protocolRequest);
                }
                break;
            case "Hotel":
                processHotel(protocolRequest, protocolRequest.getAction());
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
                break;
            case "Persona":
                if (protocolRequest.getAction().equals("set")) {
                    processSetPersona(protocolRequest);
                } else if (protocolRequest.getAction().equals("get")) {
                    processGetPersona(protocolRequest);
                }else if (protocolRequest.getAction().equals("modificar")) {
                    processModfPersona(protocolRequest);
                }
                break;
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
        respond(response);
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
        Date fecha_inicio;
        Date fecha_fin;
        int cont = 0;
        int idHotel = Integer.parseInt(protocolRequest.getParameters().get(cont++).getValue());
        habitacion.setId(Integer.parseInt(protocolRequest.getParameters().get(cont++).getValue()));
        habitacion.setDescripcion(protocolRequest.getParameters().get(cont++).getValue());
        habitacion.setPrecio(Integer.parseInt(protocolRequest.getParameters().get(cont++).getValue()));
        habitacion.setTipo(TipoHabitacion.valueOf(protocolRequest.getParameters().get(cont++).getValue()));
        sesion.setId(Integer.parseInt(protocolRequest.getParameters().get(cont++).getValue()));
        fecha_inicio = Date.valueOf(protocolRequest.getParameters().get(cont++).getValue());
        fecha_fin = Date.valueOf(protocolRequest.getParameters().get(cont++).getValue());
        String response = service.addReserva(idHotel, habitacion, fecha_inicio, fecha_fin, sesion);
        respond(response);
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
        respond(response);
    }
    private void processDeletehabitacion(Protocol protocolRequest) {
        Habitacion habitacion = new Habitacion();
        int cont = 0;
        habitacion.setId(Integer.parseInt(protocolRequest.getParameters().get(cont++).getValue()));
        habitacion.setId_hotel(Integer.parseInt(protocolRequest.getParameters().get(cont++).getValue()));
        String response = service.deleteHabitacion(habitacion);
        respond(response);
    }

    private void processGethabitacion(Protocol protocolRequest) {
        int cont = 0;
        int id = Integer.parseInt(protocolRequest.getParameters().get(cont++).getValue());
        Habitacion habitacion = service.getHabitacion(id);
        String response = objectToJSON(habitacion);
        respond(response);
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
        String response = objectToJSON(habitacion);
        respond(response);
    }



    private void processGetReserva(Protocol protocolRequest) {
        ArrayList<Reserva> res= service.getReserva();
        String response = objectToJSON(res);
        respond(response);
    }



    /**
     * Procesa la solicitud de agregar un Habitacion
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processGetDiaHabitaciones(Protocol protocolRequest) {
        ArrayList<Habitacion> habitacion = service.getDiaHabitaciones(Integer.parseInt(protocolRequest.getParameters().get(0).getValue()));
        String response = objectToJSON(habitacion);
        respond(response);
    }



    private void processGetPersona(Protocol protocolRequest) {
        Persona persona = service.getPersona(protocolRequest.getParameters().get(0).getValue());
        respond(objectToJSON(persona));
    }



    private void processGetSesionTipo(Protocol protocolRequest) {
        String tipo = service.getSesionTipo(protocolRequest.getParameters().get(0).getValue());
        respond(tipo);
    }

    private void processGetSesionClave(Protocol protocolRequest) {
        String clave = service.getSesionClave(protocolRequest.getParameters().get(0).getValue());
        respond(clave);
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
        respond(response);
    }
    private void processModfPersona(Protocol protocolRequest) {
        Persona persona=new Persona();
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
        respond(response);
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
        respond(response);
    }

    /**
     * Procesa la solicitud de agregar un Hotel
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processHotel(Protocol protocolRequest, String metodo) {
        //parameters=[Parameter{name=Id, value=12}, Parameter{name=Nombre, value=jugo de lulo}, Parameter{name=Tipo, value=BEBIDA}]}
        String response = "No se realizo la operacion";
        Hotel hotel = new Hotel();
        String usuario;
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
        hotel.setFoto(protocolRequest.getParameters().get(cont).getValue());
        cont++;
        usuario = protocolRequest.getParameters().get(cont).getValue();
        if (metodo.equals("add")){
            response = service.addHotel(hotel,usuario);
        }
        else if(metodo.equals("update")){
            response = service.updateHotel(hotel,usuario);
        }
        respond(response);
    }

    private void processGetHotel(Protocol protocolRequest) {
        String usuario = protocolRequest.getParameters().get(0).getValue();
        ArrayList<Hotel> Hotels = service.getHoteles(usuario);
        if (Hotels.isEmpty()) {
            respond("Hotel vacio");
        } else {
            respond(objectToJSON(Hotels));
        }
    }


    /**
     * @return the service
     */
    public HotelService getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(HotelService service) {
        this.service = service;
    }
    @Override
    protected ServerSocketTemplate init() {
        PORT = Integer.parseInt(Utilities.loadProperty("server.port"));
        // Se hace la inyección de dependencia
        IHotelRepository repository = Factory.getInstance().getRepository();
        this.setService(new HotelService(repository));
        return this;
    
    }





}
