package com.infosys.infyshop.product.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.infyshop.product.dto.RecipeDTO;
import com.infosys.infyshop.product.entity.Recipe;
import com.infosys.infyshop.product.exception.RecipeException;
import com.infosys.infyshop.product.repository.RecipeRepository;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	RecipeRepository recipeRepository;
	
	//fetching all recipes
		public List<RecipeDTO> getAllRecipes() throws RecipeException{
			List<Recipe> recipes = recipeRepository.findAll();
			List<RecipeDTO> recipesDTOs = new ArrayList<>();
			if(!recipes.isEmpty()) {
				for(Recipe recipe:recipes) {
					RecipeDTO recipeDTO = RecipeDTO.valueOf(recipe);
					recipesDTOs.add(recipeDTO);
				}
				return recipesDTOs;
			}
			else
				throw new RecipeException("NO_RECIPES_EXIST");
		}	
	
		public RecipeDTO getSpecificRecipe(String recipeName) throws RecipeException{
			Recipe recipe=recipeRepository.findByRecipeName(recipeName);
			if(recipe!=null) {
				RecipeDTO object=RecipeDTO.valueOf(recipe);
				return object;
			}
			else
				throw new RecipeException("SPECIFIED_RECIPE_DOES_NOT_EXIST");
		}
}
