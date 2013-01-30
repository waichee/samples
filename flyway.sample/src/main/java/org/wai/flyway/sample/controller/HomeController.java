package org.wai.flyway.sample.controller;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.wai.flyway.sample.dto.AddressDto;
import org.wai.flyway.sample.dto.EntityToDtoConverter;
import org.wai.flyway.sample.dto.ProjectDto;
import org.wai.flyway.sample.entity.Address;
import org.wai.flyway.sample.entity.Project;
import org.wai.flyway.sample.service.AddressService;
import org.wai.flyway.sample.service.EmployeeService;
import org.wai.flyway.sample.service.ProjectService;

import java.util.List;


@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAllEntities() {
        final ModelAndView mav = new ModelAndView();
        mav.setViewName("home");

        List<Address> addressList = addressService.findAllAddres();
        List<AddressDto> addressDtos = Lists.newArrayList(
                Iterables.transform(addressList, EntityToDtoConverter.addressToDtoFunction()));

        List<Project> projectList = projectService.findAllProject();
        List<ProjectDto> projectDtos = Lists.newArrayList(
                Iterables.transform(projectList, EntityToDtoConverter.projectToDtoFunction()));

        mav.addObject("addressMap", addressDtos);
        mav.addObject("employeeMap", employeeService.findAllEmployee());
        mav.addObject("projectMap", projectDtos);

        System.out.println("ProjectDtos size :" + projectDtos.size());
        System.out.println("ProjectDtos size :" + mav.getModel().keySet());

        System.out.println("Model Map size :" + mav.getModelMap().size());
        return mav;
    }

}
