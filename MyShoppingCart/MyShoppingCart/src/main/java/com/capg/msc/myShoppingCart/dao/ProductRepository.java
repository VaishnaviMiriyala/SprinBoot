package com.capg.msc.myShoppingCart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.msc.myShoppingCart.beans.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>,CustomProductRepository
{

}
