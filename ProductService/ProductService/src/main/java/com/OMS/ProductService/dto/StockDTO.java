package com.OMS.ProductService.dto;

import javax.validation.constraints.NotNull;

public class StockDTO {
	
	@NotNull
	Integer sellerid;
	Integer stock;
	public Integer getSellerid() {
		return sellerid;
	}
	public void setSellerid(Integer sellerid) {
		this.sellerid = sellerid;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	

}
