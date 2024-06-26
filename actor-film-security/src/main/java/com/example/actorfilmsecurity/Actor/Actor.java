package com.example.actorfilmsecurity.Actor;

import com.example.actorfilmsecurity.Film.Film;
import com.example.actorfilmsecurity.Gender.Gender;
import com.example.actorfilmsecurity.Nationality.Nationality;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "nationality_id")
    private Nationality nationality;
    @NotNull
    private int age;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    private String telephoneNumber;
    private String email;
    @ManyToMany(mappedBy = "actors")
    private List<Film> films;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nationality=" + nationality.getName() +
                ", age=" + age +
                ", gender=" + gender.getGender();
    }
}
