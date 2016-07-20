/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egs.blogtest.blog.service;

import com.egs.blogtest.blog.dao.UserDAO;
import com.egs.blogtest.blog.entities.User;
import java.util.Collection;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduardm
 */
@Service("userService")
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public int getUserCount() {
        return userDAO.getUserCount();
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public Collection<User> getAllUsers(Integer start, Integer max) {
        return userDAO.getAllUsers(start, max);
    }

    @Override
    public Long saveUser(User user) {
        return userDAO.saveUser(user);
    }

    @Override
    public boolean deleteUser(Long id) {
        return userDAO.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }

    @Override
    public Collection<User> getUsersByRegisteredDate(Date startDate, Date endDate) {
        return userDAO.getUsersByRegisteredDate(startDate, endDate);
    }

}
