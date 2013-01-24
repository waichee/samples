package org.wai.liquibase.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.wai.liquibase.example.service.DemoService;


@Controller
@RequestMapping("/home")
public class HomeController {

  @Autowired
  private DemoService service;

  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView getTopElements() {

    final ModelAndView mav = new ModelAndView();

    mav.setViewName("home");
    mav.addObject("bikesMap", service.getAllBikes());
      mav.addObject("carsMap", service.getAllCars());

      return mav;
  }

}
