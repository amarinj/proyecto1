package com.ddd.project1.controller;

import com.ddd.project1.dto.OperationTypeDto;
import com.ddd.project1.service.OperationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/operationType")
public class OperationTypeController {

    @Autowired
    public OperationTypeService service;

    @GetMapping("/getAll")
    public Flux<OperationTypeDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Mono<OperationTypeDto> getOperationType(@PathVariable String id){
        Mono<OperationTypeDto> operationTypeDtoMono=service.getOperationType(id);
        System.out.println(operationTypeDtoMono.toString());
        return operationTypeDtoMono;
    }

    @PostMapping("/save")
    public Mono<OperationTypeDto> saveOperationType(@RequestBody Mono<OperationTypeDto> operationTypeDtoMono){
        return service.saveOperationType(operationTypeDtoMono);
    }

    @PutMapping("/update/{id}")
    public Mono<OperationTypeDto> updateOperationType(@RequestBody Mono<OperationTypeDto> operationTypeDtoMono, @PathVariable String id){
        return service.updateOperationType(operationTypeDtoMono,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteOperationType(@PathVariable String id){
        return service.deleteOperationType(id);
    }

}
