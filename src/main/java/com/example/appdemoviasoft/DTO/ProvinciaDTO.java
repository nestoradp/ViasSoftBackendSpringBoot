package com.example.appdemoviasoft.DTO;

public class ProvinciaDTO {
    private String id;
    private String nombre;

    public ProvinciaDTO(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public ProvinciaDTO() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
