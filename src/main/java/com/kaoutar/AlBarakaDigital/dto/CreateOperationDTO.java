package com.kaoutar.AlBarakaDigital.dto;

import java.math.BigDecimal;

public class CreateOperationDTO {
    private String type; // DEPOT, RETRAIT, VIREMENT
    private BigDecimal amount;

    private Long accountId; // DEPOT / RETRAIT

    private Long accountSourceId;      // VIREMENT
    private Long accountDestinationId; // VIREMENT
}
