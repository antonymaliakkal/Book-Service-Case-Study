package com.example.Order_Service.controller;

//import com.example.Order_Service.domain.Order;
import com.example.Order_Service.domain.Ordering;
import com.example.Order_Service.dto.OrderDto;
import com.example.Order_Service.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    OrderServiceImpl orderService;

    @PostMapping
    public ResponseEntity<Ordering> createOrder(@RequestBody OrderDto dto){
        Ordering ordering = orderService.createOrder(dto);
        return ResponseEntity.ok(ordering);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ordering> getOrderById(@PathVariable Long id){
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @GetMapping
    public ResponseEntity<List<Ordering>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrder());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ordering> updateOrder(@PathVariable Long id , @RequestBody OrderDto dto){
        return ResponseEntity.ok(orderService.updateOrder(id,dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Ordering> deleteOrder(@PathVariable Long id){
        return ResponseEntity.ok(orderService.deleteOrder(id));
    }
}
