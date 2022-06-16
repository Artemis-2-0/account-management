package com.brihaspathee.artemis.config;

import com.brihaspathee.artemis.schema.validation.JSONSchemaValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 13, June 2022
 * Time: 12:17 PM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.config
 * To change this template use File | Settings | File and Code Template
 */
@Configuration
public class BeanConfig {

    @Bean
    public JSONSchemaValidator getJSONSchemaValidator(){
        return new JSONSchemaValidator();
    }

}
