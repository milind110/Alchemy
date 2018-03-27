package com.alchemy.web;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.alchemy.api.IBlogger;
import com.alchemy.biz.Alchemy;

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

	@GET
	@Path("/blog")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getBlog() {
		return Response.ok().entity(blogger.search(null)).build();
	}

	@GET
	@Path("/blog/{blogId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getBlog(@PathParam("blogId") String blogId) {
		return Response.ok().entity("GET blogId=" + blogId).build();
	}
}
