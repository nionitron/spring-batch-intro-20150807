package com.acme.springbatch.intro.lez20150807.e02;

import java.util.Scanner;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		System.out.println("INIZIO");

		System.out.println("Immettere chiave per la job-instance:");
		String chiave = new Scanner(System.in).nextLine();

		CommandLineJobRunner.main(new String[] { "com/acme/springbatch/intro/lez20150807/e02/batch.xml",
				"jobEsempioItemStreams", "chiave=" + chiave });

		System.out.println("FINE");
	}
}
