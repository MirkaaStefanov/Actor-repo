package com.example.actorfilmsecurity.Actor;

import com.example.actorfilmsecurity.Dto.ActorDto;
import com.example.actorfilmsecurity.Gender.GenderRepository;
import com.example.actorfilmsecurity.Nationality.NationalityRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private NationalityRepository nationalityRepository;
    @Autowired
    private ActorService actorService;

    @GetMapping("/add")
    public String formActor(Model model) {
        return actorService.actorForm(model);
    }

    @PostMapping("/submit")
    public String postActor(@Valid @ModelAttribute ActorDto actorDto, BindingResult bindingResult, Model model) {
        return actorService.submit(actorDto, bindingResult, model);
    }

    @GetMapping("/all")
    public String allActors(Model model) {
        model.addAttribute("allActors", actorRepository.findAll());
        return "actor-all";
    }
    @GetMapping("/update")
    public String updateForm(@RequestParam Integer id, Model model) {
        Optional<Actor> optionalProduct = actorRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Actor actor = actorRepository.findById(id).get();
            model.addAttribute("updateActor",actor);
            model.addAttribute("allGenders", genderRepository.findAll());
            model.addAttribute("allNationalities", nationalityRepository.findAll());
            return "actor-update-form";
        } else {
            return "id could not be find";
        }
    }

    @PostMapping("/update")
    public String postUpdatedActor(@RequestParam Integer id, Model model, @ModelAttribute Actor updatedActor, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("allGenders", genderRepository.findAll());
            model.addAttribute("allNationalities", nationalityRepository.findAll());
            return "product-update-form";
        } else {
            Actor actor = actorRepository.findById(id).get();
            actor.setName(updatedActor.getName());
            actor.setSurname(updatedActor.getSurname());
            actor.setAge(updatedActor.getAge());
            actor.setGender(updatedActor.getGender());
            actor.setNationality(updatedActor.getNationality());

            actorRepository.save(actor);
            model.addAttribute("actor", actor);
            return "actor-update-result";
        }
    }
@PostMapping("/delete")
    public String delete(@RequestParam Integer id, Model model) {

        Actor actor = actorRepository.findById(id).get();
        actorRepository.delete(actor);
        model.addAttribute("actor", actor);
        return "actor-delete";
    }

}
