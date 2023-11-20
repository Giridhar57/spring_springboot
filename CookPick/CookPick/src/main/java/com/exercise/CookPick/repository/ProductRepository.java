package com.exercise.CookPick.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exercise.CookPick.product.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
	public List<Product> getProductByproductName(String productName);
	
	@Query("select p from Product p where p.productName=?1 and p.productVendor=?2")
	public List<Product> getProductByproductNameAndproductVendor(String productName,String productVendor);
	
	@Query("select p from Product p where p.productVendor in (?1)")
	public List<Product> getProductByVendorNames(List<String> vendors);
	
}
