package org.wai.liquibase.example.dao;


import org.wai.liquibase.example.model.Car;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class CarDaoImpl implements CarDao {

    @PersistenceContext
    private EntityManager em;

    public List<Car> findAll() {
        final Query query = em.createNamedQuery("c.findAll");
        return query.getResultList();
    }

    public Car save(Car entity) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Car findById(Long id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

}
