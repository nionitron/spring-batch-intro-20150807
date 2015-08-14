package com.acme.springbatch.intro.lez20150804.e01;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class MioWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> items) throws Exception {
		faiOperazioneLunga();
	}

	private void faiOperazioneLunga() throws InterruptedException {
		Thread.sleep(1500L);
	}

}
