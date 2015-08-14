package com.acme.springbatch.intro.lez20150804.e01.listeners;

import org.springframework.batch.core.ItemProcessListener;

public class MioItemProcessListener implements ItemProcessListener<String, String> {

	@Override
	public void beforeProcess(String item) {

		System.out.print("Sto per elaborare [" + item + "]... ");

	}

	@Override
	public void afterProcess(String item, String result) {

		System.out.println("Ho ottenuto [" + result + "]");

	}

	@Override
	public void onProcessError(String item, Exception e) {

		System.err.println("Errore di elaborazione [" + e + "]");

	}

}
