package com.ddd.project1.dto;

import com.ddd.project1.entity.OperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovementDto {
    private String id;
    private Integer amount;
    private OperationType operationType;
    private String accountNumber;
    private String documentNumber;
    private Integer state;
}
