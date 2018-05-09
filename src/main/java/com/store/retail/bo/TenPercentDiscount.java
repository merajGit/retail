package com.store.retail.bo;

import org.springframework.stereotype.Service;

@Service("tenPercentDiscount")
public class TenPercentDiscount implements Discount {

	@Override
	public double applyDiscount(double amount) {
		return amount - amount*0.1;
	}

}
