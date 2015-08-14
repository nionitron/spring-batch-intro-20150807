package com.acme.springbatch.intro.lez20150805;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class Main {

	/*-
	 * login-da-filtrare=arx50031
	 * login-da-filtrare=arv00001
	 */

	public static void main(String[] args) throws Exception {
		System.out.println("INIZIO");

		String[] contextArgs = new String[] { "com/acme/springbatch/intro/lez20150805/batch.xml", "mioJob" };
		String[] allArgs = (String[]) ArrayUtils.addAll(contextArgs, args);

		CommandLineJobRunner.main(allArgs);

		System.out.println("FINE");
	}
}
