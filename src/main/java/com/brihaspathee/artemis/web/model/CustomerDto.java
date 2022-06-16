package com.brihaspathee.artemis.web.model;

import com.brihaspathee.artemis.reference.data.Gender;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 14, June 2022
 * Time: 12:53 PM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private UUID customerSK;

    private String customerNumber;

    private String firstName;

    private String middleName;

    private String lastName;

    private LocalDate dateOfBirth;

    private Gender gender;

    private Set<AccountDto> accountDtos;

    @Override
    public String toString() {
        return "CustomerDto{" +
                "customerSK=" + customerSK +
                ", customerNumber='" + customerNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                '}';
    }
}
