package com.alchemy.biz;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

import com.alchemy.api.ICommentDao;
import com.alchemy.api.Comment;
import com.alchemy.api.Blog;
import com.alchemy.api.User;

public class CommentDao extends BasicDAO<Comment, ObjectId> implements ICommentDao {

	public CommentDao(Class<Comment> entityClass, Datastore ds) {
		super(entityClass, ds);
	}

	@Override
	public List<Comment> getComments() {
		return find().asList();
	}

	@Override
	public List<Comment> getComments(Blog blog) {
		Query<Comment> query = createQuery().field("blog.objectId").equal(blog.getObjectId());
		return query.asList();
	}

	@Override
	public List<Comment> getComments(User author) {
		Query<Comment> query = createQuery().field("author.email").equal(author.getEmail());
		return query.asList();
	}

	@Override
	public void addComment(Comment comment) {
		save(comment);
	}

	@Override
	public void updateComment(Comment comment) {
		save(comment);
	}

	@Override
	public void deleteComment(Comment comment) {
		delete(comment);
	}
}
