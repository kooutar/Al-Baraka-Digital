package com.kaoutar.AlBarakaDigital.repository;

import com.kaoutar.AlBarakaDigital.model.Account;
import com.kaoutar.AlBarakaDigital.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Long, Account> {
}
