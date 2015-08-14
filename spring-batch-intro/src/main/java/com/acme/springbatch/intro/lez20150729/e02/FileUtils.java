package com.acme.springbatch.intro.lez20150729.e02;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.Resource;

public class FileUtils {

	private final Resource fileDiInput;

	public FileUtils(Resource fileDiInput) {
		this.fileDiInput = fileDiInput;
	}

	public int contaRighe() {
		try {
			return contaRighe(fileDiInput);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static int contaRighe(Resource resource) throws IOException {
		InputStream is = new BufferedInputStream(resource.getInputStream());
		try {
			int numeroRighe = 1;
			while (true) {
				switch (is.read()) {
				case '\n':
					numeroRighe++;
					continue;
				case -1:
					return numeroRighe;
				}
			}
		} finally {
			is.close();
		}
	}

}