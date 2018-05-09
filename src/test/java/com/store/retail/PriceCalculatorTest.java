package com.store.retail;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.store.retail.bo.PriceCalculator;
import com.store.retail.bo.ShoppingCart;
import com.store.retail.model.Customer;
import com.store.retail.model.Item;
import com.store.retail.util.CustomerTypeUtils;
import com.store.retail.util.ProductTypeUtils;

@RunWith(SpringRunner.class)
public class PriceCalculatorTest {

	@Mock
	PriceCalculator priceCalculator;

	@Mock
	ShoppingCartTest shoppingCartTest;

	@Mock
	ShoppingCart shoppingCart;

	@Test
	public void totalPriceForCustomerTypeEmployeee() throws Exception {
		Customer customer = loadCustomer("abc", "xyz", CustomerTypeUtils.EMPLOYEE, new Date("10/01/2016"));
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.addItem(addItem("1234###", ProductTypeUtils.OTHER, 3000, "TV"));
		shoppingCart.addItem(addItem("2234###", ProductTypeUtils.GROCERY, 1000, "TV"));
		priceCalculator.calculatePrice(customer, shoppingCart);
	}

	@Test
	public void totalPriceForCustomerTypeOther() throws Exception {
		Customer customer = loadCustomer("abc", "xyz", CustomerTypeUtils.OTHER, new Date("10/01/2016"));
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.addItem(addItem("1234###", ProductTypeUtils.OTHER, 3000, "TV"));
		shoppingCart.addItem(addItem("2234###", ProductTypeUtils.GROCERY, 1000, "TV"));
		priceCalculator.calculatePrice(customer, shoppingCart);
	}

	@Test
	public void totalPriceForCustomerTypeOtherAffliate() throws Exception {
		Customer customer = loadCustomer("abc", "xyz", CustomerTypeUtils.AFFILIATE, new Date("10/01/2016"));
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.addItem(addItem("1234###", ProductTypeUtils.OTHER, 3000, "TV"));
		shoppingCart.addItem(addItem("2234###", ProductTypeUtils.GROCERY, 1000, "TV"));
		priceCalculator.calculatePrice(customer, shoppingCart);
	}

	public static Customer loadCustomer(String firstName, String LastName, Enum cutomerType, Date registrationDate) {
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setFirstName(LastName);
		customer.setCustomerType(cutomerType);
		customer.setRegistrationDate(registrationDate);
		return customer;
	}

	public static Item addItem(String upcCode, Enum itemType, double price, String description) {
		Item item = new Item();
		item.setUpcCode(upcCode);
		item.setItemType(itemType);
		item.setPrice(price);
		item.setDescription(description);
		return item;
	}

}
