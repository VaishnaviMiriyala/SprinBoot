package com.capg.Basics.springBootDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class ProductDaoImpl {

	
	List<Product> list = new ArrayList<>();

	public ProductDaoImpl() {
		
		Product p1 = new Product(101, "HP-101",45000,5,20);
		Product p2 = new Product(102, "HP-102",15000,4,25);
		Product p3 = new Product(103, "HP-103",25000,3,10);
		Product p4 = new Product(104, "HP-104",20000,5,5);
		Product p5 = new Product(105, "HP-105",145000,2,13);
		
		list = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5));

	}
	
	public List<Product> getAllProducts()
	{
		return list;
	}
	
	public List<Product> getProductsByRange(int r1,int r2)
	{
		
		List<Product> productList = list.stream().
		filter((product)->product.getProductCost()>=r1&&product.getProductCost()<=r2).
		collect(Collectors.toList());
		
		return productList;
	}
	
	public Product getProductById(int searchid)
	{
		boolean isIdFound = false;
		Product searchedProduct = null;
		for (Product product : list) {
			if(product.getProductId() == searchid)
			{
				isIdFound = true;
				searchedProduct = product;
				break;
			}
		}
		return searchedProduct;
	}
	
	public List<Product> getProductByStarRatings(int rating){
		List<Product> tempList = new ArrayList<>();
		for(Product product: list) {
			if(product.getStarRating() == rating) {
				tempList.add(product);
			}
		}
		return tempList;
	}
	public List<Product> getProductByReviews(int review){
		List<Product> tempList = new ArrayList<>();
		for(Product product: list) {
			if(product.getReviewCount() >= review) {
				tempList.add(product);
			}
		}
		return tempList;
	}
	
	/*public List<Product> deleteProductById(int id) {
		Product p = null;
		for(Product product: list) {
			if(product.getProductId() == id) {
				p = product;
			}
		}
		list.remove(p);
		return list;
		
		
	}*/
	
	public Product doDeleteById(int searchedId)
	{
		Product p = getProductById(searchedId);
		boolean x = false;
		if(p != null)
		{
			System.out.println(" ===> DAO List Size before delete "+list.size()+" and p "+p);
			x = list.remove(p);
			System.out.println(" ===> DAO List Size after delete "+list.size());
			System.out.println(" ===>> DAO Delete operation "+x);
		}
		
		if(x) return p;
		else return null;
	}
	
	public boolean doInsert(Product product) {
		
		return list.add(product);
		
	}
    public Product doUpdate(Product product,int productId) {
         Product p = getProductById(productId);
    		if(p != null) {
    			p.setProductId(product.getProductId());
    			p.setProductName(product.getProductName());
    			p.setProductCost(product.getProductCost());
    			p.setStarRating(product.getStarRating());
    			p.setReviewCount(product.getReviewCount());
    		}
    		return p;
    }
	
}
