package com.OMS.ProductService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subscribedproduct")
public class subscribedproduct {
	 @Id
	 @GeneratedValue(strategy =GenerationType.AUTO)
	 @Column(name="subid",nullable=false)
		Integer subid;
	 @Column(name="buyerid",nullable=false)
		Integer buyerid;
	 @Column(name="prodid",nullable=false)
		Integer prodid;
	 @Column(name="quantity")
		Integer quantity;
	public Integer getSubid() {
		return subid;
	}
	public void setSubid(Integer subid) {
		this.subid = subid;
	}
	public Integer getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(Integer buyerid) {
		this.buyerid = buyerid;
	}
	public Integer getProdid() {
		return prodid;
	}
	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	

}
