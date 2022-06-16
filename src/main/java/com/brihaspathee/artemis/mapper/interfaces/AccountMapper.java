package com.brihaspathee.artemis.mapper.interfaces;

import com.brihaspathee.artemis.domain.entity.Account;
import com.brihaspathee.artemis.web.model.AccountDto;

import java.util.List;
import java.util.Set;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 13, June 2022
 * Time: 11:45 AM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.mapper.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface AccountMapper {

    AccountDto accountToAccountDto(Account account);
    Account accountDtoToAccount(AccountDto accountDto);
    Set<Account> accountDtosToAccounts(Set<AccountDto> accountDtos);
    Set<AccountDto> accountsToAccountDtos(Set<Account> accounts);
}
