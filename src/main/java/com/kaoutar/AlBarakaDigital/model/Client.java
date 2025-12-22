package com.kaoutar.AlBarakaDigital.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("client")
public class Client extends User {
    @OneToOne(mappedBy = "owner",
            cascade = CascadeType.ALL,
            optional = false)
    private Account account;
}
