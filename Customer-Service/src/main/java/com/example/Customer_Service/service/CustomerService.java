package com.example.Customer_Service.service;

import com.example.Customer_Service.domain.Customer;
import com.example.Customer_Service.dto.CustomerDto;
import java.util.List;

public interface CustomerService {

    public Customer createCustomer(CustomerDto dto);

    public Customer getCustomer(Long id);

    public List<Customer> getAllCustomer();

    public Customer updateCustomer(Long id , CustomerDto dto);

    public String deleteCustomer(Long id);

}
