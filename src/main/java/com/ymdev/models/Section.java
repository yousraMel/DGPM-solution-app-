package com.ymdev.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Section {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long sectionId;
	@Column(nullable=false)
	private String sectionName;
	private String pfeTerm;
	private String defenseTerm;
	@OneToMany(targetEntity = Student.class, fetch = FetchType.LAZY, mappedBy= "section",cascade = CascadeType.ALL)
	private List<Student> students;
	@OneToMany(targetEntity = DefenseSession.class, fetch = FetchType.LAZY, mappedBy= "section",cascade = CascadeType.ALL)
	private List<DefenseSession> defensesessions;
	
	public Section() {
		super();
	}
	public Section(long sectionId, String sectionName, String pfeTerm, String defenseTerm) {
		super();
		this.sectionId = sectionId;
		this.sectionName = sectionName;
		this.pfeTerm = pfeTerm;
		this.defenseTerm = defenseTerm;
	}
	/**
	 * @return the sectionId
	 */
	public long getSectionId() {
		return sectionId;
	}
	/**
	 * @param sectionId the sectionId to set
	 */
	public void setSectionId(long sectionId) {
		this.sectionId = sectionId;
	}
	/**
	 * @return the sectionName
	 */
	public String getSectionName() {
		return sectionName;
	}
	/**
	 * @param sectionName the sectionName to set
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	/**
	 * @return the pfeTerm
	 */
	public String getPfeTerm() {
		return pfeTerm;
	}
	/**
	 * @param pfeTerm the pfeTerm to set
	 */
	public void setPfeTerm(String pfeTerm) {
		this.pfeTerm = pfeTerm;
	}
	/**
	 * @return the defenseTerm
	 */
	public String getDefenseTerm() {
		return defenseTerm;
	}
	/**
	 * @param defenseTerm the defenseTerm to set
	 */
	public void setDefenseTerm(String defenseTerm) {
		this.defenseTerm = defenseTerm;
	}
	
	/**
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	}
	/**
	 * @param students the students to set
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	/**
	 * @return the defensesessions
	 */
	public List<DefenseSession> getDefensesessions() {
		return defensesessions;
	}
	/**
	 * @param defensesessions the defensesessions to set
	 */
	public void setDefensesessions(List<DefenseSession> defensesessions) {
		this.defensesessions = defensesessions;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Section [sectionId=" + sectionId + ", sectionName=" + sectionName + ", pfeTerm=" + pfeTerm
				+ ", defenseTerm=" + defenseTerm + "]";
	}


}
