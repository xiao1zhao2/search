package com.xiao1zhao2.seach.condition;

import com.xiao1zhao2.seach.core.Operator;
import com.xiao1zhao2.seach.core.Translator;

public class PageCondition implements Condition {

	private int page = 1;
	private int pageSize = 50;
	private boolean needCount;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isNeedCount() {
		return needCount;
	}

	public void setNeedCount(boolean needCount) {
		this.needCount = needCount;
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
