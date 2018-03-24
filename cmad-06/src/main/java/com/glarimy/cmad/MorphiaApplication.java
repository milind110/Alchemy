package com.glarimy.cmad;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class MorphiaApplication {
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("10.197.37.36:27017");
		Morphia morphia = new Morphia();
		String databaseName = "cmad-library";
		Datastore datastore = morphia.createDatastore(mongoClient, databaseName);
		
		User author = new User("Shrinivas Kamath", "shrkamat@cisco.com");
		BlogDao blogDao = new BlogDao(Blog.class, datastore);
		UserDao userDao = new UserDao(User.class, datastore);
		userDao.addUser(author);
		Blog blog = new Blog(author, "CMAD 101");
		blog.setContents("CMAD introduces us to web application development with best practises");
		blogDao.addBlog(blog);
		
		List<Blog> blogs = blogDao.getBlogs();
		
		System.out.println(blogs);
	}
}
