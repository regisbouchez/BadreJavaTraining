package model;

public class Country implements java.io.Serializable {

	private long id;
	private int version;
	private String name;

	public Country() {
	}

	public long getId() {
		return id;
	}

	public Country(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
