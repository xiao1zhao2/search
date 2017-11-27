package com.xiao1zhao2.seach.core;

import com.xiao1zhao2.seach.actor.ConcatValue;
import com.xiao1zhao2.seach.actor.Field;
import com.xiao1zhao2.seach.actor.Value;
import com.xiao1zhao2.seach.condition.CompareCondition;
import com.xiao1zhao2.seach.condition.ConcatCondition;
import com.xiao1zhao2.seach.condition.PageCondition;
import com.xiao1zhao2.seach.condition.SortCondition;
import com.xiao1zhao2.seach.service.CommonFields;

import java.util.List;

public abstract class AbstractTranslator implements Translator {

	@Override
	public String translate(Field field) {
		return field.getName();
	}

	@Override
	public String translate(Value value) {

		if (value.getValue() instanceof Boolean) {
			return ((Boolean) value.getValue()) ? "1" : "0";
		}
		return value.getValue().toString();
	}

	@Override
	public String translate(ConcatValue values) {

		List<Value> list = values.getValues();
		StringBuilder sb = new StringBuilder();
		for (Value value : list) {
			sb.append(translate(value)).append(values.getOperator().getOperator());
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	@Override
	public String translate(CompareCondition condition) {
		return condition.getField().render(this) + condition.getOperator().getOperator() + condition.getValue().render(this);
	}

	@Override
	public String translate(ConcatCondition condition) {
		return condition.getCondition().render(this) + condition.getOperator().getOperator() + condition.getNext().render(this);
	}

	@Override
	public String translate(PageCondition condition) {
		return new ConcatCondition(CommonFields.PAGE.equal(condition.getPage()), CommonFields.PAGE_SIZE.equal(condition.getPageSize()), Operator.CONDITION_AND).render(this);
	}

	@Override
	public String translate(SortCondition condition) {

		StringBuilder sb = new StringBuilder();
		List<SortCondition.SortEntry> sortEntries = condition.getSortEntries();
		sb.append(CommonFields.SORT.getName()).append(Operator.EQUALS.getOperator());
		for (SortCondition.SortEntry entry : sortEntries) {
			sb.append(entry.getSortFiled().render(this)).append(Operator.SORT_EQUALS.getOperator()).append(entry.getSortType().getType()).append(Operator.SORT_AND.getOperator());
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
