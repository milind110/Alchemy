package com.glarimy.cmad;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

public class UserDao extends BasicDAO<User, String> implements IUserDao {

	public UserDao(Class<User> entityClass, Datastore ds) {
		super(entityClass, ds);
	}

	@Override
	public List<User> getUsers() {
		return find().asList();
	}

	@Override
	public User getUser(String email) {
		Query<User> query = createQuery().field(email).equal(email);
		return query.get();
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
