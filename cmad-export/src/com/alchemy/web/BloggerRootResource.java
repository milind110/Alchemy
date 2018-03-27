package com.alchemy.web;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


/**
 * Servlet implementation class BloggerRootResource
 */
@Path("/v1")
public class BloggerRootResource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BloggerRootResource() {
        super();
    }

    @GET
    @Path("/blog")
    public Response getBlog()
    {
    	return Response.ok().entity("Hello, Blogger").build();
    }
}
