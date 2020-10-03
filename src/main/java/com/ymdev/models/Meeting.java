package com.ymdev.models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Meeting {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long meetingId;
	@Column(columnDefinition = "DATE")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate meetingDate;
	@DateTimeFormat(pattern="HH:mm")
	private LocalTime meetingTime;
	private String objective;
	private String notes;
	@ManyToOne
	@JoinColumn(name = "pfe_id")
	private Pfe pfe;

	public Meeting() {
		super();
	}
	
	public Meeting(long meetingId, LocalDate meetingDate, LocalTime meetingTime, String objective, String notes) {
		super();
		this.meetingId = meetingId;
		this.meetingDate = meetingDate;
		this.meetingTime = meetingTime;
		this.objective = objective;
		this.notes = notes;
	}

	/**
	 * @return the meetingId
	 */
	public long getMeetingId() {
		return meetingId;
	}
	/**
	 * @param meetingId the meetingId to set
	 */
	public void setMeetingId(long meetingId) {
		this.meetingId = meetingId;
	}

	/**
	 * @return the objective
	 */
	public String getObjective() {
		return objective;
	}
	/**
	 * @param objective the objective to set
	 */
	public void setObjective(String objective) {
		this.objective = objective;
	}
	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
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
	
	
	/**
	 * @return the meetingDate
	 */
	public LocalDate getMeetingDate() {
		return meetingDate;
	}

	/**
	 * @param meetingDate the meetingDate to set
	 */
	public void setMeetingDate(LocalDate meetingDate) {
		this.meetingDate = meetingDate;
	}

	/**
	 * @return the meetingTime
	 */
	public LocalTime getMeetingTime() {
		return meetingTime;
	}
	
	/**
	 * @param meetingTime the meetingTime to set
	 */
	public void setMeetingTime(LocalTime meetingTime) {
		this.meetingTime = meetingTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Meeting [meetingId=" + meetingId + ", meetingDate=" + meetingDate + ", objective=" + objective
				+ ", notes=" + notes + "]";
	}

}
