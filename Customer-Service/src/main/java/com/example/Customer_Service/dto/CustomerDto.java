package com.example.Customer_Service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CustomerDto (

    @NotNull(message = "Customer should not be empty")
    String customerName,

    @NotNull(message = "Customer should not be empty")
    @Pattern(regexp = "^\\d{10}$" , message = "Incorrect Format")
    String customerNumber,

    @NotNull(message = "Customer should not be empty")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Invalid email format")
    String customerEmail

){}
