package com.acme.springbatch.intro.e07bis;

import org.springframework.batch.item.ItemProcessor;

public class LogAccessoItemProcessor implements
		ItemProcessor<LogAccesso, LogAccesso> {

	@Override
	public LogAccesso process(LogAccesso item) throws Exception {
		if (item.valido) {
			return item;

		} else {

			/*
			 * Scarta la riga in elaborazione
			 */
			return null;
		}
	}

}
