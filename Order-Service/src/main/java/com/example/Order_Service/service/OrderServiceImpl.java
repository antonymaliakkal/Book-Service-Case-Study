package com.example.Order_Service.service;

import com.example.Order_Service.domain.Book;
import com.example.Order_Service.domain.Ordering;
import com.example.Order_Service.domain.orderStatus;
import com.example.Order_Service.dto.OrderDto;
import com.example.Order_Service.exception.OrderNotFoundException;
import com.example.Order_Service.fiegnClient.BookService;
import com.example.Order_Service.mapper.OrderMapper;
import com.example.Order_Service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    BookService bookService;

    public Boolean checkStock(Long bookId , int quantity){
        Book book = bookService.getBookById(bookId);
        if(book.getBookStock() >= quantity){
            String output = bookService.reduceStock(bookId,quantity);
            System.out.println(output);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Ordering createOrder(OrderDto dto) {

        Book book = bookService.getBookById(dto.bookId());

        if(checkStock(dto.bookId(), dto.quantity())){
            Ordering ordering = orderMapper.toEntity(dto);
            orderRepository.save(ordering);
            return ordering;
        }
        throw new OrderNotFoundException("Only " + book.getBookStock() + " stocks are available") ;
    }

    @Override
    public Ordering getOrderById(Long id) {
        Optional<Ordering> ordering = orderRepository.findById(id);
        if(ordering.isPresent()){
            return ordering.get();
        }
        throw new OrderNotFoundException("OrderNot Found") ;
    }

    @Override
    public List<Ordering> getAllOrder() {
        return orderRepository.findAll();

    }

    @Override
    public Ordering updateOrder(Long id , OrderDto dto) {
        Optional<Ordering> ordering = orderRepository.findById(id);
        if(ordering.isPresent()){
            Ordering order = ordering.get();
            if(checkStock(dto.bookId(), dto.quantity())){
                order.setQuantity(dto.quantity());
                order.setBookId(dto.bookId());
                orderRepository.save(order);
                return order;
            }
            throw new OrderNotFoundException("Order Not Found") ;
        }
        throw new OrderNotFoundException("Order Not Found") ;
    }


    @Override
    public Ordering deleteOrder(Long id) {
        Optional<Ordering> ordering = orderRepository.findById(id);
        if(ordering.isPresent()){
            Ordering order = ordering.get();
            order.setStatus(orderStatus.CANCELLED);
            orderRepository.save(order);
            return order;
        }
        throw new OrderNotFoundException("OrderNot Found") ;
    }
}
