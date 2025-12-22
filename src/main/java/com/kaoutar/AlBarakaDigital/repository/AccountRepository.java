package com.kaoutar.AlBarakaDigital.repository;

import com.kaoutar.AlBarakaDigital.model.Account;
import com.kaoutar.AlBarakaDigital.model.Document;
import com.kaoutar.AlBarakaDigital.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByOwner(User user);
}
