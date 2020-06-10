package com.OMS.ProductService.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown=true)
	public class Cart  {
		   Integer buyerId;
		   Integer prodId;
		   Integer quantity;
			public Integer getBuyerId() {
				return buyerId;
			}
			public void setBuyerId(Integer buyerId) {
				this.buyerId = buyerId;
			}
			public Integer getProdId() {
				return prodId;
			}
			public void setProdId(Integer prodId) {
				this.prodId = prodId;
			}
			public Integer getQuantity() {
				return quantity;
			}
			public void setQuantity(Integer quantity) {
				this.quantity = quantity;
			}
			
		@Override
		public String toString() {
			return "Cart[buyerid= "+buyerId+"prodid="+prodId+"quantity="+quantity+"]";
		}
			
	}


