package com.example.Customer_Service.repository;

import com.example.Customer_Service.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
