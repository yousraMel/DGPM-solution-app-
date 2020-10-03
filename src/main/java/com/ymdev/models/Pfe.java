package com.ymdev.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Pfe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long pfeId;
	@Column(nullable=false)
	private String title;
	@Column(nullable=false)
	private String description;
	@Column(columnDefinition = "DATE")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate defenseDate;
	@DateTimeFormat(pattern="HH:mm")
	private LocalTime defenseTime;
	private String room;
	private float note;
	private String mention;
	private String state;
	@OneToMany(targetEntity = Meeting.class, fetch = FetchType.LAZY, mappedBy= "pfe",cascade = CascadeType.ALL)
	private List<Meeting> meetings;
	@ManyToOne
	@JoinColumn(name= "validator_id")
	private Professor validator;
	@ManyToOne
	@JoinColumn(name= "president_id")
	private Professor president;
	@ManyToOne
	@JoinColumn(name= "reporter_id")
	private Professor reporter;
	@ManyToOne
	@JoinColumn(name= "supervisor_id")
	private Professor supervisor;
	@OneToOne(mappedBy = "pfe", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
  private Student student;
	
	@OneToMany(targetEntity = File.class, fetch = FetchType.LAZY, mappedBy= "pfe",cascade = CascadeType.ALL)
	private List<File> files;
	
	public Pfe() {
		super();
	}
	public Pfe(long pfeId, String title, String description, LocalDate defenseDate, LocalTime defenseTime, String room, float note,
			String mention, String state) {
		super();
		this.pfeId = pfeId;
		this.title = title;
		this.description = description;
		this.defenseDate = defenseDate;
		this.defenseTime = defenseTime;
		this.room = room;
		this.note = note;
		this.mention = mention;
		this.state = state;
	}
	/**
	 * @return the pfeId
	 */
	public long getPfeId() {
		return pfeId;
	}
	/**
	 * @param pfeId the pfeId to set
	 */
	public void setPfeId(long pfeId) {
		this.pfeId = pfeId;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the defenseDate
	 */
	public LocalDate getDefenseDate() {
		return defenseDate;
	}
	/**
	 * @param defenseDate the defenseDate to set
	 */
	public void setDefenseDate(LocalDate defenseDate) {
		this.defenseDate = defenseDate;
	}
	/**
	 * @return the defenseTime
	 */
	public LocalTime getDefenseTime() {
		return defenseTime;
	}
	/**
	 * @param defenseTime the defenseTime to set
	 */
	public void setDefenseTime(LocalTime defenseTime) {
		this.defenseTime = defenseTime;
	}
	/**
	 * @return the room
	 */
	public String getRoom() {
		return room;
	}
	/**
	 * @param room the room to set
	 */
	public void setRoom(String room) {
		this.room = room;
	}
	/**
	 * @return the note
	 */
	public float getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(float note) {
		this.note = note;
	}
	/**
	 * @return the mention
	 */
	public String getMention() {
		return mention;
	}
	/**
	 * @param mention the mention to set
	 */
	public void setMention(String mention) {
		this.mention = mention;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * @return the meetings
	 */
	public List<Meeting> getMeetings() {
		return meetings;
	}
	/**
	 * @param meetings the meetings to set
	 */
	public void setMeetings(List<Meeting> meetings) {
		this.meetings = meetings;
	}
	/**
	 * @return the validator
	 */
	public Professor getValidator() {
		return validator;
	}
	/**
	 * @param validator the validator to set
	 */
	public void setValidator(Professor validator) {
		this.validator = validator;
	}
	/**
	 * @return the president
	 */
	public Professor getPresident() {
		return president;
	}
	/**
	 * @param president the president to set
	 */
	public void setPresident(Professor president) {
		this.president = president;
	}
	/**
	 * @return the reporter
	 */
	public Professor getReporter() {
		return reporter;
	}
	/**
	 * @param reporter the reporter to set
	 */
	public void setReporter(Professor reporter) {
		this.reporter = reporter;
	}
	/**
	 * @return the supervisor
	 */
	public Professor getSupervisor() {
		return supervisor;
	}
	/**
	 * @param supervisor the supervisor to set
	 */
	public void setSupervisor(Professor supervisor) {
		this.supervisor = supervisor;
	}
	
	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}
	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
	/**
	 * @return the files
	 */
	public List<File> getFiles() {
		return files;
	}
	/**
	 * @param files the files to set
	 */
	public void setFiles(List<File> files) {
		this.files = files;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pfe [pfeId=" + pfeId + ", title=" + title + ", description=" + description + ", defenseDate="
				+ defenseDate + ", defenseTime=" + defenseTime + ", room=" + room + ", note=" + note + ", mention="
				+ mention + ", state=" + state + "]";
	}

}
