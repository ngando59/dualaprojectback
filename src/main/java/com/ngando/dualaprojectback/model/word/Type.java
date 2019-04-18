package com.ngando.dualaprojectback.model.word;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@Entity
@XmlRootElement(name = "role")
public class Type implements Serializable {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(updatable = true, nullable = false)
	private String typeName;

	@Column
	private String abreviation;

	public Type() {
		super();
	}

	public Type(String typeName, String abreviation) {
		super();
		this.typeName = typeName;
		this.abreviation = abreviation;
	}

	public Long getId() {
		return id;
	}

	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	@XmlElement
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getAbreviation() {
		return abreviation;
	}

	@XmlElement
	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}

	@Override
	public String toString() {
		return "Type [id=" + id + ", type=" + typeName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((typeName == null) ? 0 : typeName.hashCode());
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
		Type other = (Type) obj;
		if (id != other.id) {
			return false;
		}
		if ((typeName == null) && (other.typeName != null)) {
			return false;
		}
		if (!typeName.equals(other.typeName))
			return false;
		return true;
	}

	public int compareTo(Type type) {
		return this.typeName.compareTo(type.typeName);
	}

}
