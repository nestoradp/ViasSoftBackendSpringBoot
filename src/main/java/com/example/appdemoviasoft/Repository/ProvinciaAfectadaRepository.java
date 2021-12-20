package com.example.appdemoviasoft.Repository;


import com.example.appdemoviasoft.DTO.ProvinciaAfectadaDTO;
import com.example.appdemoviasoft.Entity.HistoryStatusServicio;
import com.example.appdemoviasoft.Entity.HistoryStatusServicio_;
import com.example.appdemoviasoft.Entity.Provincia_;
import com.example.appdemoviasoft.Entity.Status;
import org.hibernate.query.criteria.internal.OrderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class ProvinciaAfectadaRepository {

 @Autowired
    EntityManager entityManager;

 @Autowired
    IHistoryStatusServicioRepository historyStatusServicioRepository;


public ProvinciaAfectadaDTO ConsultarProvinciaAfectada(){
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<ProvinciaAfectadaDTO> query = criteriaBuilder.createQuery(ProvinciaAfectadaDTO.class);
    Root<HistoryStatusServicio> root = query.from(HistoryStatusServicio.class);

  query.multiselect(
          root.get(HistoryStatusServicio_.provincia).get(Provincia_.nombre),
          criteriaBuilder.count(root.get(HistoryStatusServicio_.provincia).get(Provincia_.id)));

  query.where(
          criteriaBuilder.or(
                  criteriaBuilder.equal(root.get(HistoryStatusServicio_.STATUS), Status.INACTIVO),
                  criteriaBuilder.equal(root.get(HistoryStatusServicio_.STATUS), Status.PENDIENTE)
          ));

     query.groupBy(
             root.get(HistoryStatusServicio_.provincia).get(Provincia_.nombre),
             root.get(HistoryStatusServicio_.provincia).get(Provincia_.id));

       query.orderBy(new OrderImpl(criteriaBuilder.count(root.get(HistoryStatusServicio_.provincia).get(Provincia_.id)), false));

  var result = entityManager.createQuery(query);
    ProvinciaAfectadaDTO provinciaAfectadaDTO = new ProvinciaAfectadaDTO();
    if(result.getResultList().size()>0){
        provinciaAfectadaDTO = result.setMaxResults(1).getSingleResult();
    }

         return provinciaAfectadaDTO;

}




}
