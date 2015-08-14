package com.acme.springbatch.intro.lez20150729.e01;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class MostraMenuTasklet implements Tasklet {

	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {

		System.out.println("Voglio fare un gioco con te. Fai la tua scelta:");
		System.out.println(" - TESTA");
		System.out.println(" - CROCE");
		System.out.println(" - ERRORE");
		System.out.println(" - FINE");

		return null;
	}

}
