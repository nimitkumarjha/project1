package com.OMS.ProductService.controller;



import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.OMS.ProductService.dto.subscribedproductDTO;
import com.OMS.ProductService.entity.subscribedproduct;
import com.OMS.ProductService.service.subscribedService;

@RestController
@EnableAutoConfiguration
@CrossOrigin
@RequestMapping("api/subscribedproduct")
public class subscribedproductController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	subscribedService subService;
	
	@Value("${buyerAPIURL}")
	public String buyerAPIURL;
	
	@Value("${cartAPIURL}")
	public String cartAPIURL;
	
	
	@Autowired
	public RestTemplate restTemplate;
	
	//fetch all details from subscribedproduct (Wishlist of the buyer)
	 @GetMapping(value="/{buyerId}",produces = MediaType.APPLICATION_JSON_VALUE)
	    public Object getSubscription(@PathVariable Integer buyerId) {
	    	System.out.println(buyerId);
	        logger.info("Retrive Wishlist For buyer " + buyerId);

	        List<subscribedproduct> subscriptions = (List<subscribedproduct>) subService.getSubscriptions(buyerId);

	        if (subscriptions.size() == 0) {
	            System.out.println("No product in wishlist");
	        }

	        return subscriptions;
	    }
	 	//Add product in Wishlist
	    @PostMapping(value="/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public void addSubscription(@Valid @RequestBody subscribedproductDTO subscription) {
	        logger.info("Add products For buyer in wishlist " + subscription.getBuyerid());
	        
	        ResponseEntity<Boolean> responseEntity = restTemplate.getForEntity(buyerAPIURL + subscription.getBuyerid(), Boolean.class);

	        if (responseEntity.getBody() != null && responseEntity.getBody()) {
	            subService.saveSubscription(subscription.createEntity());
	            System.out.println( "Added the product to buyer's wishlist ");	            
	        }
	        
	       
	    }
	    
	    //Remove product from Wishlist
	    @DeleteMapping(value="/remove",produces = MediaType.APPLICATION_JSON_VALUE)
	    public void removeSubscription(@Valid @RequestBody subscribedproductDTO subscription) {
	        subService.deleteSubscription(subscription.createEntity());

	        if (subService.getSubscriptionById(subscription.getSubid()) == null) {
	            logger.info("Removing Product from buyer's Wishlist " + subscription.getBuyerid());
	            System.out.println("product removed from wishlist");
	            
	        }
	        
	    }
	    
	    //Moving product from Wishlist to cart
	    @PutMapping(value="/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public void MoveToCart(@Valid @RequestBody subscribedproductDTO subscription) {
	    	
	    	subscribedproduct prod=subscription.createEntity();
	    	subService.deleteSubscription(prod);

	        if (subService.getSubscriptionById(subscription.getSubid()) == null) {
	            logger.info("Removing Product from buyer's Wishlist " + subscription.getBuyerid());	            
	        }
	    	
	   
	    }
		
	}

