package org.wai.liquibase.example.service;


import org.springframework.stereotype.Service;
import org.wai.liquibase.example.model.Bike;
import org.wai.liquibase.example.model.Car;

import java.util.List;

@Service
public interface DemoService {

  List<Car> getAllCars();

  List<Bike> getAllBikes();



}
