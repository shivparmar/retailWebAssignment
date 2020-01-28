package com.nagarro.poc.retail.controller;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.poc.retail.dto.UserDto;
import com.nagarro.poc.retail.dto.UserTypeDto;
import com.nagarro.poc.retail.model.User;
import com.nagarro.poc.retail.model.UserType;
import com.nagarro.poc.retail.repository.UserRepository;
import com.nagarro.poc.retail.repository.UserTypeRepository;

import java.util.Date;

/**
 * @author Nagarro
 * @since January 28, 2020
 */
@RestController
@RequestMapping(value = "/user/")
public class UserController {

    Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;

    @PostMapping("add")
    public Integer addUser(@RequestBody UserDto userDto) {
        Integer userId = null;
        try {
            LOGGER.info("Adding User ");
            User user = new User();
            user.setUsername(userDto.getUsername());
            UserType userType = new UserType();
            userType.setUserTypeId(userDto.getUserTypeId());
            user.setUserType(userType);
            user.setRegistrationDate(new Date());
            User userModel = userRepository.save(user);
            userId = userModel.getUserId();
        } catch (HibernateException e) {
            LOGGER.error("unable to add user ", e);
        }
        return userId;
    }


    @PostMapping("type/add")
    public Integer addUserCategory(@RequestBody UserTypeDto userTypeDto) {
        Integer userTypeId = null;
        try {
            LOGGER.info("Adding Product ");
            UserType userType = new UserType();
            userType.setUserType(userTypeDto.getUserType());
            userType.setDiscount(userTypeDto.getDiscount());
            UserType userTypeModel = userTypeRepository.save(userType);
            userTypeId = userTypeModel.getUserTypeId();
        } catch (HibernateException e) {
            LOGGER.error("unable to add user type ", e);
        }
        return userTypeId;
    }

}
