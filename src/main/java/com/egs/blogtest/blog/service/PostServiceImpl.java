/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egs.blogtest.blog.service;

import com.egs.blogtest.blog.dao.PostDAO;
import com.egs.blogtest.blog.entities.Post;
import java.util.Collection;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduardm
 */
@Service("postService")
@Component
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDAO postDAO;

    @Override
    public int getPostCount() {
        return postDAO.getPostCount();
    }

    @Override
    public Post getPostById(Long id) {
        return postDAO.getPostById(id);
    }

    @Override
    public Collection<Post> getAllPosts(Integer start, Integer max) {
        return postDAO.getAllPosts(start, max);
    }

    @Override
    public Long savePost(Post post) {
        return postDAO.savePost(post);
    }

    @Override
    public boolean deletePost(Long id) {
        return postDAO.deletePost(id);
    }

    @Override
    public boolean updatePost(Post post) {
        return postDAO.updatePost(post);
    }

    @Override
    public Collection<Post> getPostsByDate(Date startDate, Date endDate) {
        return postDAO.getPostsByDate(startDate, endDate);
    }

}
