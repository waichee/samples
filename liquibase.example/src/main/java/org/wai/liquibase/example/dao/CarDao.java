package org.wai.liquibase.example.dao;

import org.springframework.stereotype.Repository;
import org.wai.liquibase.example.model.Car;

import java.util.List;

@Repository
public interface CarDao extends BaseDao<Car> {

    List<Car> findAll();

    Car save(Car entity);

}
