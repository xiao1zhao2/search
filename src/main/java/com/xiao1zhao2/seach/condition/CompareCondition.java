package com.xiao1zhao2.seach.condition;

import com.xiao1zhao2.seach.actor.Actor;
import com.xiao1zhao2.seach.core.Operator;
import com.xiao1zhao2.seach.core.Translator;

public class CompareCondition implements Condition {

	private Actor field;
	private Actor value;
	private Operator operator;

	public CompareCondition(Actor field, Actor value, Operator operator) {
		this.field = field;
		this.value = value;
		this.operator = operator;
	}

	public Actor getField() {
		return field;
	}

	public void setField(Actor field) {
		this.field = field;
	}

	public Actor getValue() {
		return value;
	}

	public void setValue(Actor value) {
		this.value = value;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	@Override
	public Condition and(Condition other) {
		return new ConcatCondition(this, other, Operator.CONDITION_AND);
	}

	@Override
	public String render(Translator translator) {
		return translator.translate(this);
	}

}
