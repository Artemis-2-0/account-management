package com.brihaspathee.artemis.mapper.impl;

import com.brihaspathee.artemis.domain.entity.Customer;
import com.brihaspathee.artemis.mapper.interfaces.AccountMapper;
import com.brihaspathee.artemis.mapper.interfaces.CustomerMapper;
import com.brihaspathee.artemis.reference.data.Gender;
import com.brihaspathee.artemis.web.model.AccountDto;
import com.brihaspathee.artemis.web.model.CustomerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 14, June 2022
 * Time: 4:13 PM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.mapper.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CustomerMapperImpl implements CustomerMapper {

    private final AccountMapper accountMapper;

    @Override
    public CustomerDto customerToCustomerDto(Customer customer) {
        if(customer == null){
            return null;
        }
        CustomerDto customerDto = CustomerDto.builder()
                .customerSK(customer.getCustomerSK())
                .customerNumber(customer.getCustomerNumber())
                .firstName(customer.getFirstName())
                .middleName(customer.getMiddleName())
                .lastName(customer.getLastName())
                .dateOfBirth(customer.getDateOfBirth())
                .gender(Gender.valueOf(customer.getGender()))
                .build();
        if(customer.getAccounts() != null && !customer.getAccounts().isEmpty()){
            customerDto.setAccountDtos(accountMapper.accountsToAccountDtos(customer.getAccounts()));
        }
        return customerDto;
    }

    @Override
    public Customer customerDtoToCustomer(CustomerDto customerDto) {
        if(customerDto == null){
            return null;
        }
        Customer customer = Customer.builder()
                .customerSK(customerDto.getCustomerSK())
                .customerNumber(customerDto.getCustomerNumber())
                .firstName(customerDto.getFirstName())
                .middleName(customerDto.getMiddleName())
                .lastName(customerDto.getLastName())
                .dateOfBirth(customerDto.getDateOfBirth())
                .gender(customerDto.getGender().name())
                .build();
        if(customerDto.getAccountDtos() != null && !customerDto.getAccountDtos().isEmpty()){
            customer.setAccounts(accountMapper.accountDtosToAccounts(customerDto.getAccountDtos()));
        }
        return customer;
    }

    @Override
    public Set<CustomerDto> customersToCustomerDto(Set<Customer> customers) {

        return customers.stream().map(this::customerToCustomerDto).collect(Collectors.toSet());
    }

    @Override
    public Set<Customer> customerDtosToCustomers(Set<CustomerDto> customerDtos) {

        return customerDtos.stream().map(this::customerDtoToCustomer).collect(Collectors.toSet());
    }
}
