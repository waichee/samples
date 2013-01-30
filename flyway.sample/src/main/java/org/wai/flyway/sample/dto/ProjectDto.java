package org.wai.flyway.sample.dto;

import org.wai.flyway.sample.entity.Employee;

import java.io.Serializable;
import java.util.List;

/**
 * Transfer Object for the Project Entity
 */
public class ProjectDto implements Serializable {

    private String name;
    private List<Employee> employeeList;

    public ProjectDto(){
        super();
    }

    public ProjectDto( String name, List<Employee> employee) {
        this.name = name;
        this.employeeList = employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectDto)) return false;

        ProjectDto that = (ProjectDto) o;

        if (employeeList != null ? !employeeList.equals(that.employeeList) : that.employeeList != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (employeeList != null ? employeeList.hashCode() : 0);
        return result;
    }
}
