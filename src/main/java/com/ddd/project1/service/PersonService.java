package com.ddd.project1.service;

import com.ddd.project1.dto.PersonDto;
import com.ddd.project1.mapper.PersonMapper;
import com.ddd.project1.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Flux<PersonDto> getAll(){
        return repository.findAll().map(PersonMapper::entityToDto);
    }

    public Mono<PersonDto> getPerson(String id){
        return repository.findById(id).map(PersonMapper::entityToDto);
    }

    public Mono<PersonDto> getPersonDocumentNumber(String documentNumber){
        //return  repository.findByDocumentNumber(documentNumber);
        return  repository.findByDocumentNumber(documentNumber).map(PersonMapper::entityToDto);
    }

    public Mono<PersonDto> savePerson(Mono<PersonDto> personDtoMono){
        return personDtoMono.map(PersonMapper::dtoToEntity)
                .flatMap(repository::insert)
                .map(PersonMapper::entityToDto);
    }

    public Mono<PersonDto> updatePerson(Mono<PersonDto> personDtoMono, String id){
        return repository.findById(id)
                .flatMap(p-> personDtoMono.map(PersonMapper::dtoToEntity)
                        .doOnNext(e->e.setId(id))
                        .flatMap(repository::save)
                        .map(PersonMapper::entityToDto));
    }

    public Mono<Void> deletePerson(String id){
        return repository.deleteById(id);
    }

}
