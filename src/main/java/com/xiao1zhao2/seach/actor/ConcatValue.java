package com.xiao1zhao2.seach.actor;

import com.xiao1zhao2.seach.core.Operator;
import com.xiao1zhao2.seach.core.Translator;

import java.util.List;

public class ConcatValue<E> implements Actor {

	private List<Value<E>> values;

	private Operator operator;

	public ConcatValue() {
	}

	public ConcatValue(List<Value<E>> values, Operator operator) {
		this.values = values;
		this.operator = operator;
	}

	public List<Value<E>> getValues() {
		return values;
	}

	public void setValues(List<Value<E>> values) {
		this.values = values;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	@Override
	public String render(Translator translator) {
		return translator.translate(this);
	}

}
