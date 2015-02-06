package com.demo.swagger.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.swagger.model.Book;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/api/", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ApiOperation(value = "Retrieves a book based on their id")
	// @ApiErrors(value = {@ApiError(code = 404, reason =
	// "No book corresponding to the id was found")})
	@ResponseBody
	public ResponseEntity<String> showJson(
			@ApiParam(name = "id", required = true, value = "The id of the book that needs to be retrieved") @PathVariable("id") Long id) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		Book book = null;
		if (book == null) {
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		}
		return null;
	}
}
