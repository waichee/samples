package org.wai.flyway.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wai.flyway.sample.dao.EmployeeDao;
import org.wai.flyway.sample.entity.Employee;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public Employee createNewEmployee(){
        return employeeDao.newEmployee();
    }

    public List<Employee> findAllEmployee(){
        return (List<Employee>) employeeDao.getAllObjects(Employee.class);
    }

    public void save(){
        employeeDao.save();
    }

    public void deleteEmployee(Employee employee) {
        employeeDao.delete(employee);
    }
}
