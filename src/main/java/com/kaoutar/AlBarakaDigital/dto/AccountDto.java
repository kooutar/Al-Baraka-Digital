package com.kaoutar.AlBarakaDigital.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class AccountDto {
    private Long id;
    private String accountNumber;
    private BigDecimal balance;

    // Pour affichage
    private Long ownerId;
}
