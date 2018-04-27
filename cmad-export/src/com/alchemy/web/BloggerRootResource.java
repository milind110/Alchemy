package com.alchemy.web;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.bson.types.ObjectId;

import com.alchemy.api.Blog;
import com.alchemy.api.IBlogger;
import com.alchemy.api.exceptions.*;
import com.alchemy.biz.Alchemy;
import com.alchemy.api.User;

/**
 * Servlet implementation class BloggerRootResource
 */
@Path("/v1")
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
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getBlog() {
		System.out.println("BloggerRootResource doing getblogs: ");
		return Response.ok().entity(blogger.searchBlog(null)).build();
	}

	@GET
	@Path("/blog/{blogId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getBlog(@PathParam("blogId") ObjectId blogId) {
		return Response.ok().entity(blogger.getBlog(blogId)).build();
	}

	@POST
	@Path("/blog")
	@Produces({ MediaType.APPLICATION_JSON })
	@RequireJWT
	public Response addBlog(@HeaderParam("userId") String userId, Blog blog, @Context UriInfo uriInfo) {
		
		System.out.println("BloggerRootResource addBlog userId: "+ userId);
		System.out.println("BloggerRootResource addBlog title: "+ blog.getTitle());
		//User author = blogger.searchUser(userId);
		blog.setAuthorId(userId);
		blogger.addBlog(blog);
		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
		uriBuilder.path(blog.getObjectId().toHexString());
		try {
			return Response.created(uriBuilder.build()).build();
		} catch (Exception e) {
			throw new BloggerException();
		}
	}
	
	
	/* user operations */
	
	//create 
	@POST
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON) 
	public Response signupNewUser(User user) {
		System.out.println("signupNewUser Userid :"+user.getUserId());
		String token = blogger.signupNewUser(user);
		System.out.println("BloggerController signupNewUser token :"+token);
		return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();
	}
	
	
	//read 
	@GET
	@Path("/user/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@RequireJWT
	public Response getUser(@PathParam("userId")String userId) {
		
		System.out.println("getting Userid: " + userId);
		User result = blogger.searchUser(userId);
		GenericEntity<User> entity = new GenericEntity<User>(result) {};
		
		return Response.ok(entity).build();
		
	}
	
	//update	
	@PUT
	@Path("/user/{userId}")
	@Consumes(MediaType.APPLICATION_JSON) 
	@RequireJWT	
	public Response updateUser(@PathParam("userId")String userId,User user) {
		System.out.println("updateUser userId:"+userId);
		user.setUserId(userId);
		blogger.updateUser(user);
		return Response.ok().build();
	}
	
	//delete	 
	@DELETE
	@Path("/user/{userId}")	 
	@RequireJWT
	public Response deleteUser(@PathParam("userId")String userId) {
		System.out.println("deleteUser userId:"+userId);
		blogger.deleteUser(userId);
		return Response.ok().build();
	}
	
	@GET
	@Path("/user/login")	
	//TODO here add the issued to token to a DB of valid tokens for that user. 
	public Response loginUser(@QueryParam("userId") String userId, @QueryParam("pwd") String pwd) {
		System.out.println("BloggerRootResource login userId :"+userId);
		String token = blogger.loginUser(userId, pwd);
		return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();
	}
	
	//TODO here actually mark the token as no longer valid
	@GET
	@Path("/user/logout")	
	public Response logoutUser(@QueryParam("userId") String userId) {
		System.out.println("BloggerRootResource logout userId :"+userId);		
		return Response.ok().build();
	}
}
