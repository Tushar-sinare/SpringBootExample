package com.app.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name= "Employeeche")
public class Employee implements Serializable {

	public static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ", allocationSize = 1)
	private int id;
	@Column(name = "empID")
	private Integer empId;
	@Column(name = "empCode")
	private String empCode;
	@Column(name = "empName")
	private Integer empName;
	@Column(name = "empType")
	private String empType;
	@Column(name = "empSal")
	private Double empSal;
	@Column(name = "Addr")
	private String Addr;
	}
