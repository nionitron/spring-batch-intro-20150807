package com.acme.springbatch.intro.lez20150804.e03;

public class ElementoTralasciabileException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ElementoTralasciabileException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + getMessage();
	}

}
