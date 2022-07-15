package com.ddd.project1.mapper;

import com.ddd.project1.dto.DocumentTypeDto;
import com.ddd.project1.entity.DocumentType;
import org.springframework.beans.BeanUtils;

public class DocumentTypeMapper {

    public static DocumentTypeDto entityToDto(DocumentType entity){
        DocumentTypeDto documentTypeDto= new DocumentTypeDto();
        BeanUtils.copyProperties(entity,documentTypeDto);
        return documentTypeDto;
    }

    public static DocumentType dtoToEntity(DocumentTypeDto documentTypeDto){
        DocumentType documentType= new DocumentType();
        BeanUtils.copyProperties(documentTypeDto,documentType);
        return documentType;
    }
}
