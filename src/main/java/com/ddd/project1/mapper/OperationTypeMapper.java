package com.ddd.project1.mapper;

import com.ddd.project1.dto.OperationTypeDto;
import com.ddd.project1.entity.OperationType;
import org.springframework.beans.BeanUtils;

public class OperationTypeMapper {

    public static OperationTypeDto entityToDto(OperationType operationType){
        OperationTypeDto operationTypeDto= new OperationTypeDto();
        BeanUtils.copyProperties(operationType,operationTypeDto);
        return operationTypeDto;
    }

    public static OperationType dtoToEntity(OperationTypeDto operationTypeDto){
        OperationType operationType= new OperationType();
        BeanUtils.copyProperties(operationTypeDto,operationType);
        return operationType;
    }




}
