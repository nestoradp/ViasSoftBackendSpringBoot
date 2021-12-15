package com.example.appdemoviasoft.Repository;

import com.example.appdemoviasoft.Entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IServicioRepository extends JpaRepository<Servicio, UUID> {
}
