/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mycompany.hotel.cliente.presentacion;

import co.mycompany.hotel.cliente.domain.services.HotelService;
import co.mycompany.hotel.commons.domain.Hotel;

/**
 *
 * @author Kevin Morales
 */
public class ClientMain {
    private static  FrmMain formPrincipal;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HotelService service = new HotelService();
        //Hotel h=new Hotel(5,"sucu","calle 4","popayan","3213412");
        //System.out.println(service.addHotel(h));
        formPrincipal = new FrmMain(service);
        formPrincipal.setVisible(true);
    }
}
