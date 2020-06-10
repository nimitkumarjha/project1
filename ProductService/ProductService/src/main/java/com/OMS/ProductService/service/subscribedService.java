package com.OMS.ProductService.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OMS.ProductService.entity.subscribedproduct;
import com.OMS.ProductService.repository.subscribedproductRespository;

@Service("subscribedService")
public class subscribedService {

	@Autowired
	private subscribedproductRespository subRepo;

	public subscribedproduct getSubscriptionById(Integer subid) {
		return subRepo.findById(subid).orElse(null);
	}

	public subscribedproduct saveSubscription(subscribedproduct subscription) {
		return subRepo.save(subscription);
	}

	public Iterable<subscribedproduct> getSubscriptions(Integer buyerid) {
		return subRepo.findByBuyerid(buyerid);
	}

	public void deleteSubscription(subscribedproduct subscription) {
		subRepo.delete(subscription);
	}

	

	
}	
	

	


