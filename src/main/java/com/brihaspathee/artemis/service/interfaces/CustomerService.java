package com.brihaspathee.artemis.service.interfaces;

import com.brihaspathee.artemis.domain.entity.Customer;
import com.brihaspathee.artemis.web.model.CustomerDto;
import com.brihaspathee.artemis.web.model.CustomerSet;

import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 14, June 2022
 * Time: 4:38 PM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.service.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface CustomerService {

    CustomerDto getCustomerById(UUID customerSK);
    CustomerSet getAllCustomers();
}
