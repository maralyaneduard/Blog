/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egs.blogtest.blog.dao;

import com.egs.blogtest.blog.entities.User;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author eduardm
 */
public interface UserDAO {
    public int getUserCount();
    public User getUserById(Long id);
    public Collection<User> getAllUsers(Integer start, Integer max);
    public Long saveUser(User user);
    public boolean deleteUser(Long id);
    public boolean updateUser(User user);
    public Collection<User> getUsersByRegisteredDate(Date startDate, Date endDate);
}
