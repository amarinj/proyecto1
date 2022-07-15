package com.ddd.project1.mapper;

import com.ddd.project1.dto.AccountDto;
import com.ddd.project1.entity.Account;
import org.springframework.beans.BeanUtils;

public class AccountMapper {

    public static AccountDto entityToDto(Account account){
        AccountDto accountDto= new AccountDto();
        BeanUtils.copyProperties(account,accountDto);
        return accountDto;
    }

    public static Account dtoToEntity(AccountDto accountDto){
        Account account= new Account();
        BeanUtils.copyProperties(accountDto,account);
        return account;
    }

}
