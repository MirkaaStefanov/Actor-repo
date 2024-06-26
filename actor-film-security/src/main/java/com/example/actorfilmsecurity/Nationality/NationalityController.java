package com.example.actorfilmsecurity.Nationality;

import com.example.actorfilmsecurity.Actor.Actor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/nationality")
public class NationalityController {

    @Autowired
    private NationalityRepository nationalityRepository;

    @GetMapping("/add")
        public String nationalityForm(Model model){
        model.addAttribute("nationality", new Nationality());
        return "nationality-form";
    }
    @PostMapping("/submit")
    public String postNationality(@Valid @ModelAttribute Nationality nationality, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "nationality-form";
        }else{
            nationalityRepository.save(nationality);
            model.addAttribute("nationality",nationality);
            return "nationality-result";
        }
    }

    @GetMapping("/all")
    public String allNationalities(Model model) {
        model.addAttribute("allNationalities", nationalityRepository.findAll());
        return "nationality-all";
    }
    @GetMapping("/update")
    public String updateForm(@RequestParam Integer id, Model model) {
        Optional<Nationality> optionalProduct = nationalityRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Nationality nationality = nationalityRepository.findById(id).get();
            model.addAttribute("nationality",nationality);
            return "nationality-update-form";
        } else {
            return "id could not be find";
        }
    }

    @PostMapping("/update")
    public String postUpdatedNationality(@RequestParam Integer id, Model model, @ModelAttribute Nationality updatedNationality, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "nationality-update-form";
        } else {
            Nationality nationality = nationalityRepository.findById(id).get();
            nationality.setName(updatedNationality.getName());
            nationality.setMlnPeople(updatedNationality.getMlnPeople());


            nationalityRepository.save(nationality);
            model.addAttribute("nationality", nationality);
            return "nationality-update-result";
        }
    }
    @PostMapping("/delete")
    public String delete(@RequestParam Integer id, Model model) {

        Nationality nationality = nationalityRepository.findById(id).get();
        nationalityRepository.delete(nationality);
        model.addAttribute("nationality", nationality);
        return "nationality-delete";
    }


}
