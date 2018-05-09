package com.store.retail.bo;

import org.springframework.stereotype.Service;

@Service("fivePercentDiscount")
public class FivePercentDiscount implements Discount {

	@Override
	public double applyDiscount(double amount) {
		return amount- amount*0.05;
		
	}

}
