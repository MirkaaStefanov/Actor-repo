package com.example.actorfilmsecurity.Mapper;

import com.example.actorfilmsecurity.Config.BCrypt;
import com.example.actorfilmsecurity.Dto.UserDto;
import com.example.actorfilmsecurity.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private BCrypt bCrypt;

    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(bCrypt.passwordEncoder().encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setEnabled(true);
        user.setRole("User");
        user.setPrice(3);


        return user;
    }

}
