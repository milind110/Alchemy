package com.glarimy.cmad;

import java.util.List;

import org.bson.types.ObjectId;

public interface IBlogDao {
	public List<Blog> getBlogs();
	public Blog getBlog(ObjectId blogId);
	public void addBlog(Blog blog);
	public void deleteBlog(Blog blog);
}
