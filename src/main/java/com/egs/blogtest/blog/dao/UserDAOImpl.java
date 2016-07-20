/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egs.blogtest.blog.dao;

import com.egs.blogtest.blog.entities.Post;
import com.egs.blogtest.blog.entities.User;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eduardm
 */
@Component
@Repository("userDAO")
public class UserDAOImpl extends AbstractDAO implements UserDAO {

    @Override
    public int getUserCount() {
        EntityManager em = getEntityManager();
        return Integer.parseInt(em.createQuery("Select count(*) from User u").getSingleResult().toString());
    }

    @Override
    public User getUserById(Long id) {
        EntityManager em = getEntityManager();
        return em.find(User.class, id);
    }

    @Override
    public Collection<User> getAllUsers(Integer start, Integer max) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT u FROM User u WHERE u.id > 0 ORDER BY u.id DESC");
        query.setFirstResult(start);
        query.setMaxResults(max);
        return (Collection<User>) query.getResultList();
    }

    @Override
    public Long saveUser(User user) {
        EntityManager em = getEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(user);
        et.commit();

        return user.getId();
    }

    @Override
    public boolean deleteUser(Long id) {
        EntityManager em = getEntityManager();
        EntityTransaction et = em.getTransaction();

        User user = em.find(User.class, id);
        if (user != null) {
            et.begin();
            em.remove(user);
            et.commit();
            return true;
        } else {
            return false;
        }}

    @Override
    public boolean updateUser(User user) {
        if (user != null) {
            EntityManager em = getEntityManager();
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(user);
            et.commit();
            return true;
        } else {
            return false;
        }}

    @Override
    public Collection<User> getUsersByRegisteredDate(Date startDate, Date endDate) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT u FROM User u "
                    + "WHERE u.LastUpdatedDate > :startDate "
                    + "and u.LastUpdatedDate < :endDate ORDER BY u.id DESC").setParameter("startDate", startDate)
                    .setParameter("endDate", endDate);
        return (Collection<User>) query.getResultList();}

}
