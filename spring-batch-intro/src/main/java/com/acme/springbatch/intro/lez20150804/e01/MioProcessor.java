package com.acme.springbatch.intro.lez20150804.e01;

import org.springframework.batch.item.ItemProcessor;

public class MioProcessor implements ItemProcessor<String, String> {

	private static final String ALFABETO[] = { "Alfa", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel",
			"India", "Juliet", "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra",
			"Tango", "Uniform", "Victor", "Whiskey", "X-ray", "Yankee", "Zulu" };

	@Override
	public String process(String item) throws Exception {
		faiOperazioneLunga();

		return ALFABETO[item.charAt(0) - 'A'];
	}

	private void faiOperazioneLunga() throws InterruptedException {
		Thread.sleep(500L);
	}

}
