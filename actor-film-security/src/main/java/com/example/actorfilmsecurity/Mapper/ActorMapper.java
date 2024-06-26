package com.example.actorfilmsecurity.Mapper;

import com.example.actorfilmsecurity.Actor.Actor;
import com.example.actorfilmsecurity.Dto.ActorDto;
import org.springframework.stereotype.Component;

@Component
public class ActorMapper {

    public Actor toEntity(ActorDto actorDto){
        Actor actor = new Actor();
        actor.setName(actorDto.getName());
        actor.setSurname(actorDto.getSurname());
        actor.setNationality(actorDto.getNationality());
        actor.setAge(actorDto.getAge());
        actor.setGender(actor.getGender());
        return actor;
    }
}
