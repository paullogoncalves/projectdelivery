package com.prproductions.dmdelivey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prproductions.dmdelivey.entites.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
