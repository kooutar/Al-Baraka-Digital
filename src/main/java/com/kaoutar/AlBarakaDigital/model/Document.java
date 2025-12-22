package com.kaoutar.AlBarakaDigital.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom du fichier est obligatoire")
    @Column(nullable = false)
    private String fileName;

    @NotBlank(message = "Le type du fichier est obligatoire")
    @Column(nullable = false)
    private String fileType;

    @NotBlank(message = "Le chemin de stockage est obligatoire")
    @Column(nullable = false)
    private String storagePath;

    @PastOrPresent
    @Column(nullable = false, updatable = false)
    private LocalDateTime uploadedAt = LocalDateTime.now();

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operation_id", nullable = false)
    private Operation operation;
}
