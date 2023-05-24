package com.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import lombok.Data;

@Data
@Entity
@Table(name="PRODUCTTAB")
public class Product {
@Id
@Column(name="Id")
@GeneratedValue
private int id;
@Column(name="code")
private String code;
@Column(name="name")
private String name;
@Column(name="cost")
private Double cost;
@Column(name="gst")
private String gst;
@Column(name="note")
private String note;


}
