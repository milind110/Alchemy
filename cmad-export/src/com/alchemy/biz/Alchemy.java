package com.alchemy.biz;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.bson.types.ObjectId;

import com.alchemy.api.IBlogger;
import com.alchemy.api.Blog;
import com.alchemy.api.exceptions.BlogNotFoundException;
import com.alchemy.api.exceptions.BloggerException;
import com.alchemy.api.exceptions.DuplicateBookException;
import com.alchemy.api.exceptions.InvalidBlogException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import com.alchemy.api.User;

public class Alchemy implements IBlogger {

	public Alchemy() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addBlog(Blog blog) throws DuplicateBookException, InvalidBlogException {
		if (blog == null || blog.getTitle().trim().length() <= 0) {
			throw new InvalidBlogException();
		}
		AppManager.getInstance().getBlogdao().addBlog(blog);
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
	
	@Override
	public String signupNewUser(User user)
			throws BloggerException {
		
		//TODO add checks for user already exists and invalid user details.
		
		AppManager.getInstance().getUserdao().addUser(user);		
		String token = issueToken(user.getUserId());
		return token;
	}
	
	private String issueToken(String userId) {
		String jwtToken = null;
		try {
			Algorithm algorithm = Algorithm.HMAC256("secret");
			jwtToken= JWT.create()
					.withIssuer("auth0")
					.withSubject(userId)
					.sign(algorithm);
		} catch (UnsupportedEncodingException exception){
			//UTF-8 encoding not supported
			System.out.println("Token issue failed :"+exception);
		} catch (JWTCreationException exception){
			//Invalid Signing configuration / Couldn't convert Claims.
			System.out.println("Token issue failed :"+exception);
		}
		return jwtToken;
	}

	@Override
	public User searchUser(String filter) throws BloggerException {
		return AppManager.getInstance().getUserdao().getUser(filter);
	}
	
	@Override
	public void updateUser(User user) throws BloggerException{
		if (user == null || (AppManager.getInstance().getUserdao().getUser(user.getUserId()) == null))
			throw new BloggerException();
		
		AppManager.getInstance().getUserdao().updateUser(user);
	}
	}

