package com.kaoutar.AlBarakaDigital.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;



@NoArgsConstructor
@Data
public class OprerationDto {
    private Long id;
    private String type;   // DEPOT, RETRAIT, VIREMENT
    private String status; // PENDING, VALIDATED, EXECUTED

    private BigDecimal amount;

    private LocalDateTime createdAt;
    private LocalDateTime validatedAt;
    private LocalDateTime executedAt;

    // DEPOT / RETRAIT
    private Long accountId;

    // VIREMENT
    private Long accountSourceId;
    private Long accountDestinationId;
}
