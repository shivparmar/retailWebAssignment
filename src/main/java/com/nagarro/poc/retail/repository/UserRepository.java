package com.nagarro.poc.retail.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.poc.retail.model.User;

/**
 * @author Nagarro
 * @since January 28, 2020
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
