package com.nagarro.poc.retail.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.poc.retail.model.User;
import com.nagarro.poc.retail.model.UserType;

/**
 * @author Nagarro
 * @since January 28, 2020
 */
@Repository
public interface UserTypeRepository extends CrudRepository<UserType, Integer> {

}
