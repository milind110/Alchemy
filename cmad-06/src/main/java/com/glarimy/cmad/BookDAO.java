package com.glarimy.cmad;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

public class BookDAO extends BasicDAO<Book, String> {

	public BookDAO(Class<Book> entityClass, Datastore ds) {
		super(entityClass, ds);
	}

	public List<Book> findByAuthor(String author) {
		Query<Book> query = createQuery().field("author").contains(author); //.field("isbn").lessThan(10000);
		return query.asList();
	}

}
