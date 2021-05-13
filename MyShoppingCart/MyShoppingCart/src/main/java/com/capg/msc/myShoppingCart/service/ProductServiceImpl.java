package com.capg.msc.myShoppingCart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.msc.myShoppingCart.beans.Product;
import com.capg.msc.myShoppingCart.dao.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository  repo;
	
	@Override
	@Transactional
	public Product saveProduct(Product product) {
		repo.save(product);
		return product;
	}
	@Override
	public List<Product> getAllProducts(){
		return repo.findAll();
	}
	@Override
	@Transactional
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		Product searchProduct = repo.findById(product.getProductId()).get();
		searchProduct.setProductName(product.getProductName());
		searchProduct.setProductCost(product.getProductCost());
		searchProduct.setStartRating(product.getStartRating());
		searchProduct.setCategory(product.getCategory());
		return saveProduct(searchProduct);
	}
	@Override
	public List<Product> deleteProductById(int id) {
		repo.deleteById(id);
		return repo.findAll();
	}
	
	@Override
	public List<Product> getAllProductsByCategory(String category) {
		
		return repo.getProductByCategory(category);
	}

	@Override
	public List<Product> getAllProductsByCategoryAndPrice(String category, int range1, int range2) {
		
		return repo.getProductByCategoryAndPrice(category, range1, range2);
	}
	
	@Override
	public Product getProductById(int id)  {
		return repo.findById(id).get();
		
	}

}
