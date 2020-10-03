package com.ymdev.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Professor extends User{
	
	private int matricul;
	private String grade;
	@OneToMany(targetEntity = Pfe.class, fetch = FetchType.LAZY, mappedBy= "validator",cascade = CascadeType.ALL)
	private List<Pfe> pfesToValidate;
	@OneToMany(targetEntity = Pfe.class, fetch = FetchType.LAZY, mappedBy= "supervisor",cascade = CascadeType.ALL)
	private List<Pfe> pfesToSuperivise;
	@OneToMany(targetEntity = Pfe.class, fetch = FetchType.LAZY, mappedBy= "president",cascade = CascadeType.ALL)
	private List<Pfe> pfesToPreside;
	@OneToMany(targetEntity = Pfe.class, fetch = FetchType.LAZY, mappedBy= "reporter",cascade = CascadeType.ALL)
	private List<Pfe> pfesToReport;
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "prof_spec", joinColumns= { @JoinColumn(name="prof_id")}, inverseJoinColumns= {@JoinColumn(name="spec_id")} )
	private List<Speciality> specialities;
	public Professor() {
		super();
	}
	
	public Professor(long userId, String lname, String fname, LocalDate birthDate, int cin, int tel, Address address,
			String email, String password) {
		super(userId, lname, fname, birthDate, cin, tel, address, email, password);
		// TODO Auto-generated constructor stub
	}

	public Professor(String lname, String fname, int cin, int tel, String email, String password) {
		super(lname, fname, cin, tel, email, password);
		// TODO Auto-generated constructor stub
	}

	public Professor(String lname, String fname) {
		super(lname, fname);
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @param userId
	 * @param lname
	 * @param fname
	 * @param birthDate
	 * @param cin
	 * @param tel
	 * @param address
	 * @param email
	 * @param password
	 * @param matricul
	 * @param grade
	 * @param pfesToValidate
	 * @param pfesToSuperivise
	 * @param pfesToPreside
	 * @param pfesToReport
	 * @param specialities
	 */
	public Professor(long userId, String lname, String fname, LocalDate birthDate, int cin, int tel, Address address,
			String email, String password, int matricul, String grade, List<Pfe> pfesToValidate,
			List<Pfe> pfesToSuperivise, List<Pfe> pfesToPreside, List<Pfe> pfesToReport,
			List<Speciality> specialities) {
		super(userId, lname, fname, birthDate, cin, tel, address, email, password);
		this.matricul = matricul;
		this.grade = grade;
		this.pfesToValidate = pfesToValidate;
		this.pfesToSuperivise = pfesToSuperivise;
		this.pfesToPreside = pfesToPreside;
		this.pfesToReport = pfesToReport;
		this.specialities = specialities;
	}

	/**
	 * @return the matricul
	 */
	public int getMatricul() {
		return matricul;
	}
	/**
	 * @param matricul the matricul to set
	 */
	public void setMatricul(int matricul) {
		this.matricul = matricul;
	}
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	/**
	 * @return the pfesToValidate
	 */
	public List<Pfe> getPfesToValidate() {
		return pfesToValidate;
	}
	/**
	 * @param pfesToValidate the pfesToValidate to set
	 */
	public void setPfesToValidate(List<Pfe> pfesToValidate) {
		this.pfesToValidate = pfesToValidate;
	}
	/**
	 * @return the pfesToSuperivise
	 */
	public List<Pfe> getPfesToSuperivise() {
		return pfesToSuperivise;
	}
	/**
	 * @param pfesToSuperivise the pfesToSuperivise to set
	 */
	public void setPfesToSuperivise(List<Pfe> pfesToSuperivise) {
		this.pfesToSuperivise = pfesToSuperivise;
	}
	/**
	 * @return the pfesToPreside
	 */
	public List<Pfe> getPfesToPreside() {
		return pfesToPreside;
	}
	/**
	 * @param pfesToPreside the pfesToPreside to set
	 */
	public void setPfesToPreside(List<Pfe> pfesToPreside) {
		this.pfesToPreside = pfesToPreside;
	}
	/**
	 * @return the pfesToReport
	 */
	public List<Pfe> getPfesToReport() {
		return pfesToReport;
	}
	/**
	 * @param pfesToReport the pfesToReport to set
	 */
	public void setPfesToReport(List<Pfe> pfesToReport) {
		this.pfesToReport = pfesToReport;
	}
	/**
	 * @return the specialities
	 */
	public List<Speciality> getSpecialities() {
		return specialities;
	}
	/**
	 * @param specialities the specialities to set
	 */
	public void setSpecialities(List<Speciality> specialities) {
		this.specialities = specialities;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Professor [matricul=" + matricul + ", grade=" + grade + "]";
	}


}
