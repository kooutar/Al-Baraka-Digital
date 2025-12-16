package com.kaoutar.AlBarakaDigital.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le numéro de compte est obligatoire")
    @Size(min = 10, max = 34, message = "Numéro de compte invalide")
    @Column(nullable = false, unique = true)
    private String accountNumber;

    @NotNull(message = "Le solde est obligatoire")
    @DecimalMin(value = "0.0", inclusive = true, message = "Le solde ne peut pas être négatif")
    @Digits(integer = 15, fraction = 2, message = "Format du solde invalide")
    @Column(nullable = false, precision = 17, scale = 2)
    private BigDecimal balance;

    /**
     * Propriétaire du compte
     * Plusieurs comptes → un utilisateur
     */
    @NotNull(message = "Le propriétaire est obligatoire")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false,unique = true)
    private Client owner;



    // DEPOT + RETRAIT
    @OneToMany(mappedBy = "account")
    private List<Operation> simpleOperations = new ArrayList<>();

    // VIREMENTS sortants
    @OneToMany(mappedBy = "accountSource")
    private List<Operation> outgoingTransfers = new ArrayList<>();

    // VIREMENTS entrants
    @OneToMany(mappedBy = "accountDestination")
    private List<Operation> incomingTransfers = new ArrayList<>();


}
