package com.stackroute.sparQL.model;

import java.util.List;

public class Results {

	private List<Bindings> bindings;

	public List<Bindings> getBindings() {
		return bindings;
	}

	public void setBindings(List<Bindings> bindings) {
		this.bindings = bindings;
	}

	public Results(List<Bindings> bindings) {
		super();
		this.bindings = bindings;
	}

	public Results() {

	}

	@Override
	public String toString() {
		return "Results [bindings=" + bindings + "]";
	}

}
