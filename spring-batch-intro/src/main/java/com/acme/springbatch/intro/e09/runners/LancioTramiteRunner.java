package com.acme.springbatch.intro.e09.runners;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class LancioTramiteRunner {

	public static void main(String[] args) throws Exception {
		System.out.println("INIZIO");

		/*
		 * Lancia il batch
		 */
		CommandLineJobRunner.main(new String[] {
				"com/acme/springbatch/intro/e09/batch.xml", "mioJob" });

		System.out.println("FINE");
	}

}
