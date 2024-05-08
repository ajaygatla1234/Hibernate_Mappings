package com.gl.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Employee_Table")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Emp_Id")
	private int id;
	
	@Column(name="Emp_Name")
	private String emp_name;
	
	@ManyToOne
	@JoinColumn(name = "id")
	Department department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", emp_name=" + emp_name + ", department=" + department + "]";
	}

	public Employee(String emp_name, Department department) {
		super();
		this.emp_name = emp_name;
		this.department = department;
	}
	
}
