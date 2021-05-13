package com.capg.msc.myShoppingCart.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "Product Bean")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	
	@ApiModelProperty(name = "ProductName",value = "Hold the min 3 char product name",required = true)
	@NotNull(message = "Product name cannot be null")
	@Size(min = 3,max = 20,message = "Invalid product name")
	private String productName;
	
	//@Min(value = 1000,message = "Cost cannot be less than 1000")
	@ApiModelProperty(name = "Product cost",value = "Holds Product cost min cost 1000 allowed")
	private int productCost;
	
	@ApiModelProperty(name = "Product starRating",value = "Holds Product Star Rating where maximun rating allowed is 5")
	@Max(value = 5 ,message = "Rating cannot exceed 5")
	private int startRating;
	
	@ApiModelProperty(name = "Product Category",value = "Holds Product is of which category and should not be empty")
	@NotEmpty(message = "Category should have some name")
	private String category;
	
	
	public Product() {
		super();
	}
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCost() {
		return productCost;
	}
	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}
	public int getStartRating() {
		return startRating;
	}
	public void setStartRating(int startRating) {
		this.startRating = startRating;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ ", startRating=" + startRating + ", category=" + category + "]";
	}
	
	

}
