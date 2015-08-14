package com.acme.springbatch.intro.lez20150807.e02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Required;

import com.acme.springbatch.intro.lez20150805.LogAccesso;

public class LogAccessoItemProcessor implements ItemProcessor<String, LogAccesso> {

	private static final Pattern REGEX = Pattern.compile(
			"(.{23}).*\\[com.arca.arca4u.security.PreAuthenticatedUserDetailsService\\].*Utente \\[(.*?)\\] \\[(.*?)\\].*");

	private int contatoreAccessi = 0;
	private int numeroAccessiAlFallimento;

	@Required
	public void setNumeroAccessiAlFallimento(int numeroAccessiAlFallimento) {
		this.numeroAccessiAlFallimento = numeroAccessiAlFallimento;
	}

	@Override
	public LogAccesso process(String rigaInElaborazione) throws Exception {
		Matcher matcher = REGEX.matcher(rigaInElaborazione);

		if (matcher.matches()) {
			contatoreAccessi++;
			verificaSeFallimento();

			LogAccesso logAccesso = new LogAccesso();

			logAccesso.dataAccesso = estraiDataAccesso(matcher);
			logAccesso.login = estraiLogin(matcher);
			logAccesso.nome = estraiNome(matcher);

			return logAccesso;

		} else {
			return null;
		}
	}

	private void verificaSeFallimento() {
		if (contatoreAccessi == numeroAccessiAlFallimento) {
			throw new RuntimeException(
					"Superato il limite di [" + numeroAccessiAlFallimento + "] accessi per questo lancio");
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
