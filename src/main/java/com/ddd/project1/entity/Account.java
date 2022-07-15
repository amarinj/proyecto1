package com.ddd.project1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "account")
public class Account {
    @Id
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
