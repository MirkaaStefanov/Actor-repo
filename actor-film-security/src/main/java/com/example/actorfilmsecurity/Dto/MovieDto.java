package com.example.actorfilmsecurity.Dto;

import com.example.actorfilmsecurity.Actor.Actor;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieDto {
    @NotEmpty
    private String title;
    @NotEmpty
    private String repeatTitle;
    @NotEmpty
    private String genre;

    @NotNull
    @Max(2100)
    @Min(1800)
    private int releaseYear;

    @Size(max = 4, message = "you can add maximum 4 actors")
    @NotEmpty
    private List<Actor> actors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public String getRepeatTitle() {
        return repeatTitle;
    }

    public void setRepeatTitle(String repeatTitle) {
        this.repeatTitle = repeatTitle;
    }
}
