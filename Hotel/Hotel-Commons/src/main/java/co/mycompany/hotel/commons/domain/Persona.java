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
public class Persona {
    String usuario;
    String clave;
    int id;
    String nombre;
    String telefono;
    String direccion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int idPersona) {
        this.id = idPersona;
    }
    ArrayList<Hotel> hoteles;

    public Persona() {}

    public Persona(String usuario, String clave, int id, String nombre, String telefono, String direccion) {
        this.usuario = usuario;
        this.clave = clave;
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
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
