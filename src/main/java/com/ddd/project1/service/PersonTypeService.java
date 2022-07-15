package com.ddd.project1.service;

import com.ddd.project1.dto.PersonTypeDto;
import com.ddd.project1.mapper.PersonTypeMapper;
import com.ddd.project1.repository.PersonTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonTypeService {

    @Autowired
    PersonTypeRepository repository;

    public Flux<PersonTypeDto> getAll(){
        return repository.findAll().map(PersonTypeMapper::entityToDto);
    }

    public Mono<PersonTypeDto> getPersonType(String id){
        return repository.findById(id).map(PersonTypeMapper::entityToDto);
    }

    public Mono<PersonTypeDto> savePersonType(Mono<PersonTypeDto> personTypeDtoMono){
        return personTypeDtoMono.map(PersonTypeMapper::dtoToEntity)
                .flatMap(repository::insert)
                .map(PersonTypeMapper::entityToDto);
    }

    public Mono<PersonTypeDto> updatePersonType(Mono<PersonTypeDto> personTypeDtoMono, String id){
        return repository.findById(id)
                .flatMap(p-> personTypeDtoMono.map(PersonTypeMapper::dtoToEntity)
                        .doOnNext(e->e.setId(id))
                        .flatMap(repository::save)
                        .map(PersonTypeMapper::entityToDto));
    }

    public Mono<Void> deletePersonType(String id){
        return repository.deleteById(id);
    }

}
