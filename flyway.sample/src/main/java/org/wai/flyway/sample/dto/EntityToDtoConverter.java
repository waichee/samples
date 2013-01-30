package org.wai.flyway.sample.dto;


import com.google.common.base.Function;
import org.wai.flyway.sample.entity.Address;
import org.wai.flyway.sample.entity.Project;

public class EntityToDtoConverter {

    public static Function addressToDtoFunction(){
        return new Function(){

            @Override
            public Object apply( Object address) {
                Address address1 = (Address) address;
                return (address != null)? new AddressDto(address1.getAddress(),
                        address1.getCountry(), address1.getPostcode(),
                        address1.getState(),address1.getEmployee()) :null;
            }
        };}

    public static Function projectToDtoFunction(){
        return new Function(){

            @Override
            public Object apply( Object project) {
                Project project1 = (Project) project;
                return (project != null)? new ProjectDto(project1.getName(),project1.getEmployee()) :null;
            }
        };}

}
