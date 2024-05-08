package com.gl.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address_table")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int addressId;
	
	@Column(name = "city")
	private String city;
	
	//for Bi-directional just do this, thats it, it will become Bidirectional mapping
//	@OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
//	Employee employee;

	public Address() {
		super();
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String string) {
		this.city = string;
	}

}
