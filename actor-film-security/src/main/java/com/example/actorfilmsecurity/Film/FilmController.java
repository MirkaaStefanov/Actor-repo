package com.example.actorfilmsecurity.Film;

import com.example.actorfilmsecurity.Actor.ActorRepository;
import com.example.actorfilmsecurity.Dto.MovieDto;
import com.example.actorfilmsecurity.Helper;
import com.example.actorfilmsecurity.Mapper.MovieMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private FilmService filmService;
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private Helper helper;

    @GetMapping("/add")
    public String formFilm(Model model) {
        model.addAttribute("filmDto", new MovieDto());
        model.addAttribute("allActors", actorRepository.findAll());
        return "film-form";
    }

    @PostMapping("/submit")
    public String postFilm(@Valid @ModelAttribute MovieDto movieDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("filmDto", movieDto);
            model.addAttribute("allActors", actorRepository.findAll());
            return "film-form";
        }
        if (!filmService.ifTwoTitlesMatch(movieDto.getTitle(), movieDto.getRepeatTitle())) {
            model.addAttribute("filmDto", movieDto);
            model.addAttribute("titlesDoNotMatch", "two titles do not match !");
            return "film-form";
        }
        Film film = movieMapper.toEntity(movieDto);
        filmRepository.save(film);
        model.addAttribute("film", film);
        return "film-result";
    }

    @GetMapping("/all")
    public String allFilms(Model model) {
        model.addAttribute("allFilms", filmRepository.findAll());
        return "film-all";
    }

    @GetMapping("/allLeap")
    public String allLeapFilms(Model model) {
        List<Film> leapYearFilms = new ArrayList<>();
        for (Film film : filmRepository.findAll()) {
            if (Helper.ifYearLeap(film.getReleaseYear())) {
                leapYearFilms.add(film);
            }
        }
        model.addAttribute("allLeapFilms",leapYearFilms);
        return "film-all-leap";
    }
}
