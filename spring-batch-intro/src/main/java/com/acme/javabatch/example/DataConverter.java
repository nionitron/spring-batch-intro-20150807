package com.acme.javabatch.example;

public class DataConverter {

	public String extractData(String theDate) {
		try {
			String risultato = "";
			risultato += theDate.substring(8, 10);
			risultato += "/";
			risultato += theDate.substring(5, 7);
			risultato += "/";
			risultato += theDate.substring(0, 4);
			return risultato;
		} catch (Exception e) {
			throw new DataConverterException();
		}
	}

}
