package com.app.batch.writer;


import java.util.List;


import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

public class DataWriter implements ItemWriter<String> {

	public void write(List<? extends String> items) throws Exception {
		for (String item : items) {
			System.out.println(item);
			}	
		
	}

}
