package com.acme.springbatch.intro.e09.runners;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LancioTramiteContext {

	public static void main(String[] args) throws Exception {
		System.out.println("INIZIO");

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/acme/springbatch/intro/e09/batch.xml");

		Job job = applicationContext.getBean(Job.class);

		JobLauncher jobLauncher = applicationContext.getBean(JobLauncher.class);

		/*
		 * Lancia il batch
		 */
		jobLauncher.run(job, new JobParameters());

		applicationContext.close();

		System.out.println("FINE");
	}

}
