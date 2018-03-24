package com.glarimy.cmad;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity
public class Comment {
	@Id
	private ObjectId objectId;
	
	private String commentText;
	
	@Reference
	Blog blog;

	@Reference
	User author;

	public Comment() {
		// TODO Auto-generated constructor stub
	}
	
	Comment(User author, Blog blog, String commentText) {
		this.author = author;
		this.blog = blog;
		this.commentText = commentText;
	}

	public ObjectId getObjectId() {
		return objectId;
	}

	public void setObjectId(ObjectId objectId) {
		this.objectId = objectId;
	}
	
	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String toString() {
		return "@" + author.getName() + " ! " + commentText + " ! ";
	}
}
