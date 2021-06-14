package com.infosys.infyshop.product.service;

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

	//update a recipe
	public String updateRecipe(RecipeDTO updateRecipeDTO) throws RecipeException{
		
		Recipe nameEntity = recipeRepository.findByRecipeName(updateRecipeDTO.getRecipeName());
			
			if(nameEntity!=null)
			{
				nameEntity.setRecipeName(updateRecipeDTO.getRecipeName());
				nameEntity.setDateAndTime(updateRecipeDTO.getDateAndTime());
				nameEntity.setType(updateRecipeDTO.getType());
				nameEntity.setNoOfPeople(updateRecipeDTO.getNoOfPeople());
				nameEntity.setIngredients(updateRecipeDTO.getIngredients());
				nameEntity.setInstructions(updateRecipeDTO.getInstructions());
				recipeRepository.save(nameEntity);
				return "Recipe updated successfully";
			}
			else {
				throw new RecipeException("INVALID_RECIPE_DETAILS");
			}

		}	
}
