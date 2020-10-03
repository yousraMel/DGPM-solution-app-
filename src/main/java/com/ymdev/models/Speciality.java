package com.ymdev.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Speciality {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long specId;
	@Column(nullable=false)
	private String specName;
	@ManyToMany(mappedBy="specialities")
	private List<Professor> professors;
	public Speciality() {
		super();
	}
	public Speciality(long specId, String specName) {
		super();
		this.specId = specId;
		this.specName = specName;
	}
	/**
	 * @return the specId
	 */
	public long getSpecId() {
		return specId;
	}
	/**
	 * @param specId the specId to set
	 */
	public void setSpecId(long specId) {
		this.specId = specId;
	}
	/**
	 * @return the specName
	 */
	public String getSpecName() {
		return specName;
	}
	/**
	 * @param specName the specName to set
	 */
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	
	/**
	 * @return the professors
	 */
	public List<Professor> getProfessors() {
		return professors;
	}
	/**
	 * @param professors the professors to set
	 */
	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Speciality [specId=" + specId + ", specName=" + specName + "]";
	}

}
