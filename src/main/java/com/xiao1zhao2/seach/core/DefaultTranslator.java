package com.xiao1zhao2.seach.core;

public class DefaultTranslator extends AbstractTranslator {

	private String query;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	@Override
	public String translate(SearchRequest request) {

		StringBuilder stringBuilder = new StringBuilder();
		String queryCondition = request.getQueryCondition().render(this);
		if (queryCondition != null && queryCondition.length() > 0) {
			stringBuilder.append(queryCondition);
		}

		String sortCondition = request.getSortCondition().render(this);
		if (sortCondition != null && sortCondition.length() > 0) {
			stringBuilder.append(Operator.CONDITION_AND.getOperator()).append(sortCondition);
		}

		String pageCondition = request.getPageCondition().render(this);
		if (pageCondition != null && pageCondition.length() > 0) {
			stringBuilder.append(Operator.CONDITION_AND.getOperator()).append(pageCondition);
		}

		this.query = stringBuilder.toString();
		return this.query;
	}

}
