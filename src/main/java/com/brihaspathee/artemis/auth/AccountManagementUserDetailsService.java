package com.brihaspathee.artemis.auth;

import com.brihaspathee.artemis.domain.repository.UserRepository;
import com.brihaspathee.artemis.domain.security.User;
import com.brihaspathee.artemis.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 13, June 2022
 * Time: 11:30 AM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.auth
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AccountManagementUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Getting Details from DB using JPA");
        return userRepository.findUserByUsername(username).orElseThrow( () -> {
            return new UserNotFoundException("User with username " + username + " not found");
        }) ;
    }
}
