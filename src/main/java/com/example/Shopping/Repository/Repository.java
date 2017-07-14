package com.example.Shopping.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.Shopping.model.Product;

public interface Repository extends CrudRepository<Product, Long> {
	
	List<Product> findBySize(String size);
	List<Product> findByType(String size);
	List<Product> findByAvail(String size);

}
