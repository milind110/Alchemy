package com.alchemy.api;

import java.util.List;

import org.bson.types.ObjectId;

import com.alchemy.api.exceptions.BlogNotFoundException;
import com.alchemy.api.exceptions.BloggerException;
import com.alchemy.api.exceptions.DuplicateBookException;
import com.alchemy.api.exceptions.InvalidBlogException;


public interface IBlogger {
	
	/*blogger operations */
	
	void addBlog (Blog book) throws DuplicateBookException, InvalidBlogException, BloggerException;
	Blog getBlog (ObjectId blogId) throws BlogNotFoundException, BloggerException;
	List<Blog> searchBlog(String filter) throws BloggerException;
	
	
	/* TODO add user and comment operations here */
	String signupNewUser(User user) throws BloggerException;
	User searchUser(String filter) throws BloggerException;
	void updateUser(User user) throws BloggerException;
	void deleteUser(String userId) throws BloggerException;
}
