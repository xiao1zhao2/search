package com.xiao1zhao2.seach.core;

import com.xiao1zhao2.seach.condition.Condition;
import com.xiao1zhao2.seach.condition.PageCondition;
import com.xiao1zhao2.seach.condition.SortCondition;

public class SearchRequest {

	private Condition queryCondition;

	private SortCondition sortCondition;

	private PageCondition pageCondition;

	public Condition getQueryCondition() {
		return queryCondition;
	}

	public void setQueryCondition(Condition queryCondition) {
		this.queryCondition = queryCondition;
	}

	public SortCondition getSortCondition() {
		return sortCondition;
	}

	public void setSortCondition(SortCondition sortCondition) {
		this.sortCondition = sortCondition;
	}

	public PageCondition getPageCondition() {
		return pageCondition;
	}

	public void setPageCondition(PageCondition pageCondition) {
		this.pageCondition = pageCondition;
	}
}
