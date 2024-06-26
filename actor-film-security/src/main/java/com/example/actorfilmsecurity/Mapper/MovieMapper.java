package com.example.actorfilmsecurity.Mapper;

import com.example.actorfilmsecurity.Dto.MovieDto;
import com.example.actorfilmsecurity.Film.Film;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public Film toEntity(MovieDto movieDto){
        Film film = new Film();
        film.setTitle(movieDto.getTitle());
        film.setGenre(movieDto.getGenre());
        film.setReleaseYear(movieDto.getReleaseYear());
        film.setActors(movieDto.getActors());
        return film;
    }
}
