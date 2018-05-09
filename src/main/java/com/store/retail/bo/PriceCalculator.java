package com.store.retail.bo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.store.retail.model.Customer;
import com.store.retail.model.Item;
import com.store.retail.util.CustomerTypeUtils;
import com.store.retail.util.ProductTypeUtils;
import com.store.retail.util.Utility;

@Service("priceCalculator")
public class PriceCalculator implements Calculator {

	private static final Logger logger = LoggerFactory.getLogger(PriceCalculator.class);

	@Override
	public double calculatePrice(Customer customer, ShoppingCart shoppingCart) {
		List<List<Item>> finalList = amoutAfterDiscount(shoppingCart);
		double calculateNoGroceriesAmount = calculateDiscountPrice(customer, finalList.get(0));
		double calculateGroceriesAmount = calculateAmout(finalList.get(1));
		return (calculateNoGroceriesAmount + calculateGroceriesAmount);
	}

	@Override
	public double calculateDiscountPrice(Customer customer, List<Item> discountItem) {
		logger.info("start method calculateDiscountPrice");
		double amout = 0;
		double amoutBeforeDiscount = calculateAmout(discountItem);
		logger.info("amout Before Discount " + amoutBeforeDiscount);
		if (customer.getCustomerType() == CustomerTypeUtils.EMPLOYEE) {
			ThirtyPercentDiscount thirtyPercentDiscount = new ThirtyPercentDiscount();
			amout = amoutAfterDiscount(thirtyPercentDiscount, amoutBeforeDiscount);
		} else if (customer.getCustomerType() == (CustomerTypeUtils.AFFILIATE)) {
			TenPercentDiscount tenPercentDiscount = new TenPercentDiscount();
			amout = amoutAfterDiscount(tenPercentDiscount, amoutBeforeDiscount);
		} else if (Utility.compareDateForTwoYears(customer.getRegistrationDate())) {
			FivePercentDiscount fivePercentDiscount = new FivePercentDiscount();
			amout = amoutAfterDiscount(fivePercentDiscount, amoutBeforeDiscount);
		} else {
			if (amoutBeforeDiscount >= 100) {
				SpecialDiscount specialDiscount = new SpecialDiscount();
				amout = amoutAfterDiscount(specialDiscount, amoutBeforeDiscount);
			} else {
				amout = amoutBeforeDiscount;
			}
		}
		logger.info("start end calculateDiscountPrice");
		return amout;
	}

	@Override
	public List<List<Item>> amoutAfterDiscount(ShoppingCart shoppingCart) {
		List<List<Item>> finalList = new ArrayList<List<Item>>();
		List<Item> discountItem = new ArrayList<Item>();
		List<Item> withoutDiscountItem = new ArrayList<Item>();
		for (Item item : shoppingCart.getItems()) {
			if (ProductTypeUtils.GROCERY.equals(item.getItemType())) {
				withoutDiscountItem.add(item);
			} else {
				discountItem.add(item);
			}
		}
		finalList.add(discountItem);
		finalList.add(withoutDiscountItem);

		return finalList;

	}

	@Override
	public double calculateAmout(List<Item> itemList) {
		double sum = 0;
		for (Item item : itemList) {
			sum += item.getPrice();
		}
		return sum;
	}

	public double amoutAfterDiscount(Discount discount, double amout) {
		return discount.applyDiscount(amout);
	}

}
