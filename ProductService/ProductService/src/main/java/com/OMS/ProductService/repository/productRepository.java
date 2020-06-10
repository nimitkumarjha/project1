package com.OMS.ProductService.repository;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.OMS.ProductService.entity.product;


public interface productRepository extends JpaRepository<product, Integer> {

	List<product> getByCategory(String category);
	
	
		

   

}
