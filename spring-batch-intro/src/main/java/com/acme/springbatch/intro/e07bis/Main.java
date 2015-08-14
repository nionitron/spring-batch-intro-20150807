package com.acme.springbatch.intro.e07bis;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("INIZIO");

		CommandLineJobRunner.main(new String[] {
				"com/acme/springbatch/intro/e07bis/batch.xml", "mioJob" });

		System.out.println("FINE");
	}

}
