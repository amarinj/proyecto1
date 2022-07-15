package com.ddd.project1.dto;

import com.ddd.project1.entity.DocumentType;
import com.ddd.project1.entity.PersonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonDto {
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
