package com.acme.springbatch.intro.lez20150804.e02;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Required;

public class MioWriter implements ItemWriter<String> {

	private int numeroTentativi = 0;
	private int numeroMassimoFallimenti;

	@Required
	public void setNumeroMassimoFallimenti(int numeroMassimoFallimenti) {
		this.numeroMassimoFallimenti = numeroMassimoFallimenti;
	}

	@Override
	public void write(List<? extends String> items) throws Exception {
		faiOperazioneLungaEPericolosa(items);
		numeroTentativi = 0;
	}

	private void faiOperazioneLungaEPericolosa(List<? extends String> items) throws InterruptedException {
		Thread.sleep(1000L);

		if (items.contains("Whiskey") && ++numeroTentativi < numeroMassimoFallimenti) {
			throw new ErroreTemporaneoException("Non mi piace il Whiskey!");
		}
	}

}
