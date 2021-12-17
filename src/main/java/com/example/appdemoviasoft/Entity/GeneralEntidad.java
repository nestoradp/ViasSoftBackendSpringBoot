package com.example.appdemoviasoft.Entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract  class GeneralEntidad implements Entidad{

    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected LocalDateTime creado;

    @LastModifiedDate
    @Column
    protected LocalDateTime modificado;

    @Column
    protected boolean eliminado;


    @Override
    public boolean isEliminado() {
        return false;
    }

    @Override
    public void setEliminado(boolean eliminado) {
      this.eliminado = eliminado;
    }

    @Override
    public LocalDateTime getCreado() {
        return  creado;
    }

    @Override
    public void setCreado(LocalDateTime creado) {
        this.creado= creado;
    }

    @Override
    public LocalDateTime getModificado() {
        return modificado;
    }

    @Override
    public void setModificado(LocalDateTime modificado) {
        this.modificado= modificado;
    }
}
