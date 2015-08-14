package com.acme.javabatch.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Batch {

	public void run() throws IOException {
		System.out.println("QUI IL BATCH ");

		File file = new File("files/javabatch.out");
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

		List<String> lines = FileUtils.readLines(new File(
				"files/arca4u.log.2015-05-18"));
		for (int i = 0; i < lines.size(); i++) {
			String rigaInElaborazione = lines.get(i);

			LogAccessoLineParser parser = new LogAccessoLineParser(
					rigaInElaborazione);

			if (parser.isRigaDiAccesso()) {

				bufferedWriter.write(parser.getDataAccesso());
				bufferedWriter.write(",");
				bufferedWriter.write(parser.getNome());
				bufferedWriter.write(",");
				bufferedWriter.write(parser.getLogin());
				bufferedWriter.write(",");
				bufferedWriter
						.write(parser.isEsterno() ? "Esterno" : "Interno");

				bufferedWriter.newLine();
			}
		}

		bufferedWriter.close();
	}

}
