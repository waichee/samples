package org.wai.liquibase.example.dao;

import org.springframework.stereotype.Repository;
import org.wai.liquibase.example.model.Bike;

import java.util.List;

@Repository
public interface BikeDao extends BaseDao<Bike> {

    List<Bike> findAll();

    Bike save(Bike entity);

}
