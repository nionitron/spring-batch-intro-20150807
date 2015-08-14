package com.acme.springbatch.intro.lez20150804.e04;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class TaskletRipetitiva implements Tasklet {

	private int numeroEsecuzioni = 0;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		numeroEsecuzioni++;
		System.out.println("Numero esecuzione: " + numeroEsecuzioni);

		faiOperazioneLunga();

		return numeroEsecuzioni < 10 ? RepeatStatus.CONTINUABLE : RepeatStatus.FINISHED;
	}

	private void faiOperazioneLunga() throws InterruptedException {
		Thread.sleep(250L);
	}

}
