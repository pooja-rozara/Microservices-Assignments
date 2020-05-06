package com.capgemini.cart.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.cart.dto.Cart;
@Repository
public interface CartDao extends CrudRepository<Cart, Integer> {

}
