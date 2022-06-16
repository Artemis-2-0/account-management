package com.brihaspathee.artemis.domain.repository;

import com.brihaspathee.artemis.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 14, June 2022
 * Time: 4:40 PM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
