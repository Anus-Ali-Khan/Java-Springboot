package com.anuscode;

import org.springframework.data.jpa.repository.JpaRepository;

// JPA repository takes <dataType,  Id>

public interface CustomerRepository extends JpaRepository<Customer, Integer> {


}
