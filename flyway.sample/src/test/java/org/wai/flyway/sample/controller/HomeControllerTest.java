package org.wai.flyway.sample.controller;


import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.wai.flyway.sample.dto.AddressDto;
import org.wai.flyway.sample.dto.EntityToDtoConverter;
import org.wai.flyway.sample.dto.ProjectDto;
import org.wai.flyway.sample.entity.Address;
import org.wai.flyway.sample.entity.Employee;
import org.wai.flyway.sample.entity.Project;
import org.wai.flyway.sample.service.AddressService;
import org.wai.flyway.sample.service.EmployeeService;
import org.wai.flyway.sample.service.ProjectService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {


    private MockMvc mockMvc;

    @Mock
    private ProjectService mockProjectService;

    @Mock
    private EmployeeService mockEmployeeService;

    @Mock
    private AddressService  mockAddressService;



    @Before
    public void setup() throws Exception {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        this.mockMvc = standaloneSetup(new HomeController(mockProjectService,mockEmployeeService, mockAddressService))
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    public void shouldRenderHome() throws Exception {

        Project testProject = new Project();
        testProject.setName("P1");
        Project testProject2 = new Project();
        testProject2.setName("P2");
        List<Project> projects = Lists.newArrayList(testProject,testProject2);
        when(mockProjectService.findAllProject()).thenReturn(projects);

        Employee e1 = new Employee();
        Employee e2 = new Employee();
        e1.setName("e1");
        e1.setPosition("position1");
        e2.setName("e2");
        e2.setPosition("position2");
        List<Employee> employees = Lists.newArrayList(e1,e2);
        when(mockEmployeeService.findAllEmployee()).thenReturn(employees);

        when(mockAddressService.findAllAddres()).thenReturn(new ArrayList<Address>());

        mockMvc.perform( get("/home") )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attribute("addressMap", new ArrayList<Address>()))
                .andExpect(model().attribute("employeeMap", employees))
                .andExpect(model().attribute("projectMap", projects))
                .andExpect(model().size(3));
    }
}
