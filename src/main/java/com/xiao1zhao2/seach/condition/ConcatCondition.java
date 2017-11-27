package com.xiao1zhao2.seach.condition;

import com.xiao1zhao2.seach.core.Operator;
import com.xiao1zhao2.seach.core.Translator;

public class ConcatCondition implements Condition {

	private Condition condition;
	private Condition next;
	private Operator operator;

	public ConcatCondition(Condition condition, Condition next, Operator operator) {
		this.condition = condition;
		this.next = next;
		this.operator = operator;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public Condition getNext() {
		return next;
	}

	public void setNext(Condition next) {
		this.next = next;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	@Override
	public Condition and(Condition other) {
		return new ConcatCondition(this, other, operator);
	}

	@Override
	public String render(Translator translator) {
		return translator.translate(this);
	}

}
