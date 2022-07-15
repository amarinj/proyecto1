package com.ddd.project1.mapper;

import com.ddd.project1.dto.OperationTypeDto;
import com.ddd.project1.dto.PersonTypeDto;
import com.ddd.project1.entity.OperationType;
import com.ddd.project1.entity.PersonType;
import org.springframework.beans.BeanUtils;

public class PersonTypeMapper {

    public static PersonTypeDto entityToDto(PersonType personType){
        PersonTypeDto personTypeDto= new PersonTypeDto();
        BeanUtils.copyProperties(personType,personTypeDto);
        return personTypeDto;
    }

    public static PersonType dtoToEntity(PersonTypeDto personTypeDto){
        PersonType personType= new PersonType();
        BeanUtils.copyProperties(personTypeDto,personType);
        return personType;
    }
}
