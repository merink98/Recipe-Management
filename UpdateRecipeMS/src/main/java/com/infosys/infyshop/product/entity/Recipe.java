package com.infosys.infyshop.product.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recipe")
public class Recipe {

	@Id
	@Column(name = "recipename", nullable = false)
	String recipeName;
	@Column(name = "dateandtime", nullable = false)
	LocalDateTime dateAndTime=LocalDateTime.now();
	@Column(name = "type",nullable = false)
	String type;
	@Column(name = "noofpeople",nullable = false)
	Integer noOfPeople;
	@Column(name = "ingredients",nullable = false)
	String ingredients;
	@Column(name = "instructions",nullable = false)
	String instructions;
	
	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public void setDateAndTime(LocalDateTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public LocalDateTime getDateAndTime() {
		return dateAndTime;
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
	
	
}
