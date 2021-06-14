package com.infosys.infyshop.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.infyshop.product.dto.RecipeDTO;
import com.infosys.infyshop.product.exception.RecipeException;
import com.infosys.infyshop.product.service.RecipeServiceImpl;

@RestController
@CrossOrigin
public class RecipeController {

	@Autowired
	RecipeServiceImpl recipeService;
	
	@GetMapping(value="/getrecipe", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RecipeDTO>> getAllRecipes() throws RecipeException{
		List<RecipeDTO> list=recipeService.getAllRecipes();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping(value="/getrecipe/{recipeName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RecipeDTO> getSpecificRecipe(@PathVariable String recipeName) throws RecipeException{
		RecipeDTO recipe=recipeService.getSpecificRecipe(recipeName);
		return new ResponseEntity<>(recipe, HttpStatus.OK);
	}
	
}
