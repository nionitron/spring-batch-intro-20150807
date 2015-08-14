package com.acme.springbatch.intro.lez20150807.e01;

import java.util.Map;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;

public class MioChunkListener implements ChunkListener {

	@Override
	public void beforeChunk(ChunkContext context) {
		// Nulla da fare qui
	}

	@Override
	public void afterChunk(ChunkContext context) {
		int numeroChunk = context.getStepContext().getStepExecution().getCommitCount();

		Map<String, Object> stepExecutionContext = context.getStepContext().getStepExecutionContext();

		String ultimaDataAccesso = (String) stepExecutionContext.get("ultima-data-accesso");

		System.out.printf("Chunk %3d -- ultima data accesso elaborata: %s\n", numeroChunk, ultimaDataAccesso);
	}

	@Override
	public void afterChunkError(ChunkContext context) {
		// Nulla da fare qui
	}

}
