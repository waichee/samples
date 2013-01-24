package org.wai.liquibase.example.dao;

import org.wai.liquibase.example.model.Bike;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class BikeDaoImpl implements BikeDao {

    @PersistenceContext
    private EntityManager em;


    public Bike save(Bike entity) {
        return em.merge(entity);
    }

    public List<Bike> findAll() {
        final Query query = em.createNamedQuery("b.findAll");
        return query.getResultList();
    }

    public Bike findById(Long id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


}
