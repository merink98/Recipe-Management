package com.infosys.infyshop.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.infyshop.product.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, String>{

	Recipe findByRecipeName(String recipeName);
}
