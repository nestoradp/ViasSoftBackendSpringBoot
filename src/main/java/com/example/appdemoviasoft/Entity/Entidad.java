package com.example.appdemoviasoft.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

public interface Entidad {

    public UUID getId();

    public void setId(UUID id);

    public boolean isEliminado();

    public void setEliminado(boolean eliminado);

    public LocalDateTime getCreado();

    public void setCreado(LocalDateTime DateTimeCreado);

    public LocalDateTime getModificado();

    public void setModificado(LocalDateTime DateTimeModificado);
}
