package com.ddd.project1.mapper;

import com.ddd.project1.dto.PersonDto;
import com.ddd.project1.entity.Person;
import org.springframework.beans.BeanUtils;

public class PersonMapper {

    public static PersonDto entityToDto(Person person){
        PersonDto personDto= new PersonDto();
        BeanUtils.copyProperties(person,personDto);
        return personDto;
    }

    public static Person dtoToEntity(PersonDto personDto){
        Person person= new Person();
        BeanUtils.copyProperties(personDto,person);
        return person;
    }

}
