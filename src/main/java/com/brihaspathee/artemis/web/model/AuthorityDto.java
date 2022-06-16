package com.brihaspathee.artemis.web.model;

import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 15, June 2022
 * Time: 11:05 AM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityDto {

    private String permission;

    @Override
    public String toString() {
        return "AuthorityDto{" +
                "permission='" + permission + '\'' +
                '}';
    }
}
