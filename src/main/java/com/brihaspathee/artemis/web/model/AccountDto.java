package com.brihaspathee.artemis.web.model;

import com.brihaspathee.artemis.reference.data.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 13, June 2022
 * Time: 11:34 AM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private UUID accountSK;

    private AccountType accountType;

    private String accountName;

    private String accountNumber;

    private BigDecimal accountBalance;

    @JsonIgnore
    private CustomerDto customerDto;

    @Override
    public String toString() {
        return "AccountDto{" +
                "accountSK=" + accountSK +
                ", accountType='" + accountType + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
