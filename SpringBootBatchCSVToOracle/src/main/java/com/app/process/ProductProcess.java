package com.app.process;

import org.springframework.batch.item.ItemProcessor;

import com.app.model.Product;

public class ProductProcess implements ItemProcessor<Product, Product> {

	@Override
	public Product process(Product item) throws Exception {
		item.setGst(item.getCost()*12/100.0);
		item.setDisc(item.getCost()*25/100.0);
		return item;
	}
	
	

}
