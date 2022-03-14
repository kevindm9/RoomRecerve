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
//        System.out.println(service.getReservaCliente(3).size());
//        service.getReservaHotel(1);
//         Persona p1=new Persona();
//        HotelService service = new HotelService();
//        Persona persona = service.getPersona("jose");
//        System.out.println(persona.toString());
//         p1=service.getPersona("kevindm");
//         System.out.println(p1.getNombre());
//         ArrayList<Integer> i;
//         i=service.getReserva();         
//        // System.out.println(i.get(0));
//        Habitacion h=new Habitacion();
//        h=service.getHabitacion(1);
//        h.setDescripcion("super Mega");
//        h.setPrecio(500000);
//        h.setTipo(TipoHabitacion.GRUPAL);
//      System.out.println(service.ModificarHabitacion(h));
        formPrincipal = new FrmMain();
        formPrincipal.setVisible(true);
//         Persona p1=new Persona();
//         p1=service.getPersona("Cami");
//         p1.setUsuario("Cami");
//         p1.setClave("0000");
//         System.out.println(service.updatePersona(p1, "Cliente"));
        

    }
}
