package com.kaoutar.AlBarakaDigital.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@Data
public class AccountDetailsDTO {
    private Long id;
    private String accountNumber;
    private BigDecimal balance;

    private List<OprerationDto> operations;
}
