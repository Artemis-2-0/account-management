package com.brihaspathee.artemis.web.model;

import lombok.*;

import java.util.Set;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 13, June 2022
 * Time: 11:42 AM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountSet {

    private Set<AccountDto> accountList;

    @Override
    public String toString() {
        return "AccountList{" +
                "accountList=" + accountList +
                '}';
    }
}
