package com.xiao1zhao2.seach.actor;

import com.xiao1zhao2.seach.core.Translator;

public class Value<E> implements Actor {

	private E value;

	public Value() {
	}

	public Value(E value) {
		this.value = value;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	@Override
	public String render(Translator translator) {
		return translator.translate(this);
	}

}
