package com.example.Order_Service.service;

//import com.example.Order_Service.domain.Order;
import com.example.Order_Service.domain.Ordering;
import com.example.Order_Service.dto.OrderDto;

import java.util.List;

public interface OrderService {

    public Ordering createOrder(OrderDto order);

    public Ordering getOrderById(Long id);

    public List<Ordering> getAllOrder();

    public Ordering updateOrder(Long id , OrderDto dto);

    public Ordering deleteOrder(Long id);

}
