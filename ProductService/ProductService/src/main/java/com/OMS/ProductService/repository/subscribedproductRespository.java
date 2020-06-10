package com.OMS.ProductService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OMS.ProductService.entity.*;

public interface subscribedproductRespository extends JpaRepository<subscribedproduct, Integer>{

	Iterable<subscribedproduct> findByBuyerid(Integer buyerid);

}
