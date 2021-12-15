package com.example.appdemoviasoft.Service;

import com.example.appdemoviasoft.Entity.Provincia;
import com.example.appdemoviasoft.Repository.IProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciaService {

   @Autowired
    IProvinciaRepository provinciaRepository;

   public List<Provincia> DevolverProvincia(){
       return provinciaRepository.findAll();
   }

   public void crear(Provincia p){
       provinciaRepository.save(p);
   }








}
