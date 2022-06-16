package com.brihaspathee.artemis.web.resource.impl;

import com.brihaspathee.artemis.domain.security.User;
import com.brihaspathee.artemis.service.interfaces.CustomerService;
import com.brihaspathee.artemis.web.model.AccountDto;
import com.brihaspathee.artemis.web.model.CustomerDto;
import com.brihaspathee.artemis.web.model.CustomerSet;
import com.brihaspathee.artemis.web.resource.interfaces.CustomerAPI;
import com.brihaspathee.artemis.web.response.ArtemisApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 14, June 2022
 * Time: 4:35 PM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.web.resource.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class CustomerResource implements CustomerAPI {

    private final CustomerService customerService;

    @Override
    public ResponseEntity<ArtemisApiResponse<CustomerDto>> getCustomerById(String customerSK) {
        return null;
    }

    @Override
    public ResponseEntity<ArtemisApiResponse<CustomerSet>> getCustomer(User user) {
        log.info("Internal user or customer:{}", user.getCustomer());
        CustomerSet customerSet = CustomerSet.builder().build();
        if(user.getCustomer() != null){
            CustomerDto customerDto = customerService.getCustomerById(user.getCustomer().getCustomerSK());
            customerSet.setCustomerDtos(Set.of(customerDto));
        }else{
            customerSet = customerService.getAllCustomers();
        }
        ArtemisApiResponse<CustomerSet> apiResponse = ArtemisApiResponse.<CustomerSet>builder()
                .response(customerSet)
                .message("SUCCESS")
                .status(HttpStatus.OK)
                .statusCode(200)
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
