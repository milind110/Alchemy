package com.alchemy.biz;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.alchemy.api.Blog;
import com.alchemy.api.Comment;
import com.alchemy.api.IBlogDao;
import com.alchemy.api.ICommentDao;
import com.alchemy.api.IUserDao;
import com.alchemy.api.User;
import com.mongodb.MongoClient;

public class AppManager {
	
	private static AppManager inst;
	private IBlogDao blogdao;
	private IUserDao userdao;
	private ICommentDao commentsdao;

	private AppManager() {
		// TODO : modularize this 
		MongoClient mongoClient = new MongoClient("127.0.0.1:27017");
		Morphia morphia = new Morphia();
		String databaseName = "cmad-blogs";
		Datastore ds = morphia.createDatastore(mongoClient, databaseName);
		
		blogdao = new BlogDao(Blog.class, ds);
		userdao = new UserDao(User.class, ds);
		commentsdao = new CommentDao(Comment.class, ds);
	}
	
	public static AppManager getInstance() {
		if (inst == null) {
			inst = new AppManager();
		}
		return inst;
	}

	public IBlogDao getBlogdao() {
		return blogdao;
	}

	public IUserDao getUserdao() {
		return userdao;
	}

	public ICommentDao getCommentsdao() {
		return commentsdao;
	}	
}
