package com.btics.barahimazo;

/**
 * Created by Gisus on 26/02/15.
 */
public class Trago {
    private String nombre;
    private String descripcion;
    private String latitud;
    private String longitud;
    private byte[] image;



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public byte[] getImage() { return image; }

    public void setImage(byte[] image) { this.image = image; }
}
