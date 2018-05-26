package com.stackroute.sparQL.model;

import java.util.Arrays;

public class Head {

	private String[] vars;

	public String[] getVars() {
		return vars;
	}

	public void setVars(String[] vars) {
		this.vars = vars;
	}

	@Override
	public String toString() {
		return "Head [vars=" + Arrays.toString(vars) + "]";
	}

	public Head(String[] vars) {
		super();
		this.vars = vars;
	}

	public Head() {
		
	}
	

}
