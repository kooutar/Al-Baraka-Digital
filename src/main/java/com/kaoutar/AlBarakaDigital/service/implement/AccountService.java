package com.kaoutar.AlBarakaDigital.service.implement;

import com.kaoutar.AlBarakaDigital.dto.AccountDetailsDTO;
import com.kaoutar.AlBarakaDigital.dto.AccountDto;
import com.kaoutar.AlBarakaDigital.mapper.AccountMapper;
import com.kaoutar.AlBarakaDigital.model.Account;
import com.kaoutar.AlBarakaDigital.model.Client;
import com.kaoutar.AlBarakaDigital.model.User;
import com.kaoutar.AlBarakaDigital.repository.AccountRepository;
import com.kaoutar.AlBarakaDigital.repository.UserRepository;
import com.kaoutar.AlBarakaDigital.service.interfaces.AccountServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@Service
public class AccountService  implements AccountServiceInterface {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final AccountMapper accountMapper;
    private final UserService userService;
    @Override
    public AccountDto create(AccountDto dto) {
        User user = userRepository.findById(dto.getOwnerId()) .orElseThrow(() -> new IllegalArgumentException("Utilisateur introuvable"));
        Account account = accountMapper.toEntity(dto);
        account.setAccountNumber(generateAccountNumber());
        account.setOwner((Client) user);
        Account saved =accountRepository.save(account);
        return accountMapper.toDto(saved);
    }

    @Override
    public AccountDto update(Long id, AccountDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public AccountDto getById(Long id) {
        return null;
    }

    @Override
    public List<AccountDto> getAll() {
        return List.of();
    }

    @Override
    public AccountDetailsDTO getDetails(Long id) {
        return null;
    }

    private String generateAccountNumber() {
        return "ACC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public List<Account> getAccountsOfCurrentUser() {
        User user = userService.getCurrentUser();
        return accountRepository.findByOwner(user);
    }
}
