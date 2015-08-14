package com.acme.springbatch.intro.lez20150729.e01;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("INIZIO");

		CommandLineJobRunner.main(new String[] {
				"com/acme/springbatch/intro/lez20150729/e01/batch.xml",
				"jobEnigmista" });

		System.out.println("FINE");
	}

}
