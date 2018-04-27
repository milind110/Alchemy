package com.alchemy.biz;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.bson.types.ObjectId;

import com.alchemy.api.IBlogger;
import com.alchemy.api.Blog;
import com.alchemy.api.exceptions.*;
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
	
	/* User operations */
	
	@Override
	public String signupNewUser(User user)
			throws BloggerException {
		
		//TODO add checks for user already exists and invalid user details.
		
		AppManager.getInstance().getUserdao().addUser(user);		
		String token = issueToken(user.getUserId());
		return token;
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
	
	@Override
	public void deleteUser(String userId) throws BloggerException {
		AppManager.getInstance().getUserdao().deleteUser(userId);
		return ;
	}
	
	
	/* Login / Logout related functions. */
	//TODO refactor this into a separate module.
	private String issueToken(String userId) {
		String jwToken = null;
		try {
			Algorithm algorithm = Algorithm.HMAC256("secret");
			jwToken= JWT.create()
					.withIssuer("auth0")
					.withSubject(userId)
					.sign(algorithm);
		} catch (UnsupportedEncodingException exception){
			//UTF-8 encoding not supported
			System.out.println("Token issue failed: "+exception);
		} catch (JWTCreationException exception){
			//Invalid Signing configuration / Couldn't convert Claims.
			System.out.println("Token issue failed: "+exception);
		}
		return jwToken;
	}
	
	public String loginUser(String userId,String password) throws SecurityException,/*InvalidCredentialsException, */BloggerException {
		// Authenticate the user using the credentials provided
		if(authenticate(userId, password)) {
			// Issue a token for the user
			String token = issueToken(userId);
			// Return the token on the response
			if(token == null){
				throw new BloggerException();
			}else
				return token;
		} else {
			throw new SecurityException("Invalid user/password");
		}
		
	}
	
	private boolean authenticate(String userId, String password) {
		System.out.println("alchemy blogger authenticate userId: "+userId);
		boolean res = false;
		User user = AppManager.getInstance().getUserdao().getUser(userId);
		if(user != null){
			String storedPassword = user.getPassword();
			System.out.println("authenticate storedPassword: " + storedPassword);
			System.out.println("authenticate password != storedPassword: " + password.equals(storedPassword));
			if(password.equals(storedPassword)){				
				res = true;
			}
		}
		return res;
	}	
	}

