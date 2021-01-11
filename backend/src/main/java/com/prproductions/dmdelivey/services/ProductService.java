package com.prproductions.dmdelivey.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prproductions.dmdelivey.dtos.ProductDTO;
import com.prproductions.dmdelivey.entites.Product;
import com.prproductions.dmdelivey.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll() {
		List<Product> list = repo.findAll();
		return list.stream().map(p -> new ProductDTO(p)).collect(Collectors.toList());
		
	}
	
	public List<ProductDTO> findAllByOrderByNameAsc() {
		List<Product> list = repo.findAllByOrderByNameAsc();
		return list.stream().map(p -> new ProductDTO(p)).collect(Collectors.toList());
	}
	

	
}


	
