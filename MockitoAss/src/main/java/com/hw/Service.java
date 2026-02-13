package com.hw;

public class Service {
	
	private Discount repo;
	
	public Service(Discount repo) {
		
		this.repo = repo;
	}
	
	public double calFinalPrice(double price,String productCode) {
		double discount = repo.getDiscountPercentage(productCode);
		double finalprice = price - (price*discount/100);
		
		return finalprice;
	}

}
