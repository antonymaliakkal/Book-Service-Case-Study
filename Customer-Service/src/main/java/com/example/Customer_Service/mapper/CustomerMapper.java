package com.example.Customer_Service.mapper;

import com.example.Customer_Service.domain.Customer;
import com.example.Customer_Service.dto.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toEntity(CustomerDto dto){
        Customer customer = new Customer();
        customer.setCustomerName(dto.customerName());
        customer.setCustomerNumber(dto.customerNumber());
        customer.setCustomerEmail(dto.customerEmail());
        return customer;
    }

    public Customer updateEntity(CustomerDto dto , Customer customer){
        customer.setCustomerName(dto.customerName());
        customer.setCustomerNumber(dto.customerNumber());
        customer.setCustomerEmail(dto.customerEmail());
        return customer;
    }


}
