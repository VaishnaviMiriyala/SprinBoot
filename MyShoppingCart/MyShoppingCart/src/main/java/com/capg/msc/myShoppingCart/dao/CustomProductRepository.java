package com.capg.msc.myShoppingCart.dao;

import java.util.List;

import com.capg.msc.myShoppingCart.beans.Product;

public interface CustomProductRepository {

	public List<Product> getProductByCategory(String proudctCategory);
	public List<Product> getProductByCategoryAndPrice(String proudctCategory,int range1,int range2);
	
}
