package com.infosys.infyshop.product.service;

import com.infosys.infyshop.product.exception.RecipeException;

public interface RecipeService {
	String deleteRecipe(String recipeName) throws RecipeException;
}
