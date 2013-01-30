package org.wai.flyway.sample.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.wai.flyway.sample.entity.Address;
import org.wai.flyway.sample.entity.Employee;
import org.wai.flyway.sample.entity.Project;
import org.wai.flyway.sample.service.EmployeeService;
import org.wai.flyway.sample.service.ProjectService;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(MockitoJUnitRunner.class)
public class FormControllerTest{


    private MockMvc mockMvc;

    @Mock
    private ProjectService mockProjectService;

    @Mock
    private EmployeeService mockEmployeeService;

    @Mock
    private Employee mockEmployee;


    @Before
    public void setup() throws Exception {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        this.mockMvc = standaloneSetup(new FormController(mockProjectService,mockEmployeeService))
                .setViewResolvers(viewResolver)
                .build();
    }


    @Test
    public void shouldGetForm() throws Exception {
        mockMvc.perform( get("/form") )
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void shouldAddNewProjectAndRedirectToHome() throws Exception {

        Project testProject = new Project();

       when(mockProjectService.createNewProject()).thenReturn(testProject);

        mockMvc.perform(
                post("/form/project/add")
                        .param("projectName", "BlahTest Project") )
                .andDo(print())
                .andExpect(redirectedUrl("/home.html"))
                .andExpect(status().isMovedTemporarily());

        verify(mockProjectService, times(1)).createNewProject();
        verify(mockProjectService, times(1)).save();
    }

    @Test
    public void shouldAddNewEmployeeAndRedirectToHome() throws Exception {

        when(mockEmployeeService.createNewEmployee()).thenReturn(mockEmployee);
        mockMvc.perform(
                post("/form/employee/add")
                        .param("employeeName", "John Richard")
                        .param("position", "developer"))
                .andDo(print())
                .andExpect(redirectedUrl("/home.html"))
                .andExpect(status().isMovedTemporarily());

        verify(mockEmployeeService, times(1)).createNewEmployee();
        verify(mockEmployeeService, times(1)).save();
    }

}
