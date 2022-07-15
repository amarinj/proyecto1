package com.ddd.project1.controller;

import com.ddd.project1.dto.AccountDto;
import com.ddd.project1.dto.DocumentTypeDto;
import com.ddd.project1.mapper.AccountMapper;
import com.ddd.project1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.reactive.function.server.EntityResponse.fromPublisher;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping("/getAll")
    //@Operation(summary = "List of Person", tags = {"person"})
    public Flux<AccountDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Mono<AccountDto> getAccount(@PathVariable String id){
        Mono<AccountDto> accountDtoMono=service.getAccount(id);
        System.out.println(accountDtoMono.toString());
        return accountDtoMono;
    }

    //@GetMapping("/getBalance/{accountNumber}/balanceAvailablePrueba")
    //public Mono<Integer> getAccountBalanceAvailablePrueba(@PathVariable String accountNumber) {
    //    return service.getAccountBalance(accountNumber);
    //}

    @GetMapping("/getBalance/{accountNumber}/balanceAvailable")
    public Mono<AccountDto>  getAccountBalanceAvailable(@PathVariable String accountNumber) {
        Mono<AccountDto> accountDto = service.getAccountNumber(accountNumber);
        return accountDto;
    }

    //@GetMapping("/getBalance/{accountNumber}/balanceAvailable")
    //public Mono<Integer>  getAccountBalance(@PathVariable String accountNumber) {
    //    return service.getAccountBalance(accountNumber);
    //}

    @PostMapping("/save")
    public Mono<AccountDto> saveAccount(@RequestBody Mono<AccountDto> accountDtoMono){
        return service.saveAccount(accountDtoMono);
    }

    @PutMapping("/update/{id}")
    public Mono<AccountDto> updateAccount(@RequestBody Mono<AccountDto> accountDtoMono, @PathVariable String id){
        return service.updateAccount(accountDtoMono,id);
    }


//    @PutMapping("/update/{id}")
//    public Mono<AccountDto> updateAccount(@RequestBody Mono<AccountDto> accountDtoMono, @PathVariable String id){
//        Mono<AccountDto> a = service.updateAccount(accountDtoMono,id);
//        return Mono.just(new AccountDto());
//        /*return a.map(p-> ResponseEntity
//                .created(URI.create("/api/account/update/".concat(p.getId())))
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .body(p));*/
//        //return a.map(p -> new ResponseEntity<>(p, HttpStatus.OK)).defaultIfEmpty(new ResponseEntity<>(HttpStatus.OK));
//    }

//    @PutMapping("/v1/update/{id}")
//    public Mono<ResponseEntity<AccountDto>> editar(@RequestBody AccountDto producto, @PathVariable String id){
//        return service.getAccount(id).flatMap(p -> {
//                    p.setAccountNumber(producto.getAccountNumber());
//                    p.setCardNumber(producto.getCardNumber());
//                    p.setState(producto.getState());
//                    return service.saveAccount(Mono.just(p));
//                }).map(p->ResponseEntity.created(URI.create("/v1/update/".concat(p.getId())))
//                        .contentType(MediaType.APPLICATION_JSON_UTF8)
//                        .body(p))
//                .defaultIfEmpty(ResponseEntity.notFound().build());
//    }
//    */

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteOperation(@PathVariable String id){
        return service.deleteAccount(id);
    }

}
