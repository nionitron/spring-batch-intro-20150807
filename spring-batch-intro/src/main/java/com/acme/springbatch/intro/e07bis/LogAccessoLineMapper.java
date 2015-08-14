package com.acme.springbatch.intro.e07bis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.batch.item.file.LineMapper;

import com.acme.javabatch.example.DataConverter;

public class LogAccessoLineMapper implements LineMapper<LogAccesso> {

	private static final Pattern REGEX = Pattern
			.compile("(.{23}).*\\[com.arca.arca4u.security.PreAuthenticatedUserDetailsService\\].*Utente \\[(.*?)\\] \\[(.*?)\\].*");

	@Override
	public LogAccesso mapLine(String rigaInElaborazione, int lineNumber)
			throws Exception {

		LogAccesso logAccesso = new LogAccesso();

		Matcher matcher = REGEX.matcher(rigaInElaborazione);
		if (matcher.matches()) {
			logAccesso.dataAccesso = estraiDataAccesso(matcher);
			logAccesso.login = estraiLogin(matcher);
			logAccesso.nome = estraiNome(matcher);
			logAccesso.valido = true;
		}

		return logAccesso;
	}

	private static String estraiDataAccesso(Matcher matcher) {
		String theDate = matcher.group(1);
		String dataFormattata = new DataConverter().extractData(theDate);
		return dataFormattata;
	}

	private static String estraiLogin(Matcher matcher) {
		String login = matcher.group(2);
		return login;
	}

	private static String estraiNome(Matcher matcher) {
		String nome = matcher.group(3);
		return nome;
	}

}
