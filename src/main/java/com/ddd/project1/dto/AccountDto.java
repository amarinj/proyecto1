package com.ddd.project1.dto;

import com.ddd.project1.entity.AccountType;
import com.ddd.project1.entity.PersonAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountDto {
    private String id;
    private String accountNumber;
    private AccountType accountType;
    private String cardNumber;
    private PersonAccount personAccount;
    private String dateExpires;
    private Integer lineAvailable;
    private Integer balanceAvailable;
    private Integer state;
}
