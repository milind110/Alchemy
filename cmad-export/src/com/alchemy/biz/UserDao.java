package com.alchemy.biz;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

import com.alchemy.api.IUserDao;
import com.alchemy.api.User;

public class UserDao extends BasicDAO<User, String> implements IUserDao {

	public UserDao(Class<User> entityClass, Datastore ds) {
		super(entityClass, ds);
	}

	@Override
	public List<User> getUsers() {
		return find().asList();
	}	
	
	@Override
	public User getUser(String userId) {
		System.out.println("running get by userId: " + userId);		
		ObjectId objectId = new ObjectId(userId);
		User result = ds.get(User.class, objectId);
		return result;		
	}

	@Override
	public void addUser(User user) {
		save(user);
	}

	@Override
	public void deleteUser(User user) {
		delete(user);
	}
}
