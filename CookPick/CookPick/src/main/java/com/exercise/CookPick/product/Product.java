package com.exercise.CookPick.product;

import com.exercise.CookPick.productDTO.ProductDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	private int productId;
	private String productName;
	private String productVendor;
	private double productPrice;
	private boolean productInStock;
	
	public Product() {}
	
	public Product(int productId,String productName,String productVendor,double productPrice,boolean productInStock) {
		this.productId=productId;
		this.productName=productName;
		this.productVendor=productVendor;
		this.productPrice=productPrice;
		this.productInStock=productInStock;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductVendor() {
		return productVendor;
	}
	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public boolean isProductInStock() {
		return productInStock;
	}
	public void setProductInStock(boolean productInStock) {
		this.productInStock = productInStock;
	}
	
	public String toString() {
		return productName+"("+productId+") by "+productVendor+" costs Rs."+productPrice;
	}
	
	public static ProductDTO createProductDTO(Product p) {
		ProductDTO product=new ProductDTO();
		product.setProductId(p.getProductId());
		product.setProductName(p.getProductName());
		product.setProductVendor(p.getProductVendor());
		product.setProductPrice(p.getProductPrice());
		product.setProductInStock(p.isProductInStock());
		return product;
	}
}
