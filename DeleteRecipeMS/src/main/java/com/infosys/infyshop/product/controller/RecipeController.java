package com.infosys.infyshop.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.infyshop.product.exception.RecipeException;
import com.infosys.infyshop.product.service.RecipeServiceImpl;

@RestController
@CrossOrigin
public class RecipeController {

	@Autowired
	RecipeServiceImpl getRecipeService;
	
	@GetMapping(value="/deleterecipe/{recipeName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteRecipe(@PathVariable String recipeName) throws RecipeException{
		String message=getRecipeService.deleteRecipe(recipeName);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
}
