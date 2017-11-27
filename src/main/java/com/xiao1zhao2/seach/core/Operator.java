package com.xiao1zhao2.seach.core;

public enum Operator {

	EQUALS("="),
	CONDITION_AND("&"),
	SORT_AND(","),
	SORT_EQUALS("_"),
	VALUE_BETWEEN("_"),
	VALUE_IN("|");

	private String operator;

	Operator(String operator) {
		this.operator = operator;
	}

	public String getOperator() {
		return operator;
	}
}
