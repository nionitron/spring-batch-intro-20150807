package com.acme.springbatch.intro.lez20150805;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Required;

public class LogAccessoItemProcessor implements ItemProcessor<String, LogAccesso> {

	private static final Pattern REGEX = Pattern.compile(
			"(.{23}).*\\[com.arca.arca4u.security.PreAuthenticatedUserDetailsService\\].*Utente \\[(.*?)\\] \\[(.*?)\\].*");

	private String loginDaFiltrare;
	private int contatoreRisultati = 0;
	private int numeroMassimoRisultati;

	@Required
	public void setLoginDaFiltrare(String loginDaFiltrare) {
		this.loginDaFiltrare = loginDaFiltrare;
	}

	@Required
	public void setNumeroMassimoRisultati(int numeroMassimoRisultati) {
		this.numeroMassimoRisultati = numeroMassimoRisultati;
	}

	@Override
	public LogAccesso process(String rigaInElaborazione) throws Exception {
		Matcher matcher = REGEX.matcher(rigaInElaborazione);

		if (matcher.matches() && estraiLogin(matcher).equalsIgnoreCase(loginDaFiltrare)) {
			String dataAccesso = estraiDataAccesso(matcher);

			System.out.println("Trovato accesso il " + dataAccesso);

			contatoreRisultati++;
			verificaSuperamentoLimiteRisultati();

			LogAccesso logAccesso = new LogAccesso();

			logAccesso.dataAccesso = dataAccesso;
			logAccesso.login = loginDaFiltrare;
			logAccesso.nome = estraiNome(matcher);

			return logAccesso;

		} else {
			return null;
		}
	}

	private void verificaSuperamentoLimiteRisultati() {
		if (contatoreRisultati > numeroMassimoRisultati) {
			throw new RuntimeException("Superato il limite di [" + numeroMassimoRisultati + "] risultati.");
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
