package com.brihaspathee.artemis.mapper.impl;

import com.brihaspathee.artemis.domain.entity.Account;
import com.brihaspathee.artemis.domain.entity.Customer;
import com.brihaspathee.artemis.mapper.interfaces.AccountMapper;
import com.brihaspathee.artemis.reference.data.AccountType;
import com.brihaspathee.artemis.reference.data.Gender;
import com.brihaspathee.artemis.web.model.AccountDto;
import com.brihaspathee.artemis.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 13, June 2022
 * Time: 11:47 AM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.mapper.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDto accountToAccountDto(Account account) {
        if(account == null){
            return null;
        }
        AccountDto accountDto = AccountDto.builder()
                .accountSK(account.getAccountSK())
                .accountType(AccountType.valueOf(account.getAccountType()))
                .accountName(account.getAccountName())
                .accountNumber(account.getAccountNumber())
                .accountBalance(account.getAccountBalance())
                .customerDto(CustomerDto.builder()
                        .customerSK(account.getCustomer().getCustomerSK())
//                        .customerNumber(account.getCustomer().getCustomerNumber())
//                        .firstName(account.getCustomer().getFirstName())
//                        .middleName(account.getCustomer().getMiddleName())
//                        .lastName(account.getCustomer().getLastName())
//                        .dateOfBirth(account.getCustomer().getDateOfBirth())
//                        .gender(Gender.valueOf(account.getCustomer().getGender()))
                        .build())
                .build();
        return accountDto;
    }

    @Override
    public Account accountDtoToAccount(AccountDto accountDto) {
        if(accountDto == null){
            return null;
        }
        Account account = Account.builder()
                .accountSK(accountDto.getAccountSK())
                .accountType(accountDto.getAccountType().name())
                .accountName(accountDto.getAccountName())
                .accountNumber(accountDto.getAccountNumber())
                .accountBalance(accountDto.getAccountBalance())
                .customer(Customer.builder()
                        .customerSK(accountDto.getCustomerDto().getCustomerSK())
//                        .customerNumber(accountDto.getCustomerDto().getCustomerNumber())
//                        .firstName(accountDto.getCustomerDto().getFirstName())
//                        .middleName(accountDto.getCustomerDto().getMiddleName())
//                        .lastName(accountDto.getCustomerDto().getLastName())
//                        .dateOfBirth(accountDto.getCustomerDto().getDateOfBirth())
//                        .gender(accountDto.getCustomerDto().getGender().name())
                        .build())
                .build();
        return account;
    }

    @Override
    public Set<Account> accountDtosToAccounts(Set<AccountDto> accountDtos) {
        return accountDtos.stream().map(this::accountDtoToAccount).collect(Collectors.toSet());
    }

    @Override
    public Set<AccountDto> accountsToAccountDtos(Set<Account> accounts) {
        return accounts.stream().map(this::accountToAccountDto).collect(Collectors.toSet());
    }
}
