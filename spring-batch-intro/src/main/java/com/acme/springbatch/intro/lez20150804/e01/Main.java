package com.acme.springbatch.intro.lez20150804.e01;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("INIZIO");

		CommandLineJobRunner
				.main(new String[] { "com/acme/springbatch/intro/lez20150804/e01/batch.xml", "jobEsempioListeners" });

		System.out.println("FINE");
	}

}
