package com.jorgegilcavazos.nuevoleontravel;

/**
 * Created by TOSHIBA on 8/28/2016.
 */
public class InteresDeportivo {
    private String nombre, direccion, telefono, paginaWeb, informacion;
    private int imageRes, rating;

    public InteresDeportivo(String nombre, String direccion, String telefono, String paginaWeb,
                            String informacion, int imageRes, int rating) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
        this.informacion = informacion;
        this.imageRes = imageRes;
        this.rating = rating;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public String getInformacion() {
        return informacion;
    }

    public int getImageRes() {
        return imageRes;
    }

    public int getRating() {
        return rating;
    }
}
