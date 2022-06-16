package com.brihaspathee.artemis.web.resource.impl;

import com.brihaspathee.artemis.auth.AccountManagementUserDetailsService;
import com.brihaspathee.artemis.auth.JwtUtil;
import com.brihaspathee.artemis.domain.security.Authority;
import com.brihaspathee.artemis.domain.security.Role;
import com.brihaspathee.artemis.domain.security.User;
import com.brihaspathee.artemis.web.model.*;
import com.brihaspathee.artemis.web.resource.interfaces.AuthenticateAPI;
import com.brihaspathee.artemis.web.response.ArtemisApiResponse;
import com.sun.xml.bind.v2.TODO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 14, June 2022
 * Time: 5:27 AM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.web.resource.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthenticateResource implements AuthenticateAPI {

    /**
     * Spring security provided authentication manager
     */
    private final AuthenticationManager authenticationManager;

    private final AccountManagementUserDetailsService securityUserDetailsService;

    private final JwtUtil jwtUtil;

    /**
     * Authenticates the username and password that is passed in the authentication request
     * The authentication request is passed in the body of the request
     * @param authenticationRequest
     * @return
     */
    @Override
    public ResponseEntity<ArtemisApiResponse<AuthenticationResponse>> authenticate(AuthenticationRequest authenticationRequest) {
        // Authenticate using the authentication manager provided by spring
        // It used the UsernamePasswordAuthenticationToken class to authenticate the user
        // if the password is invalid it will throw "BadCredentialsException"
        // If the username is invalid it will throw "UserNotFoundException"
        // Both these exceptions are handled in the "ApiErrorHandler"
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()));

        final User userDetails = securityUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        return getAuthenticationResponse(userDetails);
    }



    /**
     * Authenticates the username and password
     * @param user
     * @return
     */
    @Override
    public ResponseEntity<ArtemisApiResponse<AuthenticationResponse>> authenticate(@AuthenticationPrincipal User user){
        return getAuthenticationResponse(user);
//        final String jwt = jwtUtil.generateToken(user);
//        UserDto userDto = getUserDto(user);
//        AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
//                .authToken(jwt)
//                .subject(userDto)
//                .isAuthenticated(true)
//                .authMessage("Authentication Successful")
//                .build();
//        ArtemisApiResponse<AuthenticationResponse> apiResponse = ArtemisApiResponse.<AuthenticationResponse>builder()
//                .response(authenticationResponse)
//                .status(HttpStatus.OK)
//                .statusCode(200)
//                .message("Authenticated Successfully")
//                .build();
//        return ResponseEntity.ok(apiResponse);
    }

    /**
     * Creates the authentication response after successful authentication of the user
     * @param userDetails
     * @return
     */
    private ResponseEntity<ArtemisApiResponse<AuthenticationResponse>> getAuthenticationResponse(User userDetails) {
        final String jwt = jwtUtil.generateToken(userDetails);
        UserDto userDto = getUserDto(userDetails);
        AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
                .authToken(jwt)
                .subject(userDto)
                .isAuthenticated(true)
                .authMessage("Authentication Successful")
                .build();
        ArtemisApiResponse<AuthenticationResponse> apiResponse = ArtemisApiResponse.<AuthenticationResponse>builder()
                .timestamp(LocalDateTime.now())
                .response(authenticationResponse)
                .status(HttpStatus.OK)
                .statusCode(200)
                .message("Authenticated Successfully")
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    /**
     * Map user information to UserDto
     * @param user
     * @return
     */
    private UserDto getUserDto(User user){
        UserDto userDto = UserDto.builder()
                .username(user.getUsername())
                .roleDtos(new ArrayList<>())
                //.password(user.getPassword())
                .build();
        Set<Role> roles = user.getRoles();
        roles.stream().forEach(role -> {
            RoleDto roleDto = RoleDto.builder()
                    .roleName(role.getRoleName())
                    .authorityDtos(new ArrayList<>())
                    .build();
            Set<Authority> authorities = role.getAuthorities();
            authorities.stream().forEach(authority -> {
                AuthorityDto authorityDto = AuthorityDto.builder()
                        .permission(authority.getPermission())
                        .build();
                roleDto.getAuthorityDtos().add(authorityDto);
            });
            userDto.getRoleDtos().add(roleDto);
        });
        return userDto;
    }
}
