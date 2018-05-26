package com.stackroute.sparQL.model;

public class Main {

	private Head head;
	private Results results;

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public Results getResults() {
		return results;
	}

	public void setResults(Results results) {
		this.results = results;
	}

	public Main(Head head, Results results) {
		super();
		this.head = head;
		this.results = results;
	}

	public Main() {

	}

	@Override
	public String toString() {
		return "Main [head=" + head + ", results=" + results + "]";
	}

}
