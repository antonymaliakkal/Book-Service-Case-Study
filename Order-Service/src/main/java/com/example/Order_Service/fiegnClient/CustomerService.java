package com.example.Order_Service.fiegnClient;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="customer-service" , url = "http://localhost:8200")
public interface CustomerService {
}
