package com.demo.swagger.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.swagger.model.Book;

@Repository
public class BookDao {

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays
			.asList("");

	public Book findBook(Long id) {
		if (id == null)
			return null;
		return null;
	}
}
