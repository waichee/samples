package org.wai.liquibase.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger= LoggerFactory.getLogger(DemoServiceImpl.class);

  @Autowired
  private CarDao carDao;

  @Autowired
  private BikeDao bikeDao;

  @Transactional(readOnly = true)
  public List<Car> getAllCars() {
      logger.info("Finding all cars");
    return carDao.findAll();
  }

  @Transactional(readOnly = true)
  public List<Bike> getAllBikes() {
      logger.info("Finding all bikes");
      return bikeDao.findAll();
  }


}
