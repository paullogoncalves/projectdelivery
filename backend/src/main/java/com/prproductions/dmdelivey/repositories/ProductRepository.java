package com.prproductions.dmdelivey.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prproductions.dmdelivey.entites.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findAllByOrderByNameAsc();
}
