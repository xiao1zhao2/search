package com.xiao1zhao2.seach.core;

import com.xiao1zhao2.seach.actor.ConcatValue;
import com.xiao1zhao2.seach.actor.Field;
import com.xiao1zhao2.seach.actor.Value;
import com.xiao1zhao2.seach.condition.CompareCondition;
import com.xiao1zhao2.seach.condition.ConcatCondition;
import com.xiao1zhao2.seach.condition.PageCondition;
import com.xiao1zhao2.seach.condition.SortCondition;

public interface Translator {

	String translate(SearchRequest request);

	String translate(Field field);

	String translate(Value value);

	String translate(ConcatValue values);

	String translate(CompareCondition condition);

	String translate(ConcatCondition condition);

	String translate(PageCondition condition);

	String translate(SortCondition condition);
}
