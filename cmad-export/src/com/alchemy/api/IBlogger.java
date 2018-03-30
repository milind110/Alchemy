package com.alchemy.api;

import java.util.List;

import com.alchemy.api.exceptions.BlogNotFoundException;
import com.alchemy.api.exceptions.BloggerException;
import com.alchemy.api.exceptions.DuplicateBookException;
import com.alchemy.api.exceptions.InvalidBlogException;


public interface IBlogger {
	void addBlog (Blog book) throws DuplicateBookException, InvalidBlogException, BloggerException;
	Blog getBlog (int blogId) throws BlogNotFoundException, BloggerException;
	List<Blog> searchBlog(String filter) throws BloggerException;
}
