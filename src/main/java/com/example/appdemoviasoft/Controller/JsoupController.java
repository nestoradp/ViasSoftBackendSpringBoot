package com.example.appdemoviasoft.Controller;

import com.example.appdemoviasoft.Service.StatusHistoryService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin({"*"})
public class JsoupController {

  @Autowired
    StatusHistoryService  statusHistoryService;

  @GetMapping(value="/consult")
  @Scheduled(cron = "${cron.expression}")
    public void ConsultarData(){
   try {
       Document doc = Jsoup.connect("http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx").get();
       statusHistoryService.ObtenerData(doc);


   }catch (Exception error){
       error.printStackTrace();
   }



  }





}
