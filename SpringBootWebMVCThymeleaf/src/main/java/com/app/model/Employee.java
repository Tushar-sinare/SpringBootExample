package com.app.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="EmployeeDetails")
public class Employee {
@Id
@GeneratedValue
@Column(name="EmpId")
private Integer empId;
@Column(name="empName")
private String empName;
@Column(name="empSal")
private Double empSal;

}
