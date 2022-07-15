package com.ddd.project1.controller;

import com.ddd.project1.dto.AccountTypeDto;
import com.ddd.project1.dto.OperationTypeDto;
import com.ddd.project1.service.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/accountType")
public class AccountTypeController {

    @Autowired
    private AccountTypeService service;

    @GetMapping("/getAll")
    public Flux<AccountTypeDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Mono<AccountTypeDto> getAccountType(@PathVariable String id){
        Mono<AccountTypeDto> accountTypeDtoMono=service.getAccountType(id);
        System.out.println(accountTypeDtoMono.toString());
        return accountTypeDtoMono;
    }

    @PostMapping("/save")
    public Mono<AccountTypeDto> saveAccountType(@RequestBody Mono<AccountTypeDto> accountTypeDtoMono){
        return service.saveAccountType(accountTypeDtoMono);
    }

    @PutMapping("/update/{id}")
    public Mono<AccountTypeDto> updateAccountType(@RequestBody Mono<AccountTypeDto> accountTypeDtoMono, @PathVariable String id){
        return service.updateAccountType(accountTypeDtoMono,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteAccountType(@PathVariable String id){
        return service.deleteAccountType(id);
    }



}
