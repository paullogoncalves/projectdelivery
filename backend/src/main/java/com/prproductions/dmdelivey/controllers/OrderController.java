package com.prproductions.dmdelivey.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prproductions.dmdelivey.dtos.OrderDTO;
import com.prproductions.dmdelivey.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService service;
  	
	@GetMapping
	public ResponseEntity<List<OrderDTO>> findOrdersWithProducts() {
		List<OrderDTO> list = service.findAllByOrderByStatusAsc();
		return ResponseEntity.ok().body(list);
	}
}
