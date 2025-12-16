package com.kaoutar.AlBarakaDigital.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("client")
public class Client extends  User {
    @OneToOne(mappedBy = "owner",
    cascade = CascadeType.ALL,
            optional = false)
    private  Account account;
}
