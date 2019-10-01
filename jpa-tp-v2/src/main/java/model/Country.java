package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@SuppressWarnings("serial")
@Entity
public class Country implements java.io.Serializable {

	private Long id;
	private int version;
	private String name;

	@Override
	public String toString() {
		return "Country [id=" + id + ", version=" + version + ", name=" + name + "]";
	}

	public Country() {
	}

	public Country(String _name) {
		super();
		name = _name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	@Version
	public int getVersion() {
		return this.version;
	}

	// @Column(length = 10, unique = true)
	@Column(length = 10)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
