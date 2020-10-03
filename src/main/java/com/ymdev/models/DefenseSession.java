package com.ymdev.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class DefenseSession {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long defenseId;
	@Column(columnDefinition = "DATE")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate openingDate;
	@Column(columnDefinition = "DATE")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate closingDate;
	@ManyToOne
	@JoinColumn(name = "section_id")
	private Section section;
	public DefenseSession() {
		super();
	}
	public DefenseSession(long defenseId, LocalDate openingDate, LocalDate closingDate) {
		super();
		this.defenseId = defenseId;
		this.openingDate = openingDate;
		this.closingDate = closingDate;
	}
	/**
	 * @return the defenseId
	 */
	public long getDefenseId() {
		return defenseId;
	}
	/**
	 * @param defenseId the defenseId to set
	 */
	public void setDefenseId(long defenseId) {
		this.defenseId = defenseId;
	}
	/**
	 * @return the openingDate
	 */
	public LocalDate getOpeningDate() {
		return openingDate;
	}
	/**
	 * @param openingDate the openingDate to set
	 */
	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}
	/**
	 * @return the closingDate
	 */
	public LocalDate getClosingDate() {
		return closingDate;
	}
	/**
	 * @param closingDate the closingDate to set
	 */
	public void setClosingDate(LocalDate closingDate) {
		this.closingDate = closingDate;
	}
	
	/**
	 * @return the section
	 */
	public Section getSection() {
		return section;
	}
	/**
	 * @param section the section to set
	 */
	public void setSection(Section section) {
		this.section = section;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DefenseSession [defenseId=" + defenseId + ", openingDate=" + openingDate + ", closingDate="
				+ closingDate + "]";
	}

}
