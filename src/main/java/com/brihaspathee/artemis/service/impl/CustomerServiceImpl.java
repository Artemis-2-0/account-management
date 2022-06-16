package com.brihaspathee.artemis.service.impl;

import com.brihaspathee.artemis.domain.entity.Customer;
import com.brihaspathee.artemis.domain.repository.CustomerRepository;
import com.brihaspathee.artemis.exception.CustomerNotFoundException;
import com.brihaspathee.artemis.mapper.interfaces.CustomerMapper;
import com.brihaspathee.artemis.service.interfaces.CustomerService;
import com.brihaspathee.artemis.web.model.CustomerDto;
import com.brihaspathee.artemis.web.model.CustomerSet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 14, June 2022
 * Time: 4:39 PM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    public CustomerDto getCustomerById(UUID customerSK) {
        Customer customer = customerRepository.findById(customerSK).orElseThrow( () -> {
            throw new CustomerNotFoundException("Customer with id " + customerSK + " not found");
        });
        return customerMapper.customerToCustomerDto(customer);
    }

    @Override
    public CustomerSet getAllCustomers() {
        Set<Customer> customers = customerRepository.findAll().stream().collect(Collectors.toSet());
        Set<CustomerDto> customerDtos = customerMapper.customersToCustomerDto(customers);
        return CustomerSet.builder()
                .customerDtos(customerDtos)
                .build();
    }
}
