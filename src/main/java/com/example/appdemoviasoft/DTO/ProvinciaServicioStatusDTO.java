package com.example.appdemoviasoft.DTO;

import java.util.List;

public class ProvinciaServicioStatusDTO {

 private String Provincia;
 private List<ServicioActualProvincia> servicioActualProvinciaList;

 public ProvinciaServicioStatusDTO(String provincia, List<ServicioActualProvincia> servicioActualProvinciaList) {
  Provincia = provincia;
  this.servicioActualProvinciaList = servicioActualProvinciaList;
 }

 public String getProvincia() {
  return Provincia;
 }

 public void setProvincia(String provincia) {
  Provincia = provincia;
 }

 public List<ServicioActualProvincia> getServicioActualProvinciaList() {
  return servicioActualProvinciaList;
 }

 public void setServicioActualProvinciaList(List<ServicioActualProvincia> servicioActualProvinciaList) {
  this.servicioActualProvinciaList = servicioActualProvinciaList;
 }
}
