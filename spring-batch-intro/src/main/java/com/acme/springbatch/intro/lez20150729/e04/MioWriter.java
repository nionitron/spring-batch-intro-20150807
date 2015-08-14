package com.acme.springbatch.intro.lez20150729.e04;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class MioWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> items) throws Exception {
		System.out.println("Scrivo gli elementi " + items);
	}

}
