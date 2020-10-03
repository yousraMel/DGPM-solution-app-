package com.ymdev.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Student extends User{
	
	private int studentIDCard;
	@ManyToOne
	@JoinColumn(name = "section_id")
	private Section section;
	@OneToOne
	@JoinColumn(unique = true)
	private Pfe pfe;
	
	public Student() {
		super();
	}

	public Student(String lname, String fname, int cin, int tel,
			String email, String password, int studentIDCard) {
		super( lname, fname,cin, tel, email, password);
		this.studentIDCard = studentIDCard;
	}
	
	
	public Student(int studentIDCard) {
		super();
		this.studentIDCard = studentIDCard;
	}

	/**
	 * @return the studentIDCard
	 */
	public int getStudentIDCard() {
		return studentIDCard;
	}

	public Student(String lname, String fname) {
		super(lname, fname);
	}

	/**
	 * @param studentIDCard the studentIDCard to set
	 */
	public void setStudentIDCard(int studentIDCard) {
		this.studentIDCard = studentIDCard;
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
		return "Student [studentIDCard=" + studentIDCard + ", section=" + section + ", pfe=" + pfe + ", getUserId()="
				+ getUserId() + ", getLname()=" + getLname() + ", getFname()=" + getFname() + ", getBirthDate()="
				+ getBirthDate() + ", getCin()=" + getCin() + ", getTel()=" + getTel() + ", getAddress()="
				+ getAddress() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	

}
