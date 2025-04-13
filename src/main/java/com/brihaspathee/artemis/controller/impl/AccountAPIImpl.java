package com.brihaspathee.artemis.controller.impl;

import com.brihaspathee.artemis.controller.interfaces.AccountAPI;
import com.brihaspathee.artemis.web.response.ArtemisAPIResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 09, April 2025
 * Time: 14:18
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.controller.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class AccountAPIImpl implements AccountAPI {

    /**
     * Handles the GET request to fetch a list of accounts.
     *
     * @return ResponseEntity containing an ArtemisAPIResponse with account-related
     *         data as a String.
     */
    @Override
    public ResponseEntity<ArtemisAPIResponse<String>> getAccounts() {
        ArtemisAPIResponse<String> apiResponse = ArtemisAPIResponse.<String>builder()
                .response("Account List fetched successfully")
                .message("Account List fetched successfully")
                .statusCode(200)
                .developerMessage("Account List fetched successfully")
                .reason("Success")
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    /**
     * Handles the GET request to initiate the creation of an account.
     *
     * @return ResponseEntity containing an ArtemisAPIResponse with a String
     *         message indicating the result of the account creation operation.
     */
    @Override
    public ResponseEntity<ArtemisAPIResponse<String>> createAccount() {
        ArtemisAPIResponse<String> apiResponse = ArtemisAPIResponse.<String>builder()
                .response("Account created successfully")
                .message("Account created successfully")
                .statusCode(201)
                .developerMessage("Account created successfully")
                .reason("Success")
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
}
