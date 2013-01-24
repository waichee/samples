package org.wai.liquibase.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bike")
@NamedQueries({
        @NamedQuery(name = "b.findAll", query = "Select o From Bike o Order By o.color") })
public class Bike implements Serializable {

  private static final long serialVersionUID = -1108878537928748856L;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bike bike = (Bike) o;

        if (color != null ? !color.equals(bike.color) : bike.color != null) return false;
        if (price != null ? !price.equals(bike.price) : bike.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }


}
