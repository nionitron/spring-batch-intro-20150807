package com.acme.springbatch.intro.e09;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/acme/springbatch/intro/e09/batch.xml")
public class LogAccessoBatchTest {

	@Autowired
	private Job job;

	@Autowired
	private JobLauncher jobLauncher;

	@Value("file:${LogAccesso.output.file.path}")
	private Resource fileOutput;

	@Before
	public void setUp() throws IOException {
		System.out.println("Elimino il file di output [" + fileOutput + "]");

		fileOutput.getFile().delete();
	}

	@Test
	public void lanciaIlBatch() throws Exception {
		/*
		 * Lancia il batch
		 */
		jobLauncher.run(job, new JobParameters());

		assertTrue(fileOutput.exists());
	}

}
