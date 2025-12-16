package com.kaoutar.AlBarakaDigital.model;

import com.kaoutar.AlBarakaDigital.enums.OperationStatus;
import com.kaoutar.AlBarakaDigital.enums.OperationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "operations")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OperationType type;
    // DEPOT, RETRAIT, VIREMENT

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal amount;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OperationStatus status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime validatedAt;
    private LocalDateTime executedAt;

    // 🟢 Compte concerné (DEPOT / RETRAIT)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    // 🔵 Compte source (VIREMENT)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_source_id")
    private Account accountSource;

    // 🔵 Compte destination (VIREMENT)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_destination_id")
    private Account accountDestination;


}

