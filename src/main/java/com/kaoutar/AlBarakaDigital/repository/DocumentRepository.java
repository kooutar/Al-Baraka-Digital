package com.kaoutar.AlBarakaDigital.repository;

import com.kaoutar.AlBarakaDigital.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Long, Document> {
}
