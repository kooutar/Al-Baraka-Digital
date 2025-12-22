package com.kaoutar.AlBarakaDigital.repository;

import com.kaoutar.AlBarakaDigital.model.Document;
import com.kaoutar.AlBarakaDigital.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
