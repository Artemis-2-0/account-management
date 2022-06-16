package com.brihaspathee.artemis.web.resource.impl;

import com.brihaspathee.artemis.domain.security.User;
import com.brihaspathee.artemis.service.interfaces.AccountService;
import com.brihaspathee.artemis.web.model.AccountDto;
import com.brihaspathee.artemis.web.model.AccountSet;
import com.brihaspathee.artemis.web.resource.interfaces.AccountAPI;
import com.brihaspathee.artemis.web.response.ArtemisApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 13, June 2022
 * Time: 12:03 PM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.web.resource.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class AccountResource implements AccountAPI {

    private final AccountService accountService;

    @Override
    public ResponseEntity<ArtemisApiResponse<AccountDto>> getAccountById(String accountId) {
        return null;
    }

    @Override
    public ResponseEntity<ArtemisApiResponse<AccountSet>> getAllAccounts(@AuthenticationPrincipal User user) {
        log.info("Inside the controller: User is :", user);
        AccountSet accountSet = accountService.getAllAccounts();
        ArtemisApiResponse<AccountSet> apiResponse = ArtemisApiResponse.<AccountSet>builder()
                .response(accountSet)
                .message("Success")
                .status(HttpStatus.OK)
                .statusCode(200)
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
