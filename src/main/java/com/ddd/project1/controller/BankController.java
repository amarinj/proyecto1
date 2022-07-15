package com.ddd.project1.controller;

import com.ddd.project1.dto.MovementDto;
import com.ddd.project1.dto.PersonDto;
import com.ddd.project1.dto.AccountDto;
import com.ddd.project1.service.AccountTypeService;
import com.ddd.project1.controller.PersonController;
import com.ddd.project1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    @Autowired
    private PersonController personController;

    @Autowired
    private AccountController accountController;

    @Autowired
    private MovementController movementController;

    @GetMapping("/Dni/{dni}")
    public Mono<PersonDto> getDni(@PathVariable String dni){
        Mono<PersonDto> personDtoMono=personController.getPersonDni(dni);
        return personDtoMono;
    }


    @GetMapping("/Balance/{accountNumber}/balanceAvailable")
    public Mono<AccountDto> getBalance(@PathVariable String accountNumber){
        Mono<AccountDto> accountDto = accountController.getAccountBalanceAvailable(accountNumber);
        return accountDto;
    }

    //@GetMapping("/Balance/{accountNumber}")
    //public Mono<Integer> getBalance(@PathVariable String accountNumber){
    //    return accountController.getAccountBalance(accountNumber);
    //}

    /*
    @PostMapping("/depositomov")
    public Mono<MovementDto> saveMovement(@RequestBody Mono<MovementDto> movementDtoMono){
        Mono<MovementDto> mov = accountController();
        return service.saveMovement(movementDtoMono);
    }
*/
}
