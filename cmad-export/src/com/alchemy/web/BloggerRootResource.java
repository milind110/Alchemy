package com.alchemy.web;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.types.ObjectId;

import com.alchemy.api.Blog;
import com.alchemy.api.IBlogger;
import com.alchemy.api.exceptions.BloggerException;
import com.alchemy.biz.Alchemy;
import com.alchemy.api.User;

/**
 * Servlet implementation class BloggerRootResource
 */
@Path("/v1")
@Produces({ MediaType.APPLICATION_JSON })
public class BloggerRootResource extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBlogger blogger;

	public BloggerRootResource() {
		super();
		blogger = new Alchemy();
	}

	/* blog operations */
	
	@GET
	@Path("/blog")
	public Response getBlog() {
		return Response.ok().entity(blogger.searchBlog(null)).build();
	}

	@GET
	@Path("/blog/{blogId}")
	public Response getBlog(@PathParam("blogId") ObjectId blogId) {
		return Response.ok().entity(blogger.getBlog(blogId)).build();
	}

	@POST
	@Path("/blog")
	public Response addBlog(Blog blog) {
		blogger.addBlog(blog);
		try {
			return Response.created(new URI(blog.getObjectId().toHexString())).build();
		} catch (Exception e) {
			throw new BloggerException();
		}
	}
	
	/* user operations */
	@POST
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON) 
	public Response signupNewUser(User user) {
		System.out.println("signupNewUser Userid :"+user.getUserId());
		String token = blogger.signupNewUser(user);
		System.out.println("BloggerController signupNewUser token :"+token);
		return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();
	}
	
	//TODO take user ID param here.
	@GET
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON) 
	public Response getUser() {
		
		List<User> list = blogger.searchUser(null);
		GenericEntity<List<User>> entity = new GenericEntity<List<User>>(list) {};
		System.out.println("getting Userid :");
		return Response.ok(entity).build();
		
		//TODO: Remove the temp code. 
		
		/*
		User res = new User();
		res.setEmail("sample@email.com");
		res.setName("John Doe");
		res.setUserId("deadbeef");
		
		return Response.ok().entity(res).build();
		*/
	}
	
	
}
