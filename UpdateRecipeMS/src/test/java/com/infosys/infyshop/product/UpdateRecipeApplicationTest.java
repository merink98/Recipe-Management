package com.infosys.infyshop.product;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
public class UpdateRecipeApplicationTest {

	@Mock
	RecipeRepository recipeRepository;
	
	@InjectMocks
	RecipeService recipeService=new RecipeServiceImpl();
	
	@Test
	public void updateRecipeValidTest() throws RecipeException {
		Recipe entity=new Recipe();
		entity.setRecipeName("Omelette");
		entity.setType("non vegetarian");
		entity.setNoOfPeople(1);
		entity.setIngredients("salt,1 egg, oil");
		entity.setInstructions("Beat 1 egg and salt and pour over hot oil pan");
		List<RecipeDTO> dtolist = new ArrayList<RecipeDTO>();
		RecipeDTO dto=new RecipeDTO();
		dto.setRecipeName("Omelette");
		dto.setType("non vegetarian");
		dto.setNoOfPeople(2);
		dto.setIngredients("salt,1 egg, oil");
		dto.setInstructions("Beat 1 egg and salt and pour over hot oil pan");
		dtolist.add(dto);
		Mockito.when(recipeRepository.findByRecipeName(Mockito.anyString())).thenReturn(entity);
		String actual = recipeService.updateRecipe(dto);
		Assertions.assertEquals("Recipe updated successfully",actual);
	}
	
	@Test
	public void updateRecipeInvalidTest() throws RecipeException{
		RecipeDTO dto=new RecipeDTO();
		dto.setRecipeName("Omelette");
		dto.setType("non vegetarian");
		dto.setNoOfPeople(2);
		dto.setIngredients("salt,1 egg, oil");
		dto.setInstructions("Beat 1 egg and salt and pour over hot oil pan");
		Mockito.when(recipeRepository.findByRecipeName(Mockito.anyString())).thenReturn(null);
		RecipeException e=Assertions.assertThrows(RecipeException.class, ()->recipeService.updateRecipe(dto));
		Assertions.assertEquals("INVALID_RECIPE_DETAILS", e.getMessage());
	}
	
}
