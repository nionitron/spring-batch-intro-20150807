package com.acme.springbatch.intro.lez20150807.e03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.batch.item.ItemProcessor;

import com.acme.springbatch.intro.lez20150805.LogAccesso;

public class LogAccessoItemProcessor implements ItemProcessor<String, LogAccesso> {

	private static final Pattern REGEX = Pattern.compile(
			"(.{23}).*\\[com.arca.arca4u.security.PreAuthenticatedUserDetailsService\\].*Utente \\[(.*?)\\] \\[(.*?)\\].*");

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
			return null;
		}
	}

	private static String estraiDataAccesso(Matcher matcher) {
		return matcher.group(1);
	}

	private static String estraiLogin(Matcher matcher) {
		return matcher.group(2);
	}

	private static String estraiNome(Matcher matcher) {
		return matcher.group(3);
	}

}
