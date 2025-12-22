package com.kaoutar.AlBarakaDigital.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("admin")
public class Admin extends User {
}
