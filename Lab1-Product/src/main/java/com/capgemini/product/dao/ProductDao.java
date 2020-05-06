package com.capgemini.product.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.product.dto.Product;
@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {

}
