package com.alchemy.web;

import java.net.URI;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.types.ObjectId;

import com.alchemy.api.Blog;
import com.alchemy.api.IBlogger;
import com.alchemy.api.exceptions.BloggerException;
import com.alchemy.biz.Alchemy;

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
}
