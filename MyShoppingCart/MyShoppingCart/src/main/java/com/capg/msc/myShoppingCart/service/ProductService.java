package com.capg.msc.myShoppingCart.service;

import java.util.List;

import com.capg.msc.myShoppingCart.beans.Product;

public interface ProductService {
	public List<Product> getAllProducts();
	public Product saveProduct(Product product);
	public Product updateProduct(Product product);
    public List<Product> deleteProductById(int id);
    public List<Product> getAllProductsByCategory(String category);
	public List<Product> getAllProductsByCategoryAndPrice(String category,int range1,int range2);
	public Product getProductById(int id);
}
