package com.ymdev.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String country;
	private String city;
	private String street;
	private int numbre;
	public Address() {
		super();
	}
	public Address(String country, String city, String street, int numbre) {
		super();
		this.country = country;
		this.city = city;
		this.street = street;
		this.numbre = numbre;
	}
	
	public Address(String country, String city, String street) {
		super();
		this.country = country;
		this.city = city;
		this.street = street;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumbre() {
		return numbre;
	}
	public void setNumbre(int numbre) {
		this.numbre = numbre;
	}
	@Override
	public String toString() {
		return "Address [country=" + country + ", city=" + city + ", street=" + street + ", numbre=" + numbre + "]";
	}
	
	
}
