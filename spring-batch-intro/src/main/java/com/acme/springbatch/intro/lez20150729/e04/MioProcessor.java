package com.acme.springbatch.intro.lez20150729.e04;

import java.util.Random;

import org.springframework.batch.item.ItemProcessor;

public class MioProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		faiOperazioneLunga();

		System.out.println("Ho elaborato l'elemento " + item);

		return item;
	}

	private void faiOperazioneLunga() throws InterruptedException {
		Thread.sleep(500L + new Random().nextInt(1000));
	}

}
