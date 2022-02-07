package co.mycompany.hotel.server.app;

import co.mycompany.hotel.server.infra.HotelServerSocket;



/**
 * Aplicación principal que lanza el servidor en un hilo
 * @author Libardo, Julio
 */
public class HotelApplication {
    public static void main(String args[]){
        HotelServerSocket server = new HotelServerSocket();
        server.start();
    }
}
