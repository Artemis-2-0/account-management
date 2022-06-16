package com.brihaspathee.artemis.encoders;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 13, June 2022
 * Time: 12:22 PM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.encoders
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
public class PasswordEncodingTest {

    static final String PASSWORD = "password";

    @Test
    void hashingMD5Example(){
        log.info(DigestUtils.md5DigestAsHex(PASSWORD.getBytes(StandardCharsets.UTF_8)));
    }

    @Test
    void hashingBCryptExample(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        log.info(bCryptPasswordEncoder.encode(PASSWORD));
    }

    @Test
    void hashingSCryptExample(){
        Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();
        log.info(pbkdf2PasswordEncoder.encode(PASSWORD));
    }
}
