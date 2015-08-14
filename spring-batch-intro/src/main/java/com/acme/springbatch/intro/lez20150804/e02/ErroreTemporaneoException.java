package com.acme.springbatch.intro.lez20150804.e02;

public class ErroreTemporaneoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ErroreTemporaneoException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + getMessage();
	}

}
