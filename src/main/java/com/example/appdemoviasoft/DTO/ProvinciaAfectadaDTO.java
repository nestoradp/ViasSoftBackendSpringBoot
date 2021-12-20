package com.example.appdemoviasoft.DTO;

public class ProvinciaAfectadaDTO {

  private String provincia;

  private long tiempoAfectado;

    public ProvinciaAfectadaDTO() {
    }


    public ProvinciaAfectadaDTO(String provincia, long tiempoAfectado) {
        this.provincia = provincia;
        this.tiempoAfectado = tiempoAfectado;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public long getTiempoAfectado() {
        return tiempoAfectado;
    }

    public void setTiempoAfectado(long tiempoAfectado) {
        this.tiempoAfectado = tiempoAfectado;
    }
}
