package com.example.Order_Service.dto;

import com.example.Order_Service.domain.Book;
import jakarta.validation.constraints.NotNull;

public record OrderDto(

//    @NotNull
    Long bookId,

    int quantity

){}
