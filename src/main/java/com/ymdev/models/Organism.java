package com.ymdev.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Organism {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long orgaId;
	@Column(nullable=false)
	private String orgaName;
	@Embedded
	private Address address;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private int tel;
	@OneToMany(targetEntity = Personnel.class, fetch = FetchType.LAZY, mappedBy= "organism",cascade = CascadeType.ALL)
	private List<Personnel> personnels;
	public Organism() {
		super();
	}
	
	public Organism(long orgaId, String orgaName, Address address, String email, int tel) {
		super();
		this.orgaId = orgaId;
		this.orgaName = orgaName;
		this.address = address;
		this.email = email;
		this.tel = tel;
	}
	/**
	 * @return the orgaId
	 */
	public long getOrgaId() {
		return orgaId;
	}
	/**
	 * @param orgaId the orgaId to set
	 */
	public void setOrgaId(long orgaId) {
		this.orgaId = orgaId;
	}
	/**
	 * @return the orgaName
	 */
	public String getOrgaName() {
		return orgaName;
	}
	/**
	 * @param orgaName the orgaName to set
	 */
	public void setOrgaName(String orgaName) {
		this.orgaName = orgaName;
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
	 * @return the personnels
	 */
	public List<Personnel> getPersonnels() {
		return personnels;
	}

	/**
	 * @param personnels the personnels to set
	 */
	public void setPersonnels(List<Personnel> personnels) {
		this.personnels = personnels;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Organism [orgaId=" + orgaId + ", orgaName=" + orgaName + ", address=" + address + ", email=" + email
				+ ", tel=" + tel + "]";
	}

}
