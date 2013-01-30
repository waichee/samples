package org.wai.flyway.sample.dao;

import org.springframework.stereotype.Repository;
import org.wai.flyway.sample.entity.Employee;

@Repository
public class EmployeeDao extends BaseDao{

    public Employee newEmployee(){
        return getObjectContext().newObject(Employee.class);
    }
}
