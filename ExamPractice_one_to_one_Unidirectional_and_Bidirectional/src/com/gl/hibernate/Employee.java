package com.gl.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import javax.persistence.CascadeType;


@Entity
@Table(name="employee_table")
public class Employee {
	
	public Employee() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employye_id")
	private int id;
	
	@Column(name="employye_firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="addressId")
	private Address address;
	
	//in case of bidirectional mapping, you can use the above mapping-
	//-as it is or u can also have the below configuration, both works fine
//	@OneToOne
//	@PrimaryKeyJoinColumn
//	private Address address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address.getCity()
				+ "]";
	}
	
	
}
