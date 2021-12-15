package com.example.appdemoviasoft.Entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "servicio")
public class Servicio  extends GeneralEntidad implements Serializable {

   @Id
   @GeneratedValue(generator = "UUID")
   @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
   @Column(name = "id", updatable = false, nullable = false)
   private UUID id;

   @Column(nullable = true)
   private String name;

    public Servicio() {

    }

    @Override
    public UUID getId() {
        return id;
    }
     @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
