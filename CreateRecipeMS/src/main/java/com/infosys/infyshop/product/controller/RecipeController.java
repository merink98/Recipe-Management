package com.infosys.infyshop.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.infyshop.product.dto.RecipeDTO;
import com.infosys.infyshop.product.exception.RecipeException;
import com.infosys.infyshop.product.service.RecipeService;

@RestController
@CrossOrigin
public class RecipeController {

	@Autowired
	RecipeService getRecipeService;
	
	@PostMapping(value="/createrecipe", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createRecipe(@RequestBody RecipeDTO newRecipe) throws RecipeException{
		String message=getRecipeService.createRecipe(newRecipe);
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}
	
}
