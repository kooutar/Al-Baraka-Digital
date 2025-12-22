package com.kaoutar.AlBarakaDigital.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("Agent_bancaire")
public class Agent_bancaire extends User {
}
