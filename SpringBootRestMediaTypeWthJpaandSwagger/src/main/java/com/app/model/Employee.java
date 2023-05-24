package com.app.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@JacksonXmlRootElement
@Table(name="Emp_Table")
@Data
public class Employee {
@Id
@GeneratedValue
@Column(name="emp_id")
private Integer empId;
@Column(name="emp_name")
private String empName;
@Column(name="emp_sal")
private double empSal;

}
