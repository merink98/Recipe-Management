package com.infosys.infyshop.product;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.infosys.infyshop.product.dto.RecipeDTO;
import com.infosys.infyshop.product.entity.Recipe;
import com.infosys.infyshop.product.exception.RecipeException;
import com.infosys.infyshop.product.repository.RecipeRepository;
import com.infosys.infyshop.product.service.RecipeService;
import com.infosys.infyshop.product.service.RecipeServiceImpl;

@SpringBootTest
public class GetRecipeApplicationTest {

	@Mock
	RecipeRepository recipeRepository;
	
	@InjectMocks
	RecipeService recipeService=new RecipeServiceImpl();
	
	@Test
	public void getAllRecipesValidTest() throws RecipeException{
		Recipe recipe=new Recipe();
		recipe.setRecipeName("Banana chocolate");
		recipe.setType("vegetarian");
		recipe.setNoOfPeople(2);
		recipe.setIngredients("whipped cream, chocolate syrup");
		recipe.setInstructions("Top it off with whipped cream and chocolate syrup.");
		List<Recipe> list=new ArrayList<>();
		list.add(recipe);
		RecipeDTO dto=new RecipeDTO();
		dto.setRecipeName("Banana chocolate");
		dto.setType("vegetarian");
		dto.setNoOfPeople(2);
		dto.setIngredients("whipped cream, chocolate syrup");
		dto.setInstructions("Top it off with whipped cream and chocolate syrup.");
		List<RecipeDTO> list1=new ArrayList<>();
		list1.add(dto);
		Mockito.when(recipeRepository.findAll()).thenReturn(list);
		Assertions.assertEquals(list1, recipeService.getAllRecipes());
	}
	
	@Test
	public void getAllRecipesInvalidTest() throws RecipeException{
		List<Recipe> recipe=new ArrayList<>();
		Mockito.when(recipeRepository.findAll()).thenReturn(recipe);
		RecipeException exception=Assertions.assertThrows(RecipeException.class, ()->recipeService.getAllRecipes());
		Assertions.assertEquals("NO_RECIPES_EXIST", exception.getMessage());
	}
	
	@Test
	public void getSpecificRecipeValidTest() throws RecipeException{
		RecipeDTO dto=new RecipeDTO();
		dto.setRecipeName("Banana chocolate");
		dto.setType("vegetarian");
		dto.setNoOfPeople(2);
		dto.setIngredients("whipped cream, chocolate syrup");
		dto.setInstructions("Top it off with whipped cream and chocolate syrup.");
		Recipe recipe=new Recipe();
		recipe.setRecipeName("Banana chocolate");
		recipe.setType("vegetarian");
		recipe.setNoOfPeople(2);
		recipe.setIngredients("whipped cream, chocolate syrup");
		recipe.setInstructions("Top it off with whipped cream and chocolate syrup.");
		List<Recipe> list=new ArrayList<>();
		list.add(recipe);
		Mockito.when(recipeRepository.findByRecipeName(Mockito.anyString())).thenReturn(recipe);
		Assertions.assertEquals(dto, recipeService.getSpecificRecipe("Banana chocolate"));
	}
	
	@Test
	public void getSpecificRecipeInvalidTest() throws RecipeException{
		Mockito.when(recipeRepository.findByRecipeName(Mockito.anyString())).thenReturn(null);
		RecipeException exception=Assertions.assertThrows(RecipeException.class, ()->recipeService.getSpecificRecipe("@efhe23fd$!^"));
		Assertions.assertEquals("SPECIFIED_RECIPE_DOES_NOT_EXIST", exception.getMessage());
	}
	
	
}
