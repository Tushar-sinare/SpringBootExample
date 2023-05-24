package com.app.model;

import lombok.Data;

@Data
public class Product {
	private Integer id;
	private String name;
	private Double cost;
	private Double gst;
	private Double disc;

	
}
