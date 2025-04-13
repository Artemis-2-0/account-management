package com.brihaspathee.artemis.controller.interfaces;

import com.brihaspathee.artemis.web.response.ArtemisAPIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 09, April 2025
 * Time: 14:08
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.controller.interfaces
 * To change this template use File | Settings | File and Code Template
 */
@RequestMapping("/api/v1/artemis/account/secured")
public interface AccountAPI {

    /**
     * Handles the GET request to fetch a list of accounts.
     *
     * @return ResponseEntity containing an ArtemisAPIResponse with
     *         account-related data as a String.
     */
    @GetMapping("/get-accounts")
    ResponseEntity<ArtemisAPIResponse<String>> getAccounts();

    /**
     * Handles the GET request to initiate the creation of an account.
     *
     * @return ResponseEntity containing an ArtemisAPIResponse with a String
     *         message indicating the result of the account creation operation.
     */
    @GetMapping("/create-account")
    ResponseEntity<ArtemisAPIResponse<String>> createAccount();
}
