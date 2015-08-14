package com.acme.javabatch.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogAccessoLineParser {

	private static final String REGEX = "(.{23}).*\\[com.arca.arca4u.security.PreAuthenticatedUserDetailsService\\].*Utente \\[(.*?)\\] \\[(.*?)\\].*";
	private Matcher matcher;

	public LogAccessoLineParser(String rigaInElaborazione) {
		Pattern pattern = Pattern.compile(REGEX);
		matcher = pattern.matcher(rigaInElaborazione);
	}

	public boolean isRigaDiAccesso() {
		return matcher.matches();
	}

	public String getDataAccesso() {
		String theDate = matcher.group(1);
		String dataFormattata = new DataConverter().extractData(theDate);
		return dataFormattata;
	}

	public String getLogin() {
		String login = matcher.group(2);
		return login;
	}

	public String getNome() {
		String login = matcher.group(3);
		return login;
	}

	public boolean isEsterno() {
		return getLogin().startsWith("arx");
	}

}
