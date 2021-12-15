package com.example.appdemoviasoft.Service;

import com.example.appdemoviasoft.Entity.Servicio;
import com.example.appdemoviasoft.Repository.IServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServicioService {

@Autowired
    IServicioRepository servicioRepository;


public List<Servicio> DevolverServicios(){
    return servicioRepository.findAll();
}

public void Crear(Servicio s){
    if(s.getId()==null){
        s.setEliminado(false);
        s.setCreado(LocalDateTime.now());
    }else{
        s.setModificado(LocalDateTime.now());
    }
    servicioRepository.save(s);
}



}
