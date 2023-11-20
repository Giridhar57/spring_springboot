package com.exercise.CookPick.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.CookPick.exceptions.ProductNotFoundException;
import com.exercise.CookPick.productDTO.ProductDTO;
import com.exercise.CookPick.service.ProductService;

@RestController
public class CookPickController {
	
	@Autowired
	private ProductService service;
	
	@RequestMapping("/greet")
	@GetMapping
	public String greet() {
		DayOfWeek d=LocalDate.now().getDayOfWeek();
		return "Welcome to "+d+" sale";
	}
	
	@PostMapping("/product")
	public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO prod) {
		service.addNewProduct(prod);
		return new ResponseEntity<ProductDTO>(prod,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/product/{productName}",produces="application/json")
	public ResponseEntity<List<ProductDTO>> getProducts(@PathVariable("productName") String productName){
		return ResponseEntity.status(HttpStatus.OK).body(service.getProductByproductName(productName));
	}
	
	@GetMapping("/product")
	public ResponseEntity<List<ProductDTO>> getProductByParams(@RequestParam("productName") String productName,@RequestParam("productVendor") String productVendor){
		return ResponseEntity.status(HttpStatus.OK).body(service.getProducyByNameAndVendor(productName, productVendor));
	}
	
	@GetMapping("/product/all")
	public ResponseEntity<List<ProductDTO>> getAllProducts(){
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllProducts());
	}
	
	@GetMapping(value="/product/{query}/")
	public ResponseEntity<List<ProductDTO>> getProductsByVendors(@MatrixVariable(pathVar="query") Map<String,List<String>> map){
		List<String> vendors=new ArrayList<>();
		if(map.containsKey("vendor")) {
			for(String s:map.get("vendor")) {
				vendors.add(s);
			}
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(service.getProductsByVendors(vendors));
	}
	@PutMapping(value="/product/{productId}",consumes="application/json",produces="application/json")
	public ResponseEntity<ProductDTO> updateProduct(@PathVariable("productId")int productId,@RequestBody ProductDTO product) throws ProductNotFoundException{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.updateProdcutPrice(productId,product));
	}
	
	@DeleteMapping("/product/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable int productId) {
		return ResponseEntity.status(HttpStatus.OK).body(service.deleteProduct(productId));
	}
}
