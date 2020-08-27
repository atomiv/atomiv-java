package org.atomiv.framework.core.domain;

public class Identity<TValue> {

	private TValue value;

	public Identity(TValue value, TValue defaultValue) {

		if (value.equals(defaultValue)) {
			throw new IllegalArgumentException("Id value cannot be the default value");
		}

		this.value = value;
	}

	public TValue getValue() {
		return value;
	}
}
