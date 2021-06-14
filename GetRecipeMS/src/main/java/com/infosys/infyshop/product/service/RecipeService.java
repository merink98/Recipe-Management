package com.infosys.infyshop.product.service;

import java.util.List;

import com.infosys.infyshop.product.dto.RecipeDTO;
import com.infosys.infyshop.product.exception.RecipeException;

public interface RecipeService {
	List<RecipeDTO> getAllRecipes() throws RecipeException;
	RecipeDTO getSpecificRecipe(String recipeName) throws RecipeException;
}
