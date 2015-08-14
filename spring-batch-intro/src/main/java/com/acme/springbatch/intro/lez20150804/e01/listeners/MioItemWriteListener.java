package com.acme.springbatch.intro.lez20150804.e01.listeners;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;

public class MioItemWriteListener implements ItemWriteListener<String> {

	@Override
	public void beforeWrite(List<? extends String> items) {

		System.out.print("Sto per scrivere " + items + "... ");

	}

	@Override
	public void afterWrite(List<? extends String> items) {

		System.out.println("fatto");

	}

	@Override
	public void onWriteError(Exception e, List<? extends String> items) {

		System.err.println("Errore di scrittura [" + e + "]");

	}

}
