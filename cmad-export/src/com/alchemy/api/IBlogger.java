package com.alchemy.api;

import java.util.List;

import com.alchemy.api.exceptions.BlogNotFoundException;
import com.alchemy.api.exceptions.BloggerException;
import com.alchemy.api.exceptions.DuplicateBookException;
import com.alchemy.api.exceptions.InvalidBlogException;


public interface IBlogger {
	void add (Blog book) throws DuplicateBookException, InvalidBlogException, BloggerException;
	Blog find (int blogId) throws BlogNotFoundException, BloggerException;
	List<Blog> search(String filter) throws BloggerException;
}
