package org.wai.liquibase.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "car")
@NamedQueries({
        @NamedQuery(name = "c.findAll", query = "Select o From Car o Order By o.color") })
public class Car implements Serializable {

  private static final long serialVersionUID = -7416863802137838316L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String color;

    @Column
    private String price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}