package com.egs.blogtest.blog.entities;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Post.class)
public abstract class Post_ {

	public static volatile SingularAttribute<Post, Date> registeredDate;
	public static volatile SingularAttribute<Post, Integer> rating;
	public static volatile SingularAttribute<Post, Long> id;
	public static volatile SingularAttribute<Post, String> title;
	public static volatile SingularAttribute<Post, String> userName;
	public static volatile SingularAttribute<Post, User> user;
	public static volatile SingularAttribute<Post, Status> status;

}

