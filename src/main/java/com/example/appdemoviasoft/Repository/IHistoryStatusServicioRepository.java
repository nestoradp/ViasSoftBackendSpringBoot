package com.example.appdemoviasoft.Repository;

import com.example.appdemoviasoft.Entity.HistoryStatusServicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IHistoryStatusServicioRepository extends JpaRepository<HistoryStatusServicio, UUID> {


}
