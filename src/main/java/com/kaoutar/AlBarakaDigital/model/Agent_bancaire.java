package com.kaoutar.AlBarakaDigital.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Agent_bancaire")
public class Agent_bancaire  extends User{
}
