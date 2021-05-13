package com.capg.Basics.springBootDemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	
	@Autowired
	ProductDaoImpl dao;
	 
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello";
	}
	
	@GetMapping("/product/{r1}/{r2}")
	public List<Product> getProductsbyrange(@PathVariable int r1 ,@PathVariable int r2)
	{
		return dao.getProductsByRange(r1, r2);
	}
	
	// ..../product/101
	@GetMapping("/product/{searchid}")
	public Product getProductByid(@PathVariable int searchid)
	{
		return dao.getProductById(searchid);
	}
	
	@GetMapping("/product/getdetailsbyRating/{rating}")
	public List<Product> getProductByStarRatings(@PathVariable int rating)
	{
		return dao.getProductByStarRatings(rating);
	}
	@GetMapping("/product/getdetailsByReview/{reviewCount}")
	public List<Product> getProductByReviews(@PathVariable int reviewCount)
	{
		return dao.getProductByReviews(reviewCount);
	}
	
	@GetMapping("/product/delete/{id}")
	/*public List<Product> deleteProductById(@PathVariable int id)
	{
		return dao.deleteProductById(id);
	}*/
	public Product doDeleteById(@PathVariable int id)
	{
		return dao.doDeleteById(id);
	}
	
	@PostMapping("/product")
	public Product insertProduct(@RequestBody Product product) {
		if(dao.doInsert(product)) {
			return product;
		}
		else return null;
	}
	
	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product product) {
		
		return dao.doUpdate(product,product.getProductId());
	}
}
