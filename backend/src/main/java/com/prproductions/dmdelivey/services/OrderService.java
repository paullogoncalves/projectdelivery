package com.prproductions.dmdelivey.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prproductions.dmdelivey.dtos.OrderDTO;
import com.prproductions.dmdelivey.entites.Order;
import com.prproductions.dmdelivey.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repo;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAllByOrderByStatusAsc() {
		List<Order> list = repo.findOrdersWithProducts();
		return list.stream().map(p -> new OrderDTO(p)).collect(Collectors.toList());
		
	}
}
