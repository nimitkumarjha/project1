package com.OMS.ProductService.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.OMS.ProductService.dto.StockDTO;
import com.OMS.ProductService.dto.productDTO;
import com.OMS.ProductService.entity.product;
import com.OMS.ProductService.repository.productRepository;

@Service("productService")
public class productService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	productRepository prorepo;
	
	
	
	//fetch all product details
	public List<productDTO> getallproducts() {
		List<product> products = prorepo.findAll();
		List<productDTO> productDTOs = new ArrayList<>();

		for (product p : products) {
			productDTO pDTO = productDTO.valueOf(p);
			productDTOs.add(pDTO);
		}

		logger.info("Product details : {}", productDTOs);
		return productDTOs;
	}
	
	//Search product based on category 	
	public List<productDTO> getSpecificproducts(String category){
		
//		Query query =product.createQuery("select c from product c where c.category=:category");
//		query.setParameter("category", category);
//		List<product> products=query.getResultList();
		List<product> products=prorepo.getByCategory(category);
		List<productDTO> listOfproducts=new ArrayList<>();		
		for(product p: products) {
			productDTO pDTO =productDTO.valueOf(p);
			listOfproducts.add(pDTO);			
		  }

		logger.info("Product details with specified category : {}", listOfproducts);
		return listOfproducts;
			
	}
	
	//Addition of new product
	public void newproduct(productDTO prodDTO) {
		logger.info("Creation request for new product {}", prodDTO);
		//System.out.println("=========Addition of newproduct- I am in Service=========");
		product prod = prodDTO.createEntity();	
		//System.out.println("=========Addition of newproduct- I have returned to Service with Created Entity=========");
		logger.info("Created Entity of new product {}",prod);
		prorepo.save(prod);
		//System.out.println("=========Addition of newproduct- I have saved Entity in Repo through  Service=========");
	}
	  
	//Updation of stock in existing product
	public void updateproduct(Integer prodid,StockDTO stockcontrol) {
		
		logger.info("updation request for existing product with prodid {}:",prodid);
		//System.out.println("=========Updating existing product- I am in Service=========");
		Optional<product> optpro = prorepo.findById(prodid);
		//System.out.println(optpro);
		if (optpro.isPresent()) {
			product prod=optpro.get();			
			logger.info("Creation request for new product {}", prod);
			prod.setSellerid(stockcontrol.getSellerid());
			//System.out.println(prod.getSellerid());
			prod.setStock(prod.getStock()+stockcontrol.getStock());	
			//System.out.println(prod.getStock());
			prorepo.save(prod);
			//System.out.println("=========Updated existing product successfully- I am in Service=========");
			
		}
		
		//Addition of product to wishlist
		
		
		
		
		
	}
	
	
	
	

	
}
