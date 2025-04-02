package com.brihaspathee.artemis.controller.impl;

import com.brihaspathee.artemis.controller.interfaces.WelcomeAPI;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 02, April 2025
 * Time: 11:51 AM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.controller.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class WelcomeAPIImpl implements WelcomeAPI {

    /**
     * Handles the GET request to provide a welcome message.
     *
     * @return ResponseEntity containing a welcome message as a String.
     */
    @Override
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Welcome to Artemis Account Management Service!");
    }
}
