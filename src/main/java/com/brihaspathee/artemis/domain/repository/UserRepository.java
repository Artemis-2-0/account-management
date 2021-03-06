package com.brihaspathee.artemis.domain.repository;

import com.brihaspathee.artemis.domain.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 13, June 2022
 * Time: 11:24 AM
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findUserByUsername(String username);
}
