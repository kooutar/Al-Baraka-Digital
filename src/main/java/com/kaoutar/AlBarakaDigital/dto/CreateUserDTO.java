package com.kaoutar.AlBarakaDigital.dto;

import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class CreateUserDTO {
    private Long id;
    private String email;
    private String fullName;
    private String role;
    private boolean active;
    private  String password;
}
