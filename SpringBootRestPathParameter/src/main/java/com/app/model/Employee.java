package com.app.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class Employee {
private int empId;
private String empName;
private Double Empsal;
public Employee() {
	super();
	
}
public Employee(int empId, String empName, Double empsal) {
	super();
	this.empId = empId;
	this.empName = empName;
	Empsal = empsal;
}
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public Double getEmpsal() {
	return Empsal;
}
public void setEmpsal(Double empsal) {
	Empsal = empsal;
}
@Override
public String toString() {
	return "Employee [empId=" + empId + ", empName=" + empName + ", Empsal=" + Empsal + "]";
}



}
