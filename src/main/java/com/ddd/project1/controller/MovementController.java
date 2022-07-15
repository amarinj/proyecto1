package com.ddd.project1.controller;

import com.ddd.project1.dto.MovementDto;
import com.ddd.project1.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/movement")
public class MovementController {

    @Autowired
    private MovementService service;

    @GetMapping("/getAll")
    //@Operation(summary = "List of Person", tags = {"person"})
    public Flux<MovementDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Mono<MovementDto> getMovement(@PathVariable String id){
        Mono<MovementDto> movementDtoMono=service.getMovement(id);
        System.out.println(movementDtoMono.toString());
        return movementDtoMono;
    }

    @PostMapping("/save")
    public Mono<MovementDto> saveMovement(@RequestBody Mono<MovementDto> movementDtoMono){

        return service.saveMovement(movementDtoMono);
    }

/*
    @PostMapping("/save2/{id}/{amount}/{description}/{accountNumber}/{documentNumber}")
    public Mono<ServerResponse> addMovement(@RequestBody Mono<MovementDto> movementDtoMono, @PathVariable String id, @PathVariable Integer amount, @PathVariable String description, @PathVariable String accountNumber, @PathVariable String documentNumber){
        return service.addMovement(movementDtoMono,id,amount,description,accountNumber,documentNumber);
    }
*/
/*
    @PostMapping("/save")
    public Mono<MovementDto> saveMovement(@RequestBody Mono<MovementDto> movementDtoMono){
        return service.saveMovement(movementDtoMono);
    }
*/

    @PutMapping("/update/{id}")
    public Mono<MovementDto> updateMovement(@RequestBody Mono<MovementDto> movementDtoMono, @PathVariable String id){
        return service.updateMovement(movementDtoMono,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteOperation(@PathVariable String id){
        return service.deleteMovement(id);
    }

}
