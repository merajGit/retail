package com.store.retail.bo;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.store.retail.model.Item;

@Service("shoppingCart")
public class ShoppingCart {
	//List of items
		List<Item> items;
		
		public List<Item> getItems() {
			return items;
		}

		public ShoppingCart(){
			this.items=new ArrayList<Item>();
		}
		
		public void addItem(Item item){
			this.items.add(item);
		}
		
		public void removeItem(Item item){
			this.items.remove(item);
		}
		
		
	}