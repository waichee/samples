package org.wai.liquibase.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wai.liquibase.example.dao.BikeDao;
import org.wai.liquibase.example.dao.CarDao;
import org.wai.liquibase.example.model.Bike;
import org.wai.liquibase.example.model.Car;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

  @Autowired
  private CarDao carDao;

  @Autowired
  private BikeDao bikeDao;



  @Transactional(readOnly = true)
  public List<Car> getAllCars() {
    return carDao.findAll();
  }

  @Transactional(readOnly = true)
  public List<Bike> getAllBikes() {
    return bikeDao.findAll();
  }


}
