package com.ddd.project1.mapper;

import com.ddd.project1.dto.AccountTypeDto;
import com.ddd.project1.dto.OperationTypeDto;
import com.ddd.project1.entity.AccountType;
import com.ddd.project1.entity.OperationType;
import org.springframework.beans.BeanUtils;

public class AccountTypeMapper {

    public static AccountTypeDto entityToDto(AccountType entity){
        AccountTypeDto accountTypeDto= new AccountTypeDto();
        BeanUtils.copyProperties(entity,accountTypeDto);
        return accountTypeDto;
    }

    public static AccountType dtoToEntity(AccountTypeDto accountTypeDto){
        AccountType accountType= new AccountType();
        BeanUtils.copyProperties(accountTypeDto,accountType);
        return accountType;
    }

}
