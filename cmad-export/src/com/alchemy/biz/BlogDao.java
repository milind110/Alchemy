package com.alchemy.biz;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

import com.alchemy.api.IBlogDao;
import com.alchemy.api.Blog;

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
		Query<Blog> query = createQuery().field("objectId").equal(blogId);
		// TODO : is there any other way ?
		return query.asList().get(0);
	}

	@Override
	public void addBlog(Blog blog) {
		AppManager.getInstance().getUserdao().addUser(blog.getAuthor());
		AppManager.getInstance().getCommentsdao().addComment(blog.getComments());
		save(blog);
	}

	@Override
	public void deleteBlog(Blog blog) {
		delete(blog);
	}

	@Override
	public void updateBlog(Blog blog) {
		save(blog);
	}
}
