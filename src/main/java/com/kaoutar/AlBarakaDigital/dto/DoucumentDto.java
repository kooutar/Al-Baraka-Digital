package com.kaoutar.AlBarakaDigital.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class DoucumentDto {
    private Long id;
    private String fileName;
    private String fileType;
    private String storagePath;
    private LocalDateTime uploadedAt;
    private Long operationId;
}
