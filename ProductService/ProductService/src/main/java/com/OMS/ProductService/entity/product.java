package com.OMS.ProductService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Query;
import javax.persistence.Table;



@Entity
@Table(name="product")
public class product {
	@Id
	@GeneratedValue(strategy =GenerationType.TABLE)
	@Column(name="prodid",nullable=false)
	Integer prodid;
	@Column(name = "brand", nullable = false)
	String brand;
	@Column(name = "category", nullable = false)
	String category;
	@Column(name = "description", nullable = false)
	String description;
	@Column(name = "image", nullable = false)
	String image;
	@Column(name = "price")
	Float price;
	@Column(name = "productname", nullable = false)
	String productname;
	@Column(name = "rating")
	Integer rating;
	@Column(name = "sellerid",nullable =false)
	Integer sellerid;
	@Column(name = "stock")
	Integer stock;
	@Column(name = "subcategory", nullable = false)
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
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	
	
	
	
	
	
	
	

	
	

}
