package com.ymdev.models;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userId;
	@Column(nullable=false)
	private String lname;
	@Column(nullable=false)
	private String fname;
	@Column(columnDefinition = "DATE")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate birthDate ;
	@Column(nullable=false)
	private int cin;

	private int tel;
	@Embedded
	private Address address;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String password;
	public User() {
		super();
	}
	public User(long userId, String lname, String fname, LocalDate birthDate, int cin, int tel, Address address,
			String email, String password) {
		super();
		this.userId = userId;
		this.lname = lname;
		this.fname = fname;
		this.birthDate = birthDate;
		this.cin = cin;
		this.tel = tel;
		this.address = address;
		this.email = email;
		this.password = password;
	}
	
	
	public User(String lname, String fname) {
		super();
		this.lname = lname;
		this.fname = fname;
	}
	public User( String lname, String fname, int cin, int tel, String email,
			String password) {
		super();

		this.lname = lname;
		this.fname = fname;
		this.cin = cin;
		this.tel = tel;
		this.email = email;
		this.password = password;
	}
	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}
	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}
	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	/**
	 * @return the birthDate
	 */
	public LocalDate getBirthDate() {
		return birthDate;
	}
	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * @return the cin
	 */
	public int getCin() {
		return cin;
	}
	/**
	 * @param cin the cin to set
	 */
	public void setCin(int cin) {
		this.cin = cin;
	}
	/**
	 * @return the tel
	 */
	public int getTel() {
		return tel;
	}
	/**
	 * @param tel the tel to set
	 */
	public void setTel(int tel) {
		this.tel = tel;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", lname=" + lname + ", fname=" + fname + ", birthDate=" + birthDate
				+ ", cin=" + cin + ", tel=" + tel + ", address=" + address + ", email=" + email + ", password="
				+ password + "]";
	}
	

}
