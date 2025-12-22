package com.kaoutar.AlBarakaDigital.dto;

import lombok.*;


@NoArgsConstructor
@Data
public class UserDto {

    private Long id;
    private String email;
    private String fullName;
    private String role;
    private boolean active;
}
