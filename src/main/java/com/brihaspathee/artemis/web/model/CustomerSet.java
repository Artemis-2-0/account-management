package com.brihaspathee.artemis.web.model;

import lombok.*;

import java.util.Set;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 14, June 2022
 * Time: 4:34 PM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSet {

    private Set<CustomerDto> customerDtos;

    @Override
    public String toString() {
        return "CustomerSet{" +
                "customerDtos=" + customerDtos +
                '}';
    }
}
