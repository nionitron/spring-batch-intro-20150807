package com.acme.springbatch.intro.lez20150807.e02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemWriter;

import com.acme.springbatch.intro.lez20150805.LogAccesso;

public class LogAccessoItemWriter implements ItemWriter<LogAccesso>, StepExecutionListener, ItemStream {

	private Map<String, Integer> numeroAccessiPerUtenza;
	private String ultimaDataAccesso;

	/*
	 * Metodi di ItemWriter
	 */

	@Override
	public void write(List<? extends LogAccesso> items) throws Exception {
		for (LogAccesso item : items) {
			incrementaContatoreAccesso(item.login);
			ultimaDataAccesso = item.dataAccesso;
		}

		System.out.println("write()");
	}

	/*
	 * Metodi di StepExecutionListener
	 */

	@Override
	public void beforeStep(StepExecution stepExecution) {
		// Nulla da fare qui
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		ExecutionContext jobExecutionContext = stepExecution.getJobExecution().getExecutionContext();

		jobExecutionContext.put("numero-accessi-per-utenza", numeroAccessiPerUtenza);

		return null;
	}

	/*
	 * Metodi di ItemStream
	 */

	@SuppressWarnings("unchecked")
	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		numeroAccessiPerUtenza = (Map<String, Integer>) executionContext.get("istogramma-parziale");
		if (numeroAccessiPerUtenza == null) {
			numeroAccessiPerUtenza = new HashMap<String, Integer>();
		}

		ultimaDataAccesso = executionContext.getString("ultima-data-accesso", null);

		System.out.println("open() ha caricato:");
		System.out.println("  ultimaDataAccesso = " + ultimaDataAccesso);
		System.out.println("  numeroAccessiPerUtenza = " + numeroAccessiPerUtenza);
	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		executionContext.put("istogramma-parziale", numeroAccessiPerUtenza);
		executionContext.putString("ultima-data-accesso", ultimaDataAccesso);

		System.out.println("update() ha salvato:");
		System.out.println("  ultimaDataAccesso = " + ultimaDataAccesso);
		System.out.println("  numeroAccessiPerUtenza = " + numeroAccessiPerUtenza);
	}

	@Override
	public void close() throws ItemStreamException {
		System.out.println("close()");
	}

	/*
	 * Metodi interni
	 */

	private void incrementaContatoreAccesso(String login) {
		Integer contatore = numeroAccessiPerUtenza.get(login);
		numeroAccessiPerUtenza.put(login, contatore == null ? 1 : contatore + 1);
	}

}
