package com.example.appdemoviasoft.Controller;

import com.example.appdemoviasoft.DTO.ProvinciaDTO;
import com.example.appdemoviasoft.Entity.Provincia;
import com.example.appdemoviasoft.Service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/")
public class ProvinciaController {

 @Autowired
 ProvinciaService provinciaService;


@GetMapping("/ListProvincia")
public List<ProvinciaDTO> DevolverListadoProvincias(){
    List<ProvinciaDTO> lista = new ArrayList<>();
    for (Provincia provincia:provinciaService.DevolverProvincia()) {
        ProvinciaDTO provinciaDTO = new ProvinciaDTO( provincia.getId().toString(), provincia.getNombre());
        lista.add(provinciaDTO);
    }
    return lista;
}


}
