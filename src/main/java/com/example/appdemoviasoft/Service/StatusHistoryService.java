package com.example.appdemoviasoft.Service;


import com.example.appdemoviasoft.Entity.HistoryStatusServicio;
import com.example.appdemoviasoft.Entity.Provincia;
import com.example.appdemoviasoft.Entity.Servicio;
import com.example.appdemoviasoft.Entity.Status;
import com.example.appdemoviasoft.Repository.IHistoryStatusServicioRepository;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@Service
public class StatusHistoryService {

  @Autowired
    IHistoryStatusServicioRepository historyRepository;

  @Autowired
  ServicioService servicioService;

  @Autowired
  ProvinciaService provinciaService;

    public void ObtenerData(Document doc){
        String green = "verde";
        String yellow ="amarela";
        String red = "vermehol";

        HashMap<String, Provincia> ProvinciaMap = new HashMap<>();
        HashMap<String , Servicio> ServicioMap = new HashMap<>();

       String tittle = doc.title();

        System.out.println(tittle);
Element table = doc.getElementById("ctl00_ContentPlaceHolder1_gdvDisponibilidade2");
Elements tr = table.getElementsByTag("tr");

// Recorrer los TR

 for(int i =1; i< tr.size(); i++){
     Element row = tr.get(i);
     Elements col = row.select("td");

    //Recorrer los TD
   for(int j =1; j<col.size(); j++){
       HistoryStatusServicio historyStatusServicio = new HistoryStatusServicio();
       Provincia provincia = ProvinciaMap.get(col.get(0).childNode(0).toString());
       if(provincia==null){
           Provincia NewProvincia = new Provincia();
           NewProvincia.setNombre(col.get(0).childNode(0).toString());
           provinciaService.crear(NewProvincia);
           ProvinciaMap.put(col.get(0).childNode(0).toString(), NewProvincia);
           historyStatusServicio.setProvincia(NewProvincia);
       }else {
           historyStatusServicio.setProvincia(provincia);
       }

      Servicio servicio = ServicioMap.get(tr.get(0).childNode(j+1).childNodes().get(0).toString()) ;
       if(servicio==null){
           Servicio NewServicio = new Servicio();
           NewServicio.setName(tr.get(0).childNode(j+1).childNodes().get(0).toString());
           servicioService.Crear(NewServicio);
           ServicioMap.put(tr.get(0).childNode(j+1).childNodes().get(0).toString(), NewServicio);
           historyStatusServicio.setServicio(NewServicio);
       }else {
           historyStatusServicio.setServicio(servicio);
       }
      Element ele = col.get(j);
      String actualStatus = ele.childNode(0).attributes().toString();
      if(actualStatus.contains(green)){
          historyStatusServicio.setStatus(Status.ACTIVO);
      }else if(actualStatus.contains(yellow)){
          historyStatusServicio.setStatus(Status.PENDIENTE);
      }else if(actualStatus.contains(red)){
          historyStatusServicio.setStatus(Status.INACTIVO);
      }else{
          historyStatusServicio.setStatus(Status.DESCONOCIDO);
      }
   InsertarData(historyStatusServicio);

   }// cierre del for interno
 }
    }

  public void InsertarData(HistoryStatusServicio historyStatus) {
          if(historyStatus.getId()==null){
              historyStatus.setEliminado(false);;
              historyStatus.setCreado(LocalDateTime.now());
          }else{
              historyStatus.setModificado(LocalDateTime.now());
          }
     historyRepository.save(historyStatus);
  }




}
