package com.ymdev.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Personnel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long persId;
	@Column(nullable=false)
	private String fname;
	@Column(nullable=false)
	private String lname;
	@Embedded
	private Address address;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private int tel;
	@Column(nullable=false)
	private String postOffice;
	@ManyToOne
	@JoinColumn(name="organism_id")
	private Organism organism;
	@OneToOne
	@JoinColumn(unique = true)
	private Pfe pfe;
	
	public Personnel() {
		super();
	}
	public Personnel(long persId, String fname, String lname, Address address, String email, int tel,
			String postOffice) {
		super();
		this.persId = persId;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.email = email;
		this.tel = tel;
		this.postOffice = postOffice;
	}
	/**
	 * @return the persId
	 */
	public long getPersId() {
		return persId;
	}
	/**
	 * @param persId the persId to set
	 */
	public void setPersId(long persId) {
		this.persId = persId;
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
	 * @return the postOffice
	 */
	public String getPostOffice() {
		return postOffice;
	}
	/**
	 * @param postOffice the postOffice to set
	 */
	public void setPostOffice(String postOffice) {
		this.postOffice = postOffice;
	}
	
	/**
	 * @return the organism
	 */
	public Organism getOrganism() {
		return organism;
	}
	/**
	 * @param organism the organism to set
	 */
	public void setOrganism(Organism organism) {
		this.organism = organism;
	}
	/**
	 * @return the pfe
	 */
	public Pfe getPfe() {
		return pfe;
	}
	/**
	 * @param pfe the pfe to set
	 */
	public void setPfe(Pfe pfe) {
		this.pfe = pfe;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Personnel [persId=" + persId + ", fname=" + fname + ", lname=" + lname + ", address=" + address
				+ ", email=" + email + ", tel=" + tel + ", postOffice=" + postOffice + "]";
	}

}
