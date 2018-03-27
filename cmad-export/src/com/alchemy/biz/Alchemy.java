package com.alchemy.biz;

import java.util.List;

import com.alchemy.api.BlogNotFoundException;
import com.alchemy.api.BloggerException;
import com.alchemy.api.DuplicateBookException;
import com.alchemy.api.IBlogger;
import com.alchemy.api.InvalidBlogException;

public class Alchemy implements IBlogger {

	@Override
	public void add(Blog blog) throws DuplicateBookException, InvalidBlogException {
		if (blog == null || blog.getTitle().trim().length() <= 0 || blog.getIsbn() <= 0) {
			throw new InvalidBlogException();
		}
	}

	@Override
	public Blog find(int blogId) throws BlogNotFoundException {
		if (blogId > 0) {
			Blog blog = new Blog();
			blog.setIsbn(blogId);
			blog.setTitle("Blog_" + blogId);
			return blog;
		}
		throw new BlogNotFoundException();
	}

	@Override
	public List<Blog> search(String filter) throws BloggerException {
		// TODO Auto-generated method stub
		return null;
	}

}
