package com.ddd.project1.controller;

import com.ddd.project1.dto.PersonDto;
import com.ddd.project1.dto.PersonTypeDto;
import com.ddd.project1.service.PersonService;
//import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("/getAll")
    //@Operation(summary = "List of Person", tags = {"person"})
    public Flux<PersonDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Mono<PersonDto> getPerson(@PathVariable String id){
        Mono<PersonDto> personDtoMono=service.getPerson(id);
        System.out.println(personDtoMono.toString());
        return personDtoMono;
    }

    @GetMapping("/getDni/{dni}")
    public Mono<PersonDto> getPersonDni(@PathVariable String dni){
        Mono<PersonDto> personDtoMono=service.getPersonDocumentNumber(dni);
        return personDtoMono;
    }

    @PostMapping("/save")
    public Mono<PersonDto> savePerson(@RequestBody Mono<PersonDto> personDtoMono){
        return service.savePerson(personDtoMono);
    }

    @PutMapping("/update/{id}")
    public Mono<PersonDto> updatePerson(@RequestBody Mono<PersonDto> personDtoMono, @PathVariable String id){
        return service.updatePerson(personDtoMono,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteOperation(@PathVariable String id){
        return service.deletePerson(id);
    }

}
