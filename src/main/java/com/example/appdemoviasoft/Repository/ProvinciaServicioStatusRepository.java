package com.example.appdemoviasoft.Repository;

import com.example.appdemoviasoft.DTO.ServicioActualProvincia;
import com.example.appdemoviasoft.Entity.HistoryStatusServicio;
import com.example.appdemoviasoft.Entity.HistoryStatusServicio_;
import com.example.appdemoviasoft.Entity.Provincia_;
import com.example.appdemoviasoft.Entity.Servicio_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public class ProvinciaServicioStatusRepository {

  @Autowired
  EntityManager entityManager;
  @Autowired
  IHistoryStatusServicioRepository historyStatusServicioRepository;

  public List<ServicioActualProvincia> DevolverEstado(UUID provincia_id, int cantidad , LocalDateTime inicialDate, LocalDateTime finalDate) {
 var criteriaBuilder= entityManager.getCriteriaBuilder();
   var query= criteriaBuilder.createQuery(ServicioActualProvincia.class);
   var root = query.from(HistoryStatusServicio.class);

    query.multiselect(
            root.get(HistoryStatusServicio_.servicio).get(Servicio_.NAME),
            root.get(HistoryStatusServicio_.STATUS),
         root.get(HistoryStatusServicio_.CREADO)
    );
    if(inicialDate !=null && finalDate !=null){
        query.where(
                criteriaBuilder.and(
                        criteriaBuilder.equal(root.get(HistoryStatusServicio_.provincia).get(Provincia_.id), provincia_id),
                       criteriaBuilder.between(root.get(HistoryStatusServicio_.creado),inicialDate, finalDate)
                )
        );
    }else{
        criteriaBuilder.equal(root.get(HistoryStatusServicio_.provincia).get(Provincia_.id), provincia_id);
    }
       var typedQuery = entityManager.createQuery(query);

     var resultado  = typedQuery.setMaxResults(cantidad).getResultList();

    return resultado;

  }

}

