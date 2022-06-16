package com.brihaspathee.artemis.service.impl;

import com.brihaspathee.artemis.domain.entity.Account;
import com.brihaspathee.artemis.domain.repository.AccountRepository;
import com.brihaspathee.artemis.exception.AccountNotFoundException;
import com.brihaspathee.artemis.mapper.interfaces.AccountMapper;
import com.brihaspathee.artemis.service.interfaces.AccountService;
import com.brihaspathee.artemis.web.model.AccountDto;
import com.brihaspathee.artemis.web.model.AccountSet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 13, June 2022
 * Time: 11:53 AM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    @Override
    public AccountDto getAccountBySK(UUID accountSK) {
        Account account = accountRepository.findById(accountSK).orElseThrow(() -> {
                    throw new AccountNotFoundException("Account with " + accountSK + " not found");
        });
        return accountMapper.accountToAccountDto(account);
    }

    @Override
    public AccountSet getAllAccounts() {
        Set<Account> accounts = accountRepository.findAll().stream().collect(Collectors.toSet());
        AccountSet accountSet = AccountSet.builder()
                .accountList(accountMapper.accountsToAccountDtos(accounts))
                .build();
        return accountSet;
    }
}
