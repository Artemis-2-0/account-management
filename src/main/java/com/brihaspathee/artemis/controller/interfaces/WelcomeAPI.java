package com.brihaspathee.artemis.controller.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 02, April 2025
 * Time: 11:50 AM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.controller.interfaces
 * To change this template use File | Settings | File and Code Template
 */
@RequestMapping("/api/v1/artemis/account/public")
public interface WelcomeAPI {

    /**
     * Handles the GET request to provide a welcome message.
     *
     * @return ResponseEntity containing a welcome message as a String.
     */
    @GetMapping("/welcome")
    ResponseEntity<String> welcome();
}
