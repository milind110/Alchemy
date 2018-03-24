package com.glarimy.cmad;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.bson.types.ObjectId;

public class BlogDao extends BasicDAO<Blog, ObjectId> implements IBlogDao {

	public BlogDao(Class<Blog> entityClass, Datastore ds) {
		super(entityClass, ds);
	}

	@Override
	public List<Blog> getBlogs() {
		return find().asList();
	}

	@Override
	public Blog getBlog(ObjectId blogId) {
		Query<Blog> query = createQuery().field("objId").equal(blogId);
		// TODO : is there any other way ?
		return query.asList().get(0);
	}

	@Override
	public void addBlog(Blog blog) {
		save(blog);
	}

	@Override
	public void deleteBlog(Blog blog) {
		delete(blog);
	}
}
