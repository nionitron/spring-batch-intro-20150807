package com.acme.springbatch.intro.lez20150807.e03;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("INIZIO");

		CommandLineJobRunner.main(
				new String[] { "com/acme/springbatch/intro/lez20150807/e03/batch.xml", "jobEsempioCompletionPolicy" });

		System.out.println("FINE");
	}
}
