package com.infosys.infyshop.product;

import java.util.ArrayList;
import java.util.List;

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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class CreateRecipeApplicationTests {

	@Mock
	RecipeRepository recipeRepository;
	
	@InjectMocks
	RecipeService recipeService=new RecipeServiceImpl();

	@Test
	public void createRecipeValidTest() throws RecipeException{
		RecipeDTO recipe=new RecipeDTO();
		recipe.setRecipeName("Banana chocolate");
		recipe.setType("vegetarian");
		recipe.setNoOfPeople(2);
		recipe.setIngredients("whipped cream, chocolate syrup");
		recipe.setInstructions("Top it off with whipped cream and chocolate syrup.");
		List<Recipe> list=new ArrayList<Recipe>();
		Mockito.when(recipeRepository.findByRecipeName("Banana chocolate")).thenReturn(list);
		String actual=recipeService.createRecipe(recipe);
		Assertions.assertEquals("Recipe created successfully", actual);
	}
	
	@Test
	public void createRecipeAlreadyExistsTest() throws RecipeException{
		Recipe recipe=new Recipe();
		recipe.setRecipeName("Banana chocolate");				
		recipe.setIngredients("sjhdsndf fns 1, ddg");
		recipe.setInstructions("ajkdnsf 1, 35 dsfndf");
		recipe.setNoOfPeople(4);
		List<Recipe> list=new ArrayList<>();
		list.add(recipe);
		RecipeDTO dto=new RecipeDTO();
		dto.setRecipeName("Banana chocolate");
		Mockito.when(recipeRepository.findByRecipeName(Mockito.anyString())).thenReturn(list);
		RecipeException e=Assertions.assertThrows(RecipeException.class, ()->recipeService.createRecipe(dto));
		Assertions.assertEquals("RECIPE_ALREADY_EXISTS", e.getMessage());
	}
	
}