package com.acme.springbatch.intro.lez20150804.e01.listeners;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class MioStepExecutionListener implements StepExecutionListener {

	@Override
	public void beforeStep(StepExecution stepExecution) {

		String stepName = stepExecution.getStepName();

		System.out.println("Lo step [" + stepName + "] sta per iniziare");

	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {

		String stepName = stepExecution.getStepName();
		String exitCode = stepExecution.getExitStatus().getExitCode();

		System.out.println("Step [" + stepName + "] terminato con codice [" + exitCode + "]");

		/*-
		 * Ritorno null per non alterare l'exit status originale
		 */
		return null;
	}

}
