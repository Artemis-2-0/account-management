package com.brihaspathee.artemis.mapper.interfaces;

import com.brihaspathee.artemis.domain.entity.Customer;
import com.brihaspathee.artemis.web.model.CustomerDto;

import java.util.List;
import java.util.Set;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 14, June 2022
 * Time: 4:03 PM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.mapper.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDto customerDto);
    Set<CustomerDto> customersToCustomerDto(Set<Customer> customers);
    Set<Customer> customerDtosToCustomers(Set<CustomerDto> customerDtos);
}
