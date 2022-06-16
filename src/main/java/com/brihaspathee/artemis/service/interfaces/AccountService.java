package com.brihaspathee.artemis.service.interfaces;

import com.brihaspathee.artemis.web.model.AccountDto;
import com.brihaspathee.artemis.web.model.AccountSet;

import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 13, June 2022
 * Time: 11:53 AM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.service.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface AccountService {

    AccountDto getAccountBySK(UUID accountSK);
    AccountSet getAllAccounts();
}
