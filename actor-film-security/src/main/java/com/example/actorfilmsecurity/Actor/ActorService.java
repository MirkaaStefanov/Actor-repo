package com.example.actorfilmsecurity.Actor;

import com.example.actorfilmsecurity.Dto.ActorDto;
import com.example.actorfilmsecurity.Gender.GenderRepository;
import com.example.actorfilmsecurity.Mapper.ActorMapper;
import com.example.actorfilmsecurity.Nationality.NationalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private NationalityRepository nationalityRepository;
    @Autowired
    private ActorMapper actorMapper;

    public String actorForm(Model model){
        model.addAttribute("actorDto", new ActorDto());
        model.addAttribute("allGenders", genderRepository.findAll());
        model.addAttribute("allNationalities", nationalityRepository.findAll());
        return "actor-form";
    }
    public String submit(ActorDto actorDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("allGenders", genderRepository.findAll());
            model.addAttribute("allNationalities", nationalityRepository.findAll());
            return "actor-form";
        }else{
            Actor actor = actorMapper.toEntity(actorDto);
            actorRepository.save(actor);
            model.addAttribute("actor", actorDto);
            return "actor-result";
        }
    }


}
