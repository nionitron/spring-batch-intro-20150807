package com.acme.springbatch.intro.lez20150807.e01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;

import com.acme.springbatch.intro.lez20150805.LogAccesso;

public class LogAccessoItemWriter implements ItemWriter<LogAccesso>, StepExecutionListener {

	private Map<String, Integer> numeroAccessiPerUtenza;
	private String ultimaDataAccesso;
	private ExecutionContext stepExecutionContext;
	private ExecutionContext jobExecutionContext;

	/*
	 * Metodi di ItemWriter
	 */

	@Override
	public void write(List<? extends LogAccesso> items) throws Exception {
		for (LogAccesso item : items) {
			incrementaContatoreAccesso(item.login);
			ultimaDataAccesso = item.dataAccesso;
		}
		stepExecutionContext.putString("ultima-data-accesso", ultimaDataAccesso);
	}

	/*
	 * Metodi di StepExecutionListener
	 */

	@Override
	public void beforeStep(StepExecution stepExecution) {
		stepExecutionContext = stepExecution.getExecutionContext();
		jobExecutionContext = stepExecution.getJobExecution().getExecutionContext();

		numeroAccessiPerUtenza = new HashMap<String, Integer>();
		ultimaDataAccesso = null;

		jobExecutionContext.put("numero-accessi-per-utenza", numeroAccessiPerUtenza);
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		return null;
	}

	/*
	 * Metodi interni
	 */

	private void incrementaContatoreAccesso(String login) {
		Integer contatore = numeroAccessiPerUtenza.get(login);
		numeroAccessiPerUtenza.put(login, contatore == null ? 1 : contatore + 1);
	}

}
