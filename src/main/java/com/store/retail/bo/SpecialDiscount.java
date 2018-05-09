package com.store.retail.bo;

import org.springframework.stereotype.Service;

@Service("specialDiscount")
public class SpecialDiscount implements Discount {

	@Override
	public double applyDiscount(double amount) {
		int  discount = (int)(amount/100)*5;
		return amount- discount;
	}

}
