package com.example.Customer_Service.controller;

import com.example.Customer_Service.domain.Customer;
import com.example.Customer_Service.dto.CustomerDto;
import com.example.Customer_Service.service.CustomerService;
import com.example.Customer_Service.service.CustomerServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

        @Autowired
        CustomerServiceImpl customerService;

        @PostMapping
        public ResponseEntity<Customer> createCustomer(@Valid @RequestBody CustomerDto dto){
                return ResponseEntity.ok(customerService.createCustomer(dto));
        }

        @GetMapping("/{id}")
        public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
                return ResponseEntity.ok(customerService.getCustomer(id));
        }

        @GetMapping
        public ResponseEntity<List<Customer>> getAllCustomer(){
                return ResponseEntity.ok(customerService.getAllCustomer());
        }

        @PutMapping("/{id}")
        public ResponseEntity<Customer> updateCustomer(@PathVariable Long id , @Valid CustomerDto dto){
                return ResponseEntity.ok(customerService.updateCustomer(id,dto));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
                String delete = customerService.deleteCustomer(id);
                return ResponseEntity.ok("Deleted User");
        }

}
