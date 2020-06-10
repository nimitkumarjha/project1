package com.OMS.ProductService.controller;



//import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

//import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OMS.ProductService.dto.StockDTO;
import com.OMS.ProductService.dto.productDTO;
//import com.OMS.ProductService.entity.product;

import com.OMS.ProductService.service.productService;

@RestController
@EnableAutoConfiguration
@CrossOrigin
@RequestMapping("api/")
public class ProductController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	productService proService;
	
	// Fetches all product details
	@GetMapping(value = "/product",  produces = MediaType.APPLICATION_JSON_VALUE)
	public List<productDTO> getallproduct() {
		return proService.getallproducts();
	}

	//Search product based on category 	
	@GetMapping(value ="/product/category/{category}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<productDTO> getproduct(@PathVariable("category") String category){
		List<productDTO> specificproducts=null;
		specificproducts=proService.getSpecificproducts(category);
		return specificproducts;
	}

	//Addition of new Product
	@PostMapping(value = "/product",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public void newproduct(@RequestBody productDTO prodDTO) {
		logger.info("Creation request for new product {}", prodDTO);
		//System.out.println("=========Addition of newproduct- I am in Controller=========");
		proService.newproduct(prodDTO);
	}
	
	//Updation of stock in existing product
	@PutMapping(value = "/product/{prodid}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateproduct(@PathVariable("prodid") Integer prodid,@Valid @RequestBody StockDTO stockcontrol ) {
		
		logger.info("Creation request for updation of existing product {}",stockcontrol);
		//System.out.println("=========updating existing product- I am in Controller=========");
		proService.updateproduct(prodid, stockcontrol);
		return "Pass controller";
		
		
	}
	//
	

	
}
