package com.example.appdemoviasoft.Controller;

import com.example.appdemoviasoft.DTO.ProvinciaServicioStatusDTO;
import com.example.appdemoviasoft.Service.StatusHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/historyStatus")
public class HistoryStatusServiceController {
  @Autowired
    StatusHistoryService statusHistoryService;


  @GetMapping("StatusByprovincia")
  public ResponseEntity<Map<String, List<ProvinciaServicioStatusDTO>>> DevolverStatusByProvincia(){
    HashMap<String ,List<ProvinciaServicioStatusDTO>> map = new HashMap<>();
       map.put("ListProvinciaStatus", statusHistoryService.DevolverStatusService());

    return new ResponseEntity<Map<String, List<ProvinciaServicioStatusDTO>>>(map, HttpStatus.OK);
  }

  @GetMapping("StatusProvincia/{id}")
  public ResponseEntity<Map<String, Object>> DevolverStatusProvinciaId(@PathVariable(name = "id") UUID id){
    HashMap<String, Object>map= new HashMap<>();
    try{
      ProvinciaServicioStatusDTO provinciaServicioStatusDTO = statusHistoryService.DevolverStatusServicioProvincia(id);
      map.put("Provincia", provinciaServicioStatusDTO);

    }catch (Exception error){
      map.put("Error", error.getMessage());
    }
    return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
  }





}
