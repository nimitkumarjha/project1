package com.OMS.ProductService.dto;


import com.OMS.ProductService.entity.subscribedproduct;

public class subscribedproductDTO {
	
		Integer subid;
		Integer buyerid;
		Integer prodid;
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
		public subscribedproductDTO() {
			super();
		}
		
		//convert Entity into DTO
		public static subscribedproductDTO valueOf(subscribedproduct subscribedproduct) {
			subscribedproductDTO subscribedproductDTO= new subscribedproductDTO();
			subscribedproductDTO.setProdid(subscribedproduct.getProdid());
			subscribedproductDTO.setSubid(subscribedproduct.getSubid());
			subscribedproductDTO.setBuyerid(subscribedproduct.getBuyerid());
			subscribedproductDTO.setQuantity(subscribedproduct.getQuantity());			
			return subscribedproductDTO;
		}
		
		//convert DTO into Entity
		public subscribedproduct createEntity() {
			subscribedproduct sub = new subscribedproduct();
			sub.setProdid(this.getProdid());
			sub.setSubid(this.getSubid());
			sub.setBuyerid(this.getBuyerid());
			sub.setQuantity(this.getQuantity());			
			return sub;
			
			
		}
		
		@Override
		public String toString() {
			return "subscribedproductDTO[subid="+subid+"prodid=" + prodid +",buyerid="+buyerid+
					",quantity="+quantity+"]";
		}
	

	

	

}
