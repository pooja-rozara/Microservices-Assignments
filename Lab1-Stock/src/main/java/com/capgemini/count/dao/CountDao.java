package com.capgemini.count.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.count.dto.Count;
@Repository
public interface CountDao extends CrudRepository<Count, Integer> {

}
