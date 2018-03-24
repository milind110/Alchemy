package com.glarimy.cmad;

// TODO : what is this bson ?
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import com.mongodb.util.JSON;

@Entity
public class Blog {
	// TODO : should blog have a defined primary key Or use mongo generated ?
	/* http://www.foobaracademy.com/morphia-hello-world-example/ recommends to use ObjectId */
	@Id
	private ObjectId objectId;
	private String title;
	private String contents;
	private String tags;
	private int likes;
	
	@Reference
	User author;

	public Blog() {
		// TODO Auto-generated constructor stub
	}
	
	public Blog(User author, String title) {
		super();
		this.author = author;
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
	
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public ObjectId getObjectId() {
		return objectId;
	}

	public void setObjectId(ObjectId objectId) {
		this.objectId = objectId;
	}

	@Override
	public String toString() {
		return "@" + author.getName() + " " + title + " { " + tags + " }";
	}
}
