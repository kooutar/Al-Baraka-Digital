package com.kaoutar.AlBarakaDigital.service.implement;

import com.kaoutar.AlBarakaDigital.dto.CreateOperationDTO;
import com.kaoutar.AlBarakaDigital.dto.OprerationDto;
import com.kaoutar.AlBarakaDigital.enums.OperationStatus;
import com.kaoutar.AlBarakaDigital.enums.OperationType;
import com.kaoutar.AlBarakaDigital.mapper.OperationMapper;
import com.kaoutar.AlBarakaDigital.model.Account;
import com.kaoutar.AlBarakaDigital.model.Operation;
import com.kaoutar.AlBarakaDigital.repository.AccountRepository;
import com.kaoutar.AlBarakaDigital.repository.OperationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor

@Service
public class OperationService {
    private final OperationRepository operationRepository;
    private final AccountRepository accountRepository;
    private final OperationMapper operationMapper;


    public OprerationDto createDeposit(CreateOperationDTO dto){
        Account account = accountRepository.findById(dto.getAccountId()) .orElseThrow(() -> new IllegalArgumentException("Compte introuvable"));
        Operation operation=operationMapper.toEntity(dto);
        operation.setAccount(account);
        operation.setCreatedAt(LocalDateTime.now());

        if(dto.getAmount().compareTo(BigDecimal.valueOf(10000))<=0){
            operation.setStatus(OperationStatus.APPROVED);
            operation.setValidatedAt(LocalDateTime.now());
            account.setBalance(account.getBalance().add(dto.getAmount()));
            accountRepository.save(account);
        }else {
            operation.setStatus(OperationStatus.PENDING);
        }

        operation.setAccount(account);
        return operationMapper.toDto(operationRepository.save(operation));

    }

    public OprerationDto createWithdrawal(CreateOperationDTO dto) {
       Account account = accountRepository.findById(dto.getAccountId()).orElseThrow(()->new IllegalArgumentException("compte introuvable"));
       if(account.getBalance().compareTo(dto.getAmount())<0){
           throw  new IllegalArgumentException("Solde insuffisant");
       }
       Operation operation =operationMapper.toEntity(dto);
       operation.setType(OperationType.WITHDRAWAL);
       operation.setAmount(dto.getAmount());
       operation.setCreatedAt(LocalDateTime.now());
        if(dto.getAmount().compareTo(BigDecimal.valueOf(10000))<=0){
            operation.setStatus(OperationStatus.APPROVED);
            operation.setValidatedAt(LocalDateTime.now());
            account.setBalance(account.getBalance().subtract(dto.getAmount()));
            accountRepository.save(account);
        }else {
            operation.setStatus(OperationStatus.PENDING);
        }
        operation.setAccount(account);
        return  operationMapper.toDto(operationRepository.save(operation));
    }


    public OprerationDto createTransfer(CreateOperationDTO dto){
        Account source = accountRepository.findById(dto.getAccountSourceId()).orElseThrow(()->new IllegalArgumentException("Compte source introuvable"));
        Account dest = accountRepository.findById(dto.getAccountDestinationId()).orElseThrow(()->new IllegalArgumentException("Compte desctination introuvable"));
        Operation operation =operationMapper.toEntity(dto);
        operation.setType(OperationType.TRANSFER);
        operation.setAmount(dto.getAmount());
        operation.setAccountSource(source);
        operation.setAccountDestination(dest);
        operation.setCreatedAt(LocalDateTime.now());
        if(dto.getAmount().compareTo(BigDecimal.valueOf(10000))<=0){
            operation.setStatus(OperationStatus.APPROVED);
            operation.setValidatedAt(LocalDateTime.now());
            source.setBalance(source.getBalance().subtract(dto.getAmount()));
            dest.setBalance(dest.getBalance().add(dto.getAmount()));
            accountRepository.save(source);
            accountRepository.save(dest);
        }else {
            operation.setStatus(OperationStatus.PENDING);
        }

        return  operationMapper.toDto(operationRepository.save(operation));
    }






}
