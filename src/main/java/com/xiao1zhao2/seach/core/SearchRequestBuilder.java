package com.xiao1zhao2.seach.core;

import com.xiao1zhao2.seach.condition.ConcatCondition;
import com.xiao1zhao2.seach.condition.Condition;
import com.xiao1zhao2.seach.condition.PageCondition;
import com.xiao1zhao2.seach.condition.SortCondition;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchRequestBuilder {

	private final SearchRequest request = new SearchRequest();

	public SearchRequestBuilder and(Condition condition) {

		if (request.getQueryCondition() == null) {
			request.setQueryCondition(condition);
		} else {
			request.setQueryCondition(new ConcatCondition(request.getQueryCondition(), condition, Operator.CONDITION_AND));
		}
		return this;
	}

	public SearchRequestBuilder sort(SortCondition.SortEntry... sortEntries) {

		if (request.getSortCondition() == null) {
			request.setSortCondition(new SortCondition());
		}
		request.getSortCondition().getSortEntries().addAll(new ArrayList<SortCondition.SortEntry>(Arrays.asList(sortEntries)));
		return this;
	}

	public SearchRequestBuilder page(int page) {

		if (request.getPageCondition() == null) {
			request.setPageCondition(new PageCondition());
		}
		request.getPageCondition().setPage(page);
		return this;
	}

	public SearchRequestBuilder pageSize(int pageSize) {

		if (request.getPageCondition() == null) {
			request.setPageCondition(new PageCondition());
		}
		request.getPageCondition().setPageSize(pageSize);
		return this;
	}

	public SearchRequest build() {
		return request;
	}

}
