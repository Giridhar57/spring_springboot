package com.exercise.CookPick.productDTO;

import com.exercise.CookPick.product.Product;
import com.fasterxml.jackson.annotation.JsonFilter;


public class ProductDTO {
	private int productId;
	private String productName;
	private String productVendor;
	private double productPrice;
	private boolean productInStock;
	
	public ProductDTO() {}
	
	public ProductDTO(int productId,String productName,String productVendor,double productPrice,boolean productInStock) {
		super();
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
	
	public static Product createProduct(ProductDTO p) {
		Product product=new Product();
		product.setProductId(p.getProductId());
		product.setProductName(p.getProductName());
		product.setProductVendor(p.getProductVendor());
		product.setProductPrice(p.getProductPrice());
		product.setProductInStock(p.isProductInStock());
		return product;
	}
}
