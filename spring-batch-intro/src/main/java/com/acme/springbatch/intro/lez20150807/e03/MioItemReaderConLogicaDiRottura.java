package com.acme.springbatch.intro.lez20150807.e03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.repeat.RepeatContext;
import org.springframework.batch.repeat.policy.CompletionPolicySupport;
import org.springframework.beans.factory.annotation.Required;

public class MioItemReaderConLogicaDiRottura extends CompletionPolicySupport implements ItemReader<String>, ItemStream {

	private static final Pattern REGEX = Pattern.compile(
			"(.{23}).*\\[com.arca.arca4u.security.PreAuthenticatedUserDetailsService\\].*Utente \\[(.*?)\\] \\[(.*?)\\].*");

	private ItemReader<String> delegate;
	private String rigaCorrente;
	private String loginPerRottura;

	@Required
	public void setDelegate(ItemReader<String> delegate) {
		this.delegate = delegate;
	}

	@Required
	public void setLoginPerRottura(String loginPerRottura) {
		this.loginPerRottura = loginPerRottura;
	}

	/*
	 * Metodi di ItemStream
	 */

	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		if (delegate instanceof ItemStream) {
			((ItemStream) delegate).open(executionContext);
		}
	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		if (delegate instanceof ItemStream) {
			((ItemStream) delegate).update(executionContext);
		}
	}

	@Override
	public void close() throws ItemStreamException {
		if (delegate instanceof ItemStream) {
			((ItemStream) delegate).close();
		}
	}

	/*
	 * Metodi di ItemReader
	 */

	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		rigaCorrente = delegate.read();
		return rigaCorrente;
	}

	/*
	 * Metodi di CompletionPolicySupport
	 */

	@Override
	public boolean isComplete(RepeatContext context) {
		Matcher matcher = REGEX.matcher(rigaCorrente);

		if (matcher.matches()) {
			return estraiLogin(matcher).equalsIgnoreCase(loginPerRottura);

		} else {
			return false;
		}
	}

	/*
	 * Metodi interni
	 */

	private static String estraiLogin(Matcher matcher) {
		return matcher.group(2);
	}

}
