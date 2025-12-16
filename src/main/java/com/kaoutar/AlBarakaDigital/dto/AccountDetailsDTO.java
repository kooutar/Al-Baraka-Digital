package com.kaoutar.AlBarakaDigital.dto;

import java.math.BigDecimal;
import java.util.List;

public class AccountDetailsDTO {
    private Long id;
    private String accountNumber;
    private BigDecimal balance;

    private List<OprerationDto> operations;
}
