package com.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name="producttabs")
@Data
public class Product {
@Id
	@Column(name="pid")
	@GeneratedValue
	private Integer id;
	@Column(name="pcode")
	private String code;
	@Column(name="pname")
	private String name;
	@Column(name="pcost")
	private Double cost;
	@Column(name="pgst")
	private Integer gst;
	@Column(name="pnote")
	private String note;
	@Transient
	private String email;
	}

