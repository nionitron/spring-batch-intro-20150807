package com.acme.springbatch.intro.lez20150807.e03;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.acme.springbatch.intro.lez20150805.LogAccesso;

public class LogAccessoItemWriter implements ItemWriter<LogAccesso> {

	@Override
	public void write(List<? extends LogAccesso> items) throws Exception {
		System.out.println("write() " + items.size() + " accessi:");
		for (LogAccesso item : items) {
			System.out.printf("login=%-8s  dataAccesso=%s\n", item.login, item.dataAccesso);
		}
	}

}
