package com.example.appdemoviasoft.DTO;

import com.example.appdemoviasoft.Entity.Status;

import java.time.LocalDateTime;

public class ServicioActualProvincia {
    private String servicio;
    private Status status;
    private LocalDateTime  creado;

    public ServicioActualProvincia(String servicio, Status status) {
        this.servicio = servicio;
        this.status = status;
    }

    public ServicioActualProvincia(String servicio, Status status, LocalDateTime creado) {
        this.servicio = servicio;
        this.status = status;
        this.creado = creado;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedDate() {
        return creado;
    }

    public void setCreatedDate(String date_time_creado) {
        this.creado = creado;
    }
}
