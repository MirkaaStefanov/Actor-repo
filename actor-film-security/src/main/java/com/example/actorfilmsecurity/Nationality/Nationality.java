package com.example.actorfilmsecurity.Nationality;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="nationalities")
public class Nationality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    @Column(nullable = false)
    @Size(min = 2)
    private String name;
    @Min(0)
    private double mlnPeople;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMlnPeople() {
        return mlnPeople;
    }

    public void setMlnPeople(double mlnPeople) {
        this.mlnPeople = mlnPeople;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", mlnPeople=" + mlnPeople;
    }
}
