package com.ymdev.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class File {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFile;
	@Column(unique=true,nullable=false)
	private String name;
	private String url;
	
	@ManyToOne
	@JoinColumn(name= "pfe_id")
	private Pfe pfe;

	/**
	 * @return the idImage
	 */
	public Long getidFile() {
		return idFile;
	}

	/**
	 * @param idImage the idImage to set
	 */
	public void setIdFile(Long idFile) {
		this.idFile = idFile;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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
		return "File [idImage=" + idFile + ", name=" + name + ", url=" + url + ", pfe=" + pfe + "]";
	}

}
