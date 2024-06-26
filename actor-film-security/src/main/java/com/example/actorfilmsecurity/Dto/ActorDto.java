package com.example.actorfilmsecurity.Dto;

import com.example.actorfilmsecurity.Gender.Gender;
import com.example.actorfilmsecurity.Nationality.Nationality;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class ActorDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    @NotNull
    private Nationality nationality;
    @NotNull
    private int age;
    @NotNull
    private Gender gender;

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
}
