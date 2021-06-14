package com.infosys.infyshop.product.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.infyshop.product.entity.Recipe;
import com.infosys.infyshop.product.exception.RecipeException;
import com.infosys.infyshop.product.repository.RecipeRepository;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	RecipeRepository recipeRepository;
	
	//delete a recipe
	public String deleteRecipe(String recipeName) throws RecipeException
	{
		Recipe recipe=recipeRepository.findByRecipeName(recipeName);
		if(recipe!=null) {
			Recipe recipe1 = recipe;
			recipeRepository.delete(recipe1);
			return "Recipe deleted succefully";
		}else {
			throw new RecipeException("RECIPE_DOES_NOT_EXIST");
		}
	}	


}
