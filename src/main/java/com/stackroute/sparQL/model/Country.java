package com.stackroute.sparQL.model;

public class Country {

	private String type;
	private String value;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Country(String type, String value) {
		super();
		this.type = type;
		this.value = value;
	}

	public Country() {

	}

	@Override
	public String toString() {
		return "Country [type=" + type + ", value=" + value + "]";
	}

}
