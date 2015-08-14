package com.acme.springbatch.intro.lez20150804.e01.listeners;

import org.springframework.batch.core.ItemReadListener;

public class MioItemReadListener implements ItemReadListener<String> {

	@Override
	public void beforeRead() {

		System.out.print("Sto per leggere... ");

	}

	@Override
	public void afterRead(String item) {

		System.out.println("Ho letto [" + item + "]");

	}

	@Override
	public void onReadError(Exception e) {

		System.err.println("Errore di lettura [" + e + "]");

	}

}
