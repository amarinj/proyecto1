package com.ddd.project1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "person")
public class Person {

    @Id
    private String id;
    private String documentNumber;
    private DocumentType documentType;
    private String name;
    private PersonType personType;
    private String address;
    private String phone;
    private String email;
    private Integer state;
}
