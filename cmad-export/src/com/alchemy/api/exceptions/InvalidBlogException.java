package com.alchemy.api.exceptions;

public class InvalidBlogException extends BloggerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2988641207291936635L;

	public InvalidBlogException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidBlogException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidBlogException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidBlogException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidBlogException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
