package com.alchemy.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// TODO : what is this bson ?
import org.bson.types.ObjectId;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity
public class Blog {
	// TODO : should blog have a defined primary key Or use mongo generated ?
	/* http://www.foobaracademy.com/morphia-hello-world-example/ recommends to use ObjectId */
	@Id
	@JsonSerialize(using = CustomObjIdSerializer.class)
	private ObjectId objectId;
	private String userId;
	private String title;
	private String contents;
	private String tags;
	private int likes;

	private Date createdOn;
		
	@Reference
	private List<Comment> comments = new ArrayList<Comment>();

	public Blog() {
		// TODO Auto-generated constructor stub
	}
	
	public Blog(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	public String getAuthorId() {
		return userId;
	}

	public void setAuthorId(String userId) {
		this.userId = userId;
	}
	
	public Date getcreatedOn() {
		return createdOn;
	}

	public void setcreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}	
	
	public ObjectId getObjectId() {
		return objectId;
	}

	public void setObjectId(ObjectId objectId) {
		this.objectId = objectId;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public void addComment(Comment comment) {
		this.comments.add(comment);
	}

	@Override
	public String toString() {
		return "@userID: " + userId + " " + title + " { " + tags + " }";
	}
	
}
