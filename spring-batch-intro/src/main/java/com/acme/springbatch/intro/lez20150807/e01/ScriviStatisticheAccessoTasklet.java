package com.acme.springbatch.intro.lez20150807.e01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class ScriviStatisticheAccessoTasklet implements Tasklet {

	@SuppressWarnings("unchecked")
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		Map<String, Object> jobExecutionContext = chunkContext.getStepContext().getJobExecutionContext();

		Map<String, Integer> numeroAccessiPerUtenza = (Map<String, Integer>) jobExecutionContext
				.get("numero-accessi-per-utenza");

		stampaClassificaTop10(numeroAccessiPerUtenza);

		return null;
	}

	private void stampaClassificaTop10(Map<String, Integer> numeroAccessiPerUtenza) {
		List<AccessiUtente> classifica = new ArrayList<AccessiUtente>();
		for (Map.Entry<String, Integer> entry : numeroAccessiPerUtenza.entrySet()) {
			String login = entry.getKey();
			int numeroAccessi = entry.getValue();
			classifica.add(new AccessiUtente(login, numeroAccessi));
		}

		classifica.sort(new Comparator<AccessiUtente>() {

			@Override
			public int compare(AccessiUtente o1, AccessiUtente o2) {
				return o2.numeroAccessi - o1.numeroAccessi;
			}

		});

		System.out.println("TOP 10:");
		int i = 1;
		for (AccessiUtente item : classifica.subList(0, 10)) {
			System.out.printf("%2d)  utente %-8s  accessi %d\n", i++, item.login, item.numeroAccessi);
		}
	}

	private static class AccessiUtente {

		public final String login;
		public final int numeroAccessi;

		public AccessiUtente(String login, int numeroAccessi) {
			this.login = login;
			this.numeroAccessi = numeroAccessi;
		}

	}

}
