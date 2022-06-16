package com.brihaspathee.artemis.web.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 15, June 2022
 * Time: 11:08 AM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class AuthenticationResponse {

    private final String jwtToken;

    private final UserDto userDto;

    @Override
    public String toString() {
        return "AuthenticationResponse{" +
                "jwtToken='" + jwtToken + '\'' +
                ", userDto=" + userDto +
                '}';
    }
}
