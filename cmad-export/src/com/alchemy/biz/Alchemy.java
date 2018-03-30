package com.alchemy.biz;

import java.util.List;

import com.alchemy.api.IBlogger;
import com.alchemy.api.Blog;
import com.alchemy.api.exceptions.BlogNotFoundException;
import com.alchemy.api.exceptions.BloggerException;
import com.alchemy.api.exceptions.DuplicateBookException;
import com.alchemy.api.exceptions.InvalidBlogException;

public class Alchemy implements IBlogger {
	
	public Alchemy() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(Blog blog) throws DuplicateBookException, InvalidBlogException {
		if (blog == null || blog.getTitle().trim().length() <= 0) {
			throw new InvalidBlogException();
		}
	}

	@Override
	public Blog find(int blogId) throws BlogNotFoundException {
		throw new BlogNotFoundException();
	}

	@Override
	public List<Blog> search(String filter) throws BloggerException {
		return AppManager.getInstance().getBlogdao().getBlogs();
	}

}
