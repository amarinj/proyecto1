package com.ddd.project1.service;

import com.ddd.project1.dto.DocumentTypeDto;
import com.ddd.project1.mapper.DocumentTypeMapper;
import com.ddd.project1.repository.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DocumentTypeService {

    @Autowired
    private DocumentTypeRepository repository;

    public Flux<DocumentTypeDto> getAll(){
        return repository.findAll().map(DocumentTypeMapper::entityToDto);
    }

    public Mono<DocumentTypeDto> getDocumentType(String id){
        return repository.findById(id).map(DocumentTypeMapper::entityToDto);
    }

    public Mono<DocumentTypeDto> saveDocumentType(Mono<DocumentTypeDto> documentTypeDtoMono){
        return documentTypeDtoMono.map(DocumentTypeMapper::dtoToEntity)
                .flatMap(repository::insert)
                .map(DocumentTypeMapper::entityToDto);
    }

    public Mono<DocumentTypeDto> updateDocumentType(Mono<DocumentTypeDto> documentTypeDtoMono, String id){
        return repository.findById(id)
                .flatMap(p-> documentTypeDtoMono.map(DocumentTypeMapper::dtoToEntity)
                        .doOnNext(e->e.setId(id))
                        .flatMap(repository::save)
                        .map(DocumentTypeMapper::entityToDto));
    }

    public Mono<Void> deleteDocumentType(String id){
        return repository.deleteById(id);
    }



}
