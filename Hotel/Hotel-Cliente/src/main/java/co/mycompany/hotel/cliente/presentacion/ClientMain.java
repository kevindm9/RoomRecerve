/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mycompany.hotel.cliente.presentacion;

import co.mycompany.hotel.cliente.domain.services.HotelService;
import co.mycompany.hotel.commons.domain.Habitacion;
import co.mycompany.hotel.commons.domain.Hotel;
import co.mycompany.hotel.commons.domain.Persona;
import co.mycompany.hotel.commons.domain.TipoHabitacion;
import java.util.ArrayList;

/**
 *
 * @author Ramira experimentar
 */
public class ClientMain {
    private static  FrmMain formPrincipal;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HotelService service = new HotelService();
//         Persona p1=new Persona();      
//        // System.out.println(i.get(0));
//        Habitacion h=new Habitacion();
//        h=service.getHabitacion(8);
//        h.setDescripcion("super Mega");
//        h.setPrecio(500000);
//        h.setTipo(TipoHabitacion.GRUPAL);
//        h.setId_hotel(3);
//      System.out.println(service.deleteHotel(6));
        formPrincipal = new FrmMain();
        formPrincipal.setVisible(true);
    }
}
