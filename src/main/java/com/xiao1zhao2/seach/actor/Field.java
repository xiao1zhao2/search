package com.xiao1zhao2.seach.actor;

import com.xiao1zhao2.seach.condition.CompareCondition;
import com.xiao1zhao2.seach.condition.Condition;
import com.xiao1zhao2.seach.condition.SortCondition;
import com.xiao1zhao2.seach.core.Operator;
import com.xiao1zhao2.seach.core.Translator;

import java.util.ArrayList;
import java.util.List;

public class Field<T> implements Actor {

	private String name;

	public Field(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String render(Translator translator) {
		return translator.translate(this);
	}

	public Condition equal(T value) {
		return new CompareCondition(this, new Value<T>(value), Operator.EQUALS);
	}

	public Condition in(T... values) {
		List<Value<T>> valueList = new ArrayList<Value<T>>();
		for (T value : values) {
			valueList.add(new Value<T>(value));
		}
		return new CompareCondition(this, new ConcatValue<T>(valueList, Operator.VALUE_IN), Operator.EQUALS);
	}

	public Condition between(T left, T right) {
		List<Value<T>> valueList = new ArrayList<Value<T>>();
		valueList.add(new Value<T>(left));
		valueList.add(new Value<T>(right));
		return new CompareCondition(this, new ConcatValue<T>(valueList, Operator.VALUE_BETWEEN), Operator.EQUALS);
	}

	public SortCondition.SortEntry asc() {
		return new SortCondition.SortEntry(this, SortCondition.SortType.ASC);
	}

	public SortCondition.SortEntry desc() {
		return new SortCondition.SortEntry(this, SortCondition.SortType.DESC);
	}

}
