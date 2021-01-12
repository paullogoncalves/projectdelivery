package com.prproductions.dmdelivey.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prproductions.dmdelivey.dtos.OrderDTO;
import com.prproductions.dmdelivey.dtos.ProductDTO;
import com.prproductions.dmdelivey.entites.Order;
import com.prproductions.dmdelivey.entites.Product;
import com.prproductions.dmdelivey.enums.OrderStatus;
import com.prproductions.dmdelivey.repositories.OrderRepository;
import com.prproductions.dmdelivey.repositories.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private ProductRepository prodRepo;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAllByOrderByStatusAsc() {
		List<Order> list = orderRepo.findOrdersWithProducts();
		return list.stream().map(p -> new OrderDTO(p)).collect(Collectors.toList());	
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), 
				Instant.now(), OrderStatus.PENDING);
		for (ProductDTO p: dto.getProducts()) {
			Product product = prodRepo.getOne(p.getId());
			order.getProducts().add(product);
		}
		order = orderRepo.save(order);
		return new OrderDTO(order);
	}
	
	@Transactional
	public OrderDTO setDelivered(Long id) {
		Order order = orderRepo.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		order = orderRepo.save(order);
		return new OrderDTO(order);
		
	}
}
