/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mycompany.hotel.commons.domain;

import java.util.ArrayList;

/**
 *
 * @author Kevin Morales
 */
public class Administrador {
    String usuario;
    String clave;
    ArrayList<Hotel> hoteles;

    public Administrador() {}
    
    public Administrador(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
        this.hoteles = new ArrayList<>();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public ArrayList<Hotel> getRestaurantes() {
        return hoteles;
    }

    public void setRestaurantes(ArrayList<Hotel> restaurantes) {
        this.hoteles = restaurantes;
    }

    @Override
    public String toString() {
        return "Administrador{" + "usuario=" + usuario + ", clave=" + clave + ", restaurantes=" + hoteles + '}';
    }
    
}
