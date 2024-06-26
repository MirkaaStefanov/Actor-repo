package com.example.actorfilmsecurity.Film;

import org.springframework.stereotype.Service;

@Service
public class FilmService {

    public boolean ifTwoTitlesMatch(String title1, String title2){
        return title1.equals(title2);
    }

}
