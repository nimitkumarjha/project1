package com.OMS.ProductService.dto;

import com.OMS.ProductService.entity.product;

public class productDTO {
	
	Integer prodid;		
	String brand;
	String category;
	String description;
	String image;
	Float price;
	String productname;
	Integer rating;
	Integer sellerid;
	Integer stock;
	String subcategory;
	
	public Integer getProdid() {
		return prodid;
	}
	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Integer getSellerid() {
		return sellerid;
	}
	public void setSellerid(Integer sellerid) {
		this.sellerid = sellerid;
	}
	public Integer getStock() {
		return stock;
	}
	public Integer setStock(Integer stock) {
		return this.stock = stock;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public productDTO() {
		super();
	}
	
	//convert Entity into DTO
	public static productDTO valueOf(product product) {
		productDTO productDTO= new productDTO();
		productDTO.setProdid(product.getProdid());
		productDTO.setBrand(product.getBrand());
		productDTO.setCategory(product.getCategory());
		productDTO.setDescription(product.getDescription());
		productDTO.setImage(product.getImage());
		productDTO.setPrice(product.getPrice());
		productDTO.setProductname(product.getProductname());
		productDTO.setRating(product.getRating());
		productDTO.setSellerid(product.getSellerid());
		productDTO.setStock(product.getStock());
		productDTO.setSubcategory(product.getSubcategory());
		
		return productDTO;
	}
	
	//convert DTO into Entity
	public product createEntity() {
		product prod=new product();
		prod.setProdid(this.getProdid());
		prod.setBrand(this.getBrand());
		prod.setCategory(this.getCategory());
		prod.setDescription(this.getDescription());
		prod.setImage(this.getImage());
		prod.setPrice(this.getPrice());
		prod.setProductname(this.getProductname());
		prod.setRating(this.getRating());
		prod.setSellerid(this.getSellerid());
		prod.setStock(this.getStock());
		prod.setSubcategory(this.getSubcategory());
		//System.out.println("========= I am in DTO creating entity method =========");
		
		return prod;
	}
	
	@Override
	public String toString() {
		return "productDTO[prodid=" + prodid + ",brand= "+brand+",category="+category+",description="+description+",image="
				+image+",price="+price+",productname="+productname+",rating="+rating+",sellerid="+sellerid+",stock="+stock+
				",subcategory="+subcategory+"]";
		
		
	}
	

	

}
