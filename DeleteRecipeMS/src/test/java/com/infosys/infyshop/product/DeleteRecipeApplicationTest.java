package com.infosys.infyshop.product;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.infosys.infyshop.product.entity.Recipe;
import com.infosys.infyshop.product.exception.RecipeException;
import com.infosys.infyshop.product.repository.RecipeRepository;
import com.infosys.infyshop.product.service.RecipeService;
import com.infosys.infyshop.product.service.RecipeServiceImpl;

@SpringBootTest
public class DeleteRecipeApplicationTest {

	@Mock
	RecipeRepository recipeRepository;
	
	@InjectMocks
	RecipeService recipeService=new RecipeServiceImpl();
	
	@Test
	public void deleteRecipeValidTest() throws RecipeException{
		
		Recipe recipe=new Recipe();
		recipe.setRecipeName("Banana chocolate");
		recipe.setType("vegetarian");
		recipe.setNoOfPeople(2);
		recipe.setIngredients("whipped cream, chocolate syrup");
		recipe.setInstructions("Top it off with whipped cream and chocolate syrup.");
		Mockito.when(recipeRepository.findByRecipeName(Mockito.anyString())).thenReturn(recipe);
		Assertions.assertEquals("Recipe deleted succefully", recipeService.deleteRecipe("Banana chocolate"));
	}
	
	@Test
	public void deleteRecipeInvalidTest() throws RecipeException{
		Mockito.when(recipeRepository.findByRecipeName(Mockito.anyString())).thenReturn(null);
		RecipeException exception=Assertions.assertThrows(RecipeException.class, ()->recipeService.deleteRecipe(Mockito.anyString()));
		Assertions.assertEquals("RECIPE_DOES_NOT_EXIST", exception.getMessage());
	}
	
	
}
