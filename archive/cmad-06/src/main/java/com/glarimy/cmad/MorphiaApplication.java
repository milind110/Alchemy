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
		CommentDao commentDao = new CommentDao(Comment.class, datastore);
		userDao.addUser(author);
		Blog blog = new Blog(author, "CMAD 101");
		blog.setContents("CMAD introduces us to modern web application development with best practises");
		blogDao.addBlog(blog);
		
		Comment comment = new Comment(author, blog, "I am add comments");
		blog.addComment(comment);
		
		commentDao.addComment(comment);
		blogDao.updateBlog(blog);
		
		printBlogs(blogDao);
		
		comment = new Comment(author, blog, "I can append comments too!");
		blog.addComment(comment);
		
		commentDao.addComment(comment);
		blogDao.updateBlog(blog);
		
		printBlogs(blogDao);
		
		// TODO : debug I see in DB comments are updated 
		comment.setCommentText("I cannot update comments :(");
		commentDao.updateComment(comment);
	}
	
	public static void printBlogs(BlogDao blogDao) {
		List<Blog> blogs = blogDao.getBlogs();
		
		for (Blog b : blogs) {
			System.out.println(b);
			System.out.println("\t\t\t" + b.getComments());
		}
	}
}
