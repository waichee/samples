package org.wai.flyway.sample.dto;

import org.wai.flyway.sample.entity.Employee;

import java.io.Serializable;

/**
 * Transfer Object for the Address Entity
 */
public class AddressDto implements Serializable {

    private String address;
    private String country;
    private String postcode;
    private String state;
    private Employee employee;

    public AddressDto(){
        super();
    }

    public AddressDto(String address, String country,
                      String postcode, String state, Employee employee) {
        this.address = address;
        this.country = country;
        this.postcode = postcode;
        this.state = state;
        this.employee = employee;

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressDto)) return false;

        AddressDto that = (AddressDto) o;

        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (employee != null ? !employee.equals(that.employee) : that.employee != null) return false;
        if (postcode != null ? !postcode.equals(that.postcode) : that.postcode != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = address != null ? address.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        return result;
    }
}
