package com.example.Customer_Service.service;

import com.example.Customer_Service.domain.Customer;
import com.example.Customer_Service.dto.CustomerDto;
import com.example.Customer_Service.exception.CustomerNotFoundException;
import com.example.Customer_Service.mapper.CustomerMapper;
import com.example.Customer_Service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public Customer createCustomer(CustomerDto dto) {
        return customerRepository.save(customerMapper.toEntity(dto));
    }

    @Override
    public Customer getCustomer(Long id) {
        Optional<Customer> customer  = customerRepository.findById(id);
        if(customer.isPresent()){
            return customer.get();
        }
        throw new CustomerNotFoundException("Invalid ID");
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Long id, CustomerDto dto) {
        Optional<Customer> customer  = customerRepository.findById(id);
        if (customer.isPresent()){
            Customer customer1 = customer.get();
            customer1 = customerMapper.updateEntity(dto , customer1);
            return customerRepository.save(customer1);
        }
        throw new CustomerNotFoundException("Invalid ID");
    }

    @Override
    public String deleteCustomer(Long id) {
        Optional<Customer> customer  = customerRepository.findById(id);
        if (customer.isPresent()) {
            customerRepository.deleteById(id);
            return "Deleted";
        }
        throw new CustomerNotFoundException("Invalid ID");
    }
}
