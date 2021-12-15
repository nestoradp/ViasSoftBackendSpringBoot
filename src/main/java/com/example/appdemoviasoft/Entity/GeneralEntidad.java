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
    protected LocalDateTime DateTimeCreado;

    @LastModifiedDate
    @Column
    protected LocalDateTime DateTimeModificado;

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
        return  DateTimeCreado;
    }

    @Override
    public void setCreado(LocalDateTime DateTimeCreado) {
        this.DateTimeCreado= DateTimeCreado;
    }

    @Override
    public LocalDateTime getModificado() {
        return DateTimeModificado;
    }

    @Override
    public void setModificado(LocalDateTime DateTimeModificado) {
        this.DateTimeModificado= DateTimeModificado;
    }
}
