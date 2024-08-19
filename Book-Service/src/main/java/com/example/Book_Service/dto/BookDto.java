package com.example.Book_Service.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record BookDto (

        @NotNull(message = "Title should not be null")
        @Size(min =  1, max = 255)
        String bookTitle,

        @NotNull(message = "Author should not be null")
        @Size(min =  1, max = 255)
        String bookAuthor,

        @NotNull(message = "Price should not be null")
        @Digits(fraction = 2 , message = "Price should have only 2 decimal points and less than $9,99,999", integer = 6)
        Double bookPrice,

        @NotNull(message = "Stock should not be null")
        @PositiveOrZero(message = "Stock should not be negative")
        int bookStock

){}
