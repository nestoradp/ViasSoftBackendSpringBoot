package com.example.appdemoviasoft.Repository;

import com.example.appdemoviasoft.Entity.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IProvinciaRepository extends JpaRepository<Provincia, UUID> {
}
