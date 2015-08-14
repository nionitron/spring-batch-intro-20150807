package com.acme.springbatch.intro.lez20150804.e01.listeners;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;

public class MioChunkListener implements ChunkListener {

	@Override
	public void beforeChunk(ChunkContext context) {

		System.out.println("Inizia un nuovo chunk");

	}

	@Override
	public void afterChunk(ChunkContext context) {

		int commitCount = context.getStepContext().getStepExecution().getCommitCount();

		System.out.println("Chunk terminato correttamente (COMMIT " + commitCount + ")");
		System.out.println();

	}

	@Override
	public void afterChunkError(ChunkContext context) {

		System.out.println("Chunk terminato con errore (ROLLBACK)");
		System.out.println();

	}

}
