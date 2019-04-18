package com.ngando.dualaprojectback.model.word;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@XmlRootElement(name = "word")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Word implements Serializable {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String libelle;

	@Column
	@org.hibernate.annotations.Type(type = "text")
	private String traduction;

	@Column
	private String phonetique;

	@ManyToMany(cascade = CascadeType.DETACH)
	@JoinColumn
	private Set<Type> types = new HashSet<Type>();

	public Word() {
		super();
	}

	public Word(Long id, String libelle, String traduction, String phonetique, Set<Type> types) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.traduction = traduction;
		this.phonetique = phonetique;
		this.types = types;
	}

	public Word(String libelle, String traduction, String phonetique) {
		super();
		this.libelle = libelle;
		this.traduction = traduction;
		this.phonetique = phonetique;
	}

	public Long getId() {
		return id;
	}

	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	@XmlElement
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getTraduction() {
		return traduction;
	}

	@XmlElement
	public void setTraduction(String traduction) {
		this.traduction = traduction;
	}

	public String getPhonetique() {
		return phonetique;
	}

	@XmlElement
	public void setPhonetique(String phonetique) {
		this.phonetique = phonetique;
	}

	public Set<Type> getTypes() {
		return types;
	}

	@XmlElement
	public void setTypes(Set<Type> types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "Word [id=" + id + ", libelle=" + libelle + ", traduction=" + traduction + ", phonétique=" + phonetique
				+ ", " + types + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + ((traduction == null) ? 0 : traduction.hashCode());
		result = prime * result + ((phonetique == null) ? 0 : phonetique.hashCode());
		result = prime * result + ((types == null) ? 0 : types.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Word other = (Word) obj;
		if ((id != null) && (other.id == null)) {
			return false;
		}
		if ((libelle != null) && (other.libelle == null)) {
			return false;
		}
		if (!libelle.equals(other.libelle)) {
			return false;
		}
		if ((traduction != null) && (other.traduction == null)) {
			return false;
		}
		if (!traduction.equals(other.traduction)) {
			return false;
		}
		if ((phonetique != null) && (other.phonetique == null)) {
			return false;
		}
		if (!phonetique.equals(other.phonetique)) {
			return false;
		}
		if ((types != null) && (other.types == null)) {
			return false;
		}
		if (!types.equals(other.types)) {
			return false;
		}

		return true;
	}
}
