package com.acme.springbatch.intro.lez20150804.e01;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class MiaTasklet implements Tasklet {

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		faiOperazioneLunga();

		return null;
	}

	private void faiOperazioneLunga() throws InterruptedException {
		Thread.sleep(2000L);
	}

}
