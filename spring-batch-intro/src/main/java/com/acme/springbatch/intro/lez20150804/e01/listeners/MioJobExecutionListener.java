package com.acme.springbatch.intro.lez20150804.e01.listeners;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class MioJobExecutionListener implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {

		String jobName = jobExecution.getJobInstance().getJobName();

		System.out.println("Il job [" + jobName + "] sta per iniziare");

	}

	@Override
	public void afterJob(JobExecution jobExecution) {

		String jobName = jobExecution.getJobInstance().getJobName();
		String exitCode = jobExecution.getExitStatus().getExitCode();

		System.out.println("Job [" + jobName + "] terminato con codice [" + exitCode + "]");

	}

}
