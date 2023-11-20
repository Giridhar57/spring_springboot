package com.exercise.CookPick.service;

import java.util.List;

import com.exercise.CookPick.exceptions.ProductNotFoundException;
import com.exercise.CookPick.productDTO.ProductDTO;

public interface ProductService {
	public void addNewProduct(ProductDTO product);
	public void getProductById(int productId);
	public List<ProductDTO> getProductByproductName(String productName);
	public List<ProductDTO> getAllProducts();
	public List<ProductDTO> getProducyByNameAndVendor(String productName,String productVendor);
	public List<ProductDTO> getProductsByVendors(List<String> vendors);
	public ProductDTO updateProdcutPrice(int productId,ProductDTO product) throws ProductNotFoundException;
	public String deleteProduct(int productId);
}
