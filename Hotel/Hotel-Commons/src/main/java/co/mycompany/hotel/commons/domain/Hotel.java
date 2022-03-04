package co.mycompany.hotel.commons.domain;

import java.util.ArrayList;

/**
 * Restaurante de la tienda online
 *
 * @author Kevin Morales
 */
public class Hotel {

    private int id;
    private String nombre;
    private String direcccion;
    private String ciudad;
    private String telefono;
    private String foto;
    private String administrador;

    public Hotel() {
    }

    public Hotel(int id, String nombre, String direccion, String ciudad, String telefono, String administrador) {
        this.id = id;
        this.nombre = nombre;
        this.direcccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.administrador = administrador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirecccion() {
        return direcccion;
    }

    public void setDirecccion(String direcccion) {
        this.direcccion = direcccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    



}
