package com.store.retail.bo;

import org.springframework.stereotype.Service;

@Service("thirtyPercentDiscount")
public class ThirtyPercentDiscount implements Discount {

	@Override
	public double applyDiscount(double amount) {
		return amount- amount*0.3;
		
	}

}
