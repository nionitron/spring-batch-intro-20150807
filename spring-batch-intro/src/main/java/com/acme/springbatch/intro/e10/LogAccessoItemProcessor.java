package com.acme.springbatch.intro.e10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.batch.item.ItemProcessor;

import com.acme.javabatch.example.DataConverter;

public class LogAccessoItemProcessor implements
		ItemProcessor<String, LogAccesso> {

	private static final Pattern REGEX = Pattern
			.compile("(.{23}).*\\[com.arca.arca4u.security.PreAuthenticatedUserDetailsService\\].*Utente \\[(.*?)\\] \\[(.*?)\\].*");

	@Override
	public LogAccesso process(String rigaInElaborazione) throws Exception {
		Matcher matcher = REGEX.matcher(rigaInElaborazione);

		if (matcher.matches()) {

			LogAccesso logAccesso = new LogAccesso();

			logAccesso.dataAccesso = estraiDataAccesso(matcher);
			logAccesso.login = estraiLogin(matcher);
			logAccesso.nome = estraiNome(matcher);

			return logAccesso;

		} else {

			/*
			 * Scarta la riga in elaborazione
			 */
			return null;
		}
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
