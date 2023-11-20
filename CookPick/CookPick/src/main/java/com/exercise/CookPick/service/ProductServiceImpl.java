package com.exercise.CookPick.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.CookPick.exceptions.ProductNotFoundException;
import com.exercise.CookPick.product.Product;
import com.exercise.CookPick.productDTO.ProductDTO;
import com.exercise.CookPick.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository repository;

	@Override
	public void addNewProduct(ProductDTO product) {
		repository.saveAndFlush(ProductDTO.createProduct(product));
		
	}

	@Override
	public void getProductById(int productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductDTO> getProductByproductName(String productName) {
		Iterable<Product> matches=repository.getProductByproductName(productName);
		List<ProductDTO> res=new ArrayList<>();
		for(Product p:matches) {
			res.add(Product.createProductDTO(p));
		}
		return res;
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		Iterable<Product> all=repository.findAll();
		List<ProductDTO> res=new ArrayList<>();
		for(Product p:all) {
			res.add(Product.createProductDTO(p));
		}
		return res;
	}

	@Override
	public List<ProductDTO> getProducyByNameAndVendor(String productName, String productVendor) {
		Iterable<Product> all=repository.getProductByproductNameAndproductVendor(productName, productVendor);
		List<ProductDTO> res=new ArrayList<>();
		for(Product p:all) {
			res.add(Product.createProductDTO(p));
		}
		return res;
	}

	@Override
	public List<ProductDTO> getProductsByVendors(List<String> vendors) {
		Iterable<Product> all=repository.getProductByVendorNames(vendors);
		List<ProductDTO> res=new ArrayList<>();
		for(Product p:all) {
			res.add(Product.createProductDTO(p));
		}
		return res;
	}


	@Override
	public String deleteProduct(int productId) {
		Optional<Product> item=repository.findById(productId);
		if(item.isEmpty()) {
			return "Invalid Product-Id for deletion/product not found";
		}
		repository.delete(item.get());
		return "Product Deleted";
	}

	@Override
	public ProductDTO updateProdcutPrice(int productId, ProductDTO product) throws ProductNotFoundException {
		Optional<Product> original=repository.findById(productId);
		Product p=null;
		if(original.isPresent()) {
			p=original.get();
			p.setProductPrice(product.getProductPrice());
			repository.save(p);
		}else {
			throw new ProductNotFoundException("jhvbhj");
		}
		return Product.createProductDTO(p);
	}
	
	
}
