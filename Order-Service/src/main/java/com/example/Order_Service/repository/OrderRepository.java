package com.example.Order_Service.repository;

//import com.example.Order_Service.domain.Order;
import com.example.Order_Service.domain.Ordering;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Ordering,Long> {
}
