package com.alchemy.api;

import java.util.List;

import com.alchemy.biz.Blog;

public interface IBlogger {
	void add (Blog book) throws DuplicateBookException, InvalidBlogException, BloggerException;
	Blog find (int blogId) throws BlogNotFoundException, BloggerException;
	List<Blog> search(String filter) throws BloggerException;
}
