package com.capg.msc.myShoppingCart.web;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.msc.myShoppingCart.beans.Product;
import com.capg.msc.myShoppingCart.exception.InvalidCategoryException;
import com.capg.msc.myShoppingCart.exception.InvalidCostException;
import com.capg.msc.myShoppingCart.exception.InvalidCostRangeException;
import com.capg.msc.myShoppingCart.service.ProductService;

import io.swagger.annotations.Api;

@Validated
@RestController
@RequestMapping("/api")
@Api(value = "Online Laptop Store",description = "Various api works on laptop inventory management")
public class ProductRestController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome To My Shopping Cart";
	}
	
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable int id)
	{
		return service.getProductById(id);
		
	}
	
	@PostMapping("/product")
	public Product insertProduct(@RequestBody @Valid Product product) throws InvalidCostException{
		if(product.getProductCost() < 10000) {
			throw new InvalidCostException(product.getProductCost()); 
		}
		service.saveProduct(product);
		return product;
	}
	
	@GetMapping("/product")
	public List<Product> getAllProducts(){
		return service.getAllProducts();
	}
	
	@PutMapping("/product")
	public Product doUpdate(@RequestBody Product product) {
		return service.updateProduct(product);
	}
    @GetMapping("/product/delete/{id}")
    public List<Product> doDelete(@PathVariable int id) {
    	List<Product> list = service.deleteProductById(id);
    	return list;
    }
    @GetMapping("/products/{category}")
	public List<Product> getAllProductsByCategory(@PathVariable String category)throws InvalidCategoryException
	{
    	Matcher m = Pattern.compile("[0-9]|@|[\\+-x\\*]").matcher(category);
    	if(category.length() < 3 || m.find()) {
    		throw new InvalidCategoryException(category);
    	}
		return service.getAllProductsByCategory(category);
	}
	
	@GetMapping("/products/{category}/{range1}/{range2}")
	public List<Product> getAllProductsByCategoryAndPrice(@PathVariable String category,
			@PathVariable int range1,@PathVariable int range2) throws InvalidCostRangeException
	{
		if(category.equals("Laptop")&&range1<10000)
		{
			throw new InvalidCostRangeException(range1,range2);
		}
		return service.getAllProductsByCategoryAndPrice(category, range1, range2);
	}
    
}
