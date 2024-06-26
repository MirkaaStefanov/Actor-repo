package com.example.actorfilmsecurity.User;

import com.example.actorfilmsecurity.Dto.UserDto;
import com.example.actorfilmsecurity.Mapper.UserMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper mapper;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration/add")
    public String registrationForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "registration-form";
    }

    @PostMapping("/registration/submit")
    public String postRegister(@Valid UserDto userDto, BindingResult bindingResult, Model model) {

        User userForSeeIfUsernameExist = userRepository.getUserByUsername(userDto.getUsername());
        User userForSeeIfEmailExist = userRepository.getUserByEmail(userDto.getEmail());
        if (bindingResult.hasErrors()) {
            return "registration-form";
        }
        if (userForSeeIfUsernameExist != null) {
            model.addAttribute("userExistMessage", "this username already exist !");
            return "registration-form";
        }
        if (userForSeeIfEmailExist != null) {
            model.addAttribute("emailExistMessage", "this email already exist !");
            return "registration-form";
        }
        if(!userService.ifTwoPasswordsMatch(userDto.getPassword(), userDto.getRepeatPassword())){
            model.addAttribute("passwordsDoNotMatch", "two passwords do not match !");
            return "registration-form";
        }

        User user = mapper.toEntity(userDto);
        userRepository.save(user);
        return "/login";
    }


}
