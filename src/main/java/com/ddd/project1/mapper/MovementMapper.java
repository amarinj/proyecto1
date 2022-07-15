package com.ddd.project1.mapper;

import com.ddd.project1.dto.MovementDto;
import com.ddd.project1.entity.Movement;
import org.springframework.beans.BeanUtils;

public class MovementMapper {

    public static MovementDto entityToDto(Movement movement){
        MovementDto movementDto= new MovementDto();
        BeanUtils.copyProperties(movement,movementDto);
        return movementDto;
    }

    public static Movement dtoToEntity(MovementDto movementDto){
        Movement movement= new Movement();
        BeanUtils.copyProperties(movementDto,movement);
        return movement;
    }

}
