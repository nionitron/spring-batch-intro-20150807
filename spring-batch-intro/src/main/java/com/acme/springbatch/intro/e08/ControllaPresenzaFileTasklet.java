package com.acme.springbatch.intro.e08;

import java.io.FileNotFoundException;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.core.io.Resource;

public class ControllaPresenzaFileTasklet implements Tasklet {

	private Resource fileDaControllare;

	@Required
	public void setFileDaControllare(Resource fileDaControllare) {
		this.fileDaControllare = fileDaControllare;
	}

	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {

		System.out.println("Verifico la presenza del file ["
				+ fileDaControllare + "]...");

		if (!fileDaControllare.exists()) {
			throw new FileNotFoundException("Il file [" + fileDaControllare
					+ "] non è stato trovato!");

		} else {
			System.out.println("File trovato, il batch può proseguire.");
		}

		return null;
	}

}
