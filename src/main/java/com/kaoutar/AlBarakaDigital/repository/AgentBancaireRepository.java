package com.kaoutar.AlBarakaDigital.repository;

import com.kaoutar.AlBarakaDigital.model.Agent_bancaire;
import com.kaoutar.AlBarakaDigital.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentBancaireRepository extends JpaRepository<Agent_bancaire, Long> {
}
