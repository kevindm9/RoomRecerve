/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mycompany.hotel.cliente.presentacion;

import co.mycompany.hotel.cliente.domain.services.HotelService;
import co.mycompany.hotel.commons.domain.Hotel;
import co.mycompany.hotel.commons.domain.Persona;
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
//         p1=service.getPersona("kevindm");
//         System.out.println(p1.getNombre());
//         ArrayList<Integer> i;
//         i=service.getReserva();         
//        // System.out.println(i.get(0));
//         System.out.println(service.getSecionTipo("kevindm"));
        formPrincipal = new FrmMain();
        formPrincipal.setVisible(true);
    }
}
