package com.brihaspathee.artemis.web.resource.interfaces;

import com.brihaspathee.artemis.domain.security.User;
import com.brihaspathee.artemis.web.model.AuthenticationRequest;
import com.brihaspathee.artemis.web.model.AuthenticationResponse;
import com.brihaspathee.artemis.web.response.ArtemisApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 14, June 2022
 * Time: 5:26 AM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.web.resource.interfaces
 * To change this template use File | Settings | File and Code Template
 */
@RequestMapping("/artemis")
@Validated
public interface AuthenticateAPI {

    @PostMapping("/authenticate")
    ResponseEntity<ArtemisApiResponse<AuthenticationResponse>> authenticate(@RequestBody AuthenticationRequest authenticationRequest);

    @GetMapping("/jwt-token")
    ResponseEntity<ArtemisApiResponse<AuthenticationResponse>> authenticate(@AuthenticationPrincipal User user);
}
