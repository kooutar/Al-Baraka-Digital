package com.kaoutar.AlBarakaDigital.model;

import com.kaoutar.AlBarakaDigital.enums.RoleUser;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typeUser" ,discriminatorType = DiscriminatorType.STRING)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "Format de l'email invalide")
    @Column(nullable = false, unique = true)
    protected String email;

    @NotBlank(message = "Le nom complet est obligatoire")
    @Size(min = 3, max = 100, message = "Le nom complet doit contenir entre 3 et 100 caractères")
    @Column(nullable = false)
    protected String fullName;

    @NotNull(message = "Le rôle est obligatoire")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    protected RoleUser role;

    @NotNull
    @Column(nullable = false)
    protected boolean active = true;

    @PastOrPresent(message = "La date de création ne peut pas être dans le futur")
    @Column(nullable = false, updatable = false)
    protected LocalDateTime createdAt = LocalDateTime.now();

    protected LocalDateTime deletedAt;
}
