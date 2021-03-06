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

/**
 *
 * @author eduardm
 */
public interface PostDAO {
    public int getPostCount();
    public Post getPostById(Long id);
    public Collection<Post> getAllPosts(Integer start, Integer max);
    public Long savePost(Post post);
    public boolean deletePost(Long id);
    public boolean updatePost(Post post);
    public Collection<Post> getPostsByDate(Date startDate, Date endDate);
}
