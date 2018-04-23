package com.alchemy.biz;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.alchemy.api.IUserDao;
import com.alchemy.api.User;
import com.mongodb.WriteResult;

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
		//User result = ds.find(User.class).field("_id").equal(objectId).get();		
		return result;		
	}

	@Override
	public void addUser(User user) {
		save(user);
	}

	@Override
	public void deleteUser(String userId) {
		
		System.out.println("running delete by userId: " + userId);
		ObjectId objectId = new ObjectId(userId);

		final Query<User> qry = createQuery().field("_id").equal(objectId);
		WriteResult res = deleteByQuery(qry);		
		
		if (res.wasAcknowledged())
		{
			System.out.println("Delete was successful, affected records: " + res.getN() );
		}
		else
		{
			System.out.println("deleteUser - Write was not acknowledged");
		}
		
	}
	
	@Override
	public void updateUser(User user) {
		
		ObjectId objectId = new ObjectId(user.getUserId());	
		
		
		System.out.println("UserDao: doing updateUser");
		
		UpdateOperations<User> updateOptions = createUpdateOperations();

		if(user.getName() != null){
			System.out.println("UserDao: doing updateUser - name");
			updateOptions.set("name", user.getName());
		}
		
		if(user.getPassword() != null) {
			System.out.println("UserDao: doing updateUser - pwd ");
			updateOptions.set("password", user.getPassword());
		}
		
		if(user.getEmail() != null) {
			System.out.println("UserDao: doing updateUser - email");
			updateOptions.set("email", user.getEmail());
		}
				
		// TODO: This causes a type mismatch warning to be printed in console log from morphia query validator.
		update(createQuery().field("_id").equal(objectId), updateOptions);		
	}	
	
}
