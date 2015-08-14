package com.acme.springbatch.intro.e10;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("INIZIO");

		CommandLineJobRunner.main(new String[] {
				"com/acme/springbatch/intro/e10/batch.xml", "mioJob",
				"chunk-size=5", "login-da-evidenziare=ars00005" });

		System.out.println("FINE");
	}
}
