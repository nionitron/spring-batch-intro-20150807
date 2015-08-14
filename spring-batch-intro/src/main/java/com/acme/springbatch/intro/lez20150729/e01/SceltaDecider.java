package com.acme.springbatch.intro.lez20150729.e01;

import java.util.Scanner;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

public class SceltaDecider implements JobExecutionDecider {

	@Override
	public FlowExecutionStatus decide(JobExecution jobExecution,
			StepExecution stepExecution) {

		String scelta = faiDecidereAllUtente();

		return new FlowExecutionStatus(scelta);
	}

	@SuppressWarnings("resource")
	private String faiDecidereAllUtente() {
		return new Scanner(System.in).nextLine();
	}

}
