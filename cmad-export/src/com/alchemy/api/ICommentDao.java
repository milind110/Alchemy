package com.alchemy.api;

import java.util.List;

public interface ICommentDao {
	
	public List<Comment> getComments();
	public List<Comment> getComments(Blog blog);
	public List<Comment> getComments(User author);
	public void addComment(Comment comment);
	public void updateComment(Comment comment);
	public void deleteComment(Comment comment);
	void addComment(List<Comment> comments);
}
