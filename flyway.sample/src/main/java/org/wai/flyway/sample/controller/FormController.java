package org.wai.flyway.sample.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.wai.flyway.sample.entity.Address;
import org.wai.flyway.sample.entity.Employee;
import org.wai.flyway.sample.entity.Project;
import org.wai.flyway.sample.service.EmployeeService;
import org.wai.flyway.sample.service.ProjectService;

import javax.inject.Inject;

@Controller
@RequestMapping("/form")
public class FormController {

    private final ProjectService projectService;

    private final EmployeeService employeeService;

    @Inject
    public FormController(ProjectService projectService, EmployeeService employeeService) {
        this.projectService = projectService;
        this.employeeService = employeeService;
    }


    @RequestMapping(method=RequestMethod.GET)
    public void form() {
    }

    @RequestMapping(value="employee/add", method=RequestMethod.POST)
    public String addNewEmployeeWithName (@RequestParam String employeeName, @RequestParam String position) {

        Employee employee = employeeService.createNewEmployee();
        employee.setName(employeeName);
        employee.setPosition(position);
        Address address = new Address();
        address.setAddress("Dummy Address");
        address.setPostcode("3000");
        address.setState("VIC");
        address.setCountry("Australia");

        Project project =new Project();
        project.setName("Dummy project");

        employee.setAddress(address);
        employee.setProject(project);

        employeeService.save();

        return "redirect:/home.html";

    }

    @RequestMapping(value="project/add", method=RequestMethod.POST)
    public String addNewProjectWithName (@RequestParam String projectName) {

        Project project = projectService.createNewProject();
        project.setName(projectName);
        projectService.save();
        return "redirect:/home.html";

    }
}
