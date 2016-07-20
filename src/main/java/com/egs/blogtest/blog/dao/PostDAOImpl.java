/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egs.blogtest.blog.dao;

import com.egs.blogtest.blog.entities.Post;
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
@Repository("postDAO")
public class PostDAOImpl extends AbstractDAO implements PostDAO {

    @Override
    public int getPostCount() {
        EntityManager em = getEntityManager();
        return Integer.parseInt(em.createQuery("Select count(*) from Post p").getSingleResult().toString());
    }

    @Override
    public Post getPostById(Long id) {
        EntityManager em = getEntityManager();
        return em.find(Post.class, id);
    }

    @Override
    public Collection<Post> getAllPosts(Integer start, Integer max) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Post p WHERE p.id > 0 ORDER BY p.id DESC");
        query.setFirstResult(start);
        query.setMaxResults(max);
        return (Collection<Post>) query.getResultList();
    }

    @Override
    public Long savePost(Post post) {
        EntityManager em = getEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(post);
        et.commit();

        return post.getId();
    }

    @Override
    public boolean deletePost(Long id) {
        EntityManager em = getEntityManager();
        EntityTransaction et = em.getTransaction();

        Post post = em.find(Post.class, id);
        if (post != null) {
            et.begin();
            em.remove(post);
            et.commit();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updatePost(Post post) {
        if (post != null) {
            EntityManager em = getEntityManager();
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(post);
            et.commit();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Collection<Post> getPostsByDate(Date startDate, Date endDate) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Post p "
                    + "WHERE p.LastUpdatedDate > :startDate "
                    + "and p.LastUpdatedDate < :endDate ORDER BY p.id DESC").setParameter("startDate", startDate)
                    .setParameter("endDate", endDate);
        return (Collection<Post>) query.getResultList();
    }

}
