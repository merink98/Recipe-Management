package com.infosys.infyshop.product.dto;

import java.time.LocalDateTime;

import com.infosys.infyshop.product.entity.Recipe;

public class RecipeDTO {

	String recipeName;
	LocalDateTime dateAndTime=LocalDateTime.now();
	String type;
	Integer noOfPeople;
	String ingredients;
	String instructions;
	
	public RecipeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(LocalDateTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNoOfPeople() {
		return noOfPeople;
	}

	public void setNoOfPeople(Integer noOfPeople) {
		this.noOfPeople = noOfPeople;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	// Converts Entity into DTO
	public static RecipeDTO valueOf(Recipe recipe) {
		RecipeDTO dto = new RecipeDTO();
		dto.setRecipeName(recipe.getRecipeName());
		dto.setDateAndTime(recipe.getDateAndTime());
		dto.setType(recipe.getType());
		dto.setNoOfPeople(recipe.getNoOfPeople());
		dto.setIngredients(recipe.getIngredients());
		dto.setInstructions(recipe.getInstructions());
		return dto;
	}	

	//creating entity from dto
	public Recipe createEntity() {
		Recipe entity=new Recipe();
		entity.setRecipeName(this.getRecipeName());
		entity.setDateAndTime(this.getDateAndTime());
		entity.setType(this.getType());
		entity.setNoOfPeople(this.getNoOfPeople());
		entity.setIngredients(this.getIngredients());
		entity.setInstructions(this.getInstructions());
		return entity;
	}
	
	@Override
	public int hashCode() {
		return 1+recipeName.hashCode();
	}

	@Override
	public boolean equals(Object recipe) {
		RecipeDTO otherRecipe=(RecipeDTO) recipe;
		if(this.recipeName.equals(otherRecipe.recipeName))
			return true;
		return false;
	} 
	
	@Override
	public String toString() {
		return "GetRecipeDTO [recipeName=" + recipeName + ", dateAndTimeOfCreation=" + dateAndTime + 
				", type=" + type + ", noOfPeopleSuitableFor=" + noOfPeople + ", ingredients="+ ingredients + 
				", instructions=" + instructions + "]";
	}
}
