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
    private ArrayList<Habitacion> habitaciones;

    public Hotel() {
    }

    public Hotel(int id, String nombre, String direccion, String ciudad, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direcccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.habitaciones = new ArrayList<>();

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

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Restaurante{" + "id=" + id + ", nombre=" + nombre + ", direcccion=" + direcccion + ", ciudad=" + ciudad + ", telefono=" + telefono + ", foto=" + foto + ", habitaciones=" + habitaciones + '}';
    }

}
