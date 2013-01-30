package org.wai.flyway.sample.dto;

import java.io.Serializable;

/**
 * Transfer Object for the Employee Entity
 */
public class EmployeeDto implements Serializable {

    private int id;
    private String name;
    private String position;
    private int address_id;
    private int project_id;


    public EmployeeDto(){
        super();
    }

    public EmployeeDto(int id, String name , String position,
                       int address_id, int project_id){
        this.id = id;
        this.name = name;
        this.position = position;
        this.address_id = address_id;
        this.project_id = project_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeDto)) return false;

        EmployeeDto that = (EmployeeDto) o;

        if (address_id != that.address_id) return false;
        if (id != that.id) return false;
        if (project_id != that.project_id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + address_id;
        result = 31 * result + project_id;
        return result;
    }
}
