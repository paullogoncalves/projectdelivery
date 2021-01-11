package com.prproductions.dmdelivey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prproductions.dmdelivey.entites.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
