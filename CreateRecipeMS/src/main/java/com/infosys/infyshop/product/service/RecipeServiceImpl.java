package com.infosys.infyshop.product.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infosys.infyshop.product.dto.RecipeDTO;
import com.infosys.infyshop.product.entity.Recipe;
import com.infosys.infyshop.product.exception.RecipeException;
import com.infosys.infyshop.product.repository.RecipeRepository;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	RecipeRepository getRecipeRepository;
	
	@Autowired
	Environment environment;

	//create a recipe
	public String createRecipe(RecipeDTO createRecipeDTO) throws RecipeException	{

		List<Recipe> list = getRecipeRepository.findByRecipeName(createRecipeDTO.getRecipeName());
		if(list.isEmpty()) {
			Recipe createNew = createRecipeDTO.createEntity();
			getRecipeRepository.save(createNew);
			return "Recipe created successfully";
		}

		else {
			throw new RecipeException("RECIPE_ALREADY_EXISTS");

		}
	}
	
	
//	return "Recipe already exists";
	
//	throw new RecipeException(environment.getProperty("RecipeService.RECIPE_ALREADY_EXISTS"));

}
