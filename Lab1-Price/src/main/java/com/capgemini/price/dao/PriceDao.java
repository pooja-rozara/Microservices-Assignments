package com.capgemini.price.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.price.dto.Price;
@Repository
public interface PriceDao extends CrudRepository<Price, Integer> {

}
