package com.xiao1zhao2.seach.condition;

import com.xiao1zhao2.seach.actor.Actor;
import com.xiao1zhao2.seach.core.Operator;
import com.xiao1zhao2.seach.core.Translator;

import java.util.ArrayList;
import java.util.List;

public class SortCondition implements Condition {

	private List<SortEntry> sortEntries = new ArrayList<SortEntry>();

	public List<SortEntry> getSortEntries() {
		return sortEntries;
	}

	public void setSortEntries(List<SortEntry> sortEntries) {
		this.sortEntries = sortEntries;
	}

	@Override
	public Condition and(Condition other) {
		return new ConcatCondition(this, other, Operator.CONDITION_AND);
	}

	@Override
	public String render(Translator translator) {
		return translator.translate(this);
	}

	public static class SortEntry {

		private Actor sortFiled;
		private SortType sortType;

		public SortEntry() {
		}

		public SortEntry(Actor sortFiled, SortType sortType) {
			this.sortFiled = sortFiled;
			this.sortType = sortType;
		}

		public Actor getSortFiled() {
			return sortFiled;
		}

		public void setSortFiled(Actor sortFiled) {
			this.sortFiled = sortFiled;
		}

		public SortType getSortType() {
			return sortType;
		}

		public void setSortType(SortType sortType) {
			this.sortType = sortType;
		}
	}

	public enum SortType {

		ASC("asc"), DESC("desc");

		private String type;

		SortType(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}
	}
}
