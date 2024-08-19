package com.example.Order_Service.mapper;

import com.example.Order_Service.domain.Book;
import com.example.Order_Service.domain.Ordering;
import com.example.Order_Service.domain.orderStatus;
import com.example.Order_Service.dto.OrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {



    public Ordering toEntity(OrderDto dto){
        Ordering ordering = new Ordering();
        ordering.setBookId(dto.bookId());
        ordering.setQuantity(dto.quantity());
        ordering.setStatus(orderStatus.CONFIRMED);
        return ordering;
    }

}
