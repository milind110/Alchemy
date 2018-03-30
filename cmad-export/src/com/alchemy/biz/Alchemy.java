package com.alchemy.biz;

import java.util.List;

import org.bson.types.ObjectId;

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
	public void addBlog(Blog blog) throws DuplicateBookException, InvalidBlogException {
		if (blog == null || blog.getTitle().trim().length() <= 0) {
			throw new InvalidBlogException();
		}
	}

	@Override
	public Blog getBlog(ObjectId blogId) throws BlogNotFoundException {
		Blog blog = AppManager.getInstance().getBlogdao().getBlog(blogId);
		if (blog == null) {
			throw new BlogNotFoundException();
		}
		return blog;
	}

	@Override
	public List<Blog> searchBlog(String filter) throws BloggerException {
		return AppManager.getInstance().getBlogdao().getBlogs();
	}
}
