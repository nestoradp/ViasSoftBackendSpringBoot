package com.example.appdemoviasoft.Entity;

public enum Status {

    ACTIVO("ACTIVO"),
    PENDIENTE("PENDIENTE"),
    INACTIVO("INACTIVO"),
    DESCONOCIDO("DESCONOCIDO");

    private String nombre;

   Status(String nombre){
        this.nombre = nombre;

    }

    public String getNombre() {
        return nombre;
    }
}
