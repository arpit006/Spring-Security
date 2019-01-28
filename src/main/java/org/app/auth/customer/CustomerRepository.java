package org.app.auth.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {

    CustomerEntity findByUserName(String userName);
}
