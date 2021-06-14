package com.infosys.infyshop.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.infyshop.product.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, String>{

	List<Recipe> findByRecipeName(String recipeName);

}
