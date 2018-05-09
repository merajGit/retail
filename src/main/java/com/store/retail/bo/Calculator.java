package com.store.retail.bo;

import java.util.List;

import com.store.retail.model.Customer;
import com.store.retail.model.Item;

public interface Calculator {
	public double calculatePrice(Customer customer, ShoppingCart shoppingCart);

	public double calculateDiscountPrice(Customer customer, List<Item> discountItem);

	public List<List<Item>> amoutAfterDiscount(ShoppingCart shoppingCart);

	public double calculateAmout(List<Item> itemList);

}