package com.acme.springbatch.intro.lez20150729.e02;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.core.io.Resource;

public class InputFilePartitioner implements Partitioner {

	private Resource fileDiInput;

	@Required
	public void setFileDiInput(Resource fileDiInput) {
		this.fileDiInput = fileDiInput;
	}

	@Override
	public Map<String, ExecutionContext> partition(int gridSize) {
		Map<String, ExecutionContext> result = new HashMap<String, ExecutionContext>();

		int numeroRigheFile = new FileUtils(fileDiInput).contaRighe();
		int numeroRighePerEsecutore = numeroRigheFile / gridSize;

		int daRiga = 0;

		for (int i = 0; i < gridSize; i++) {
			int aRiga = daRiga + numeroRighePerEsecutore;

			ExecutionContext stepExecutionContext = new ExecutionContext();
			result.put("partition-" + i, stepExecutionContext);
			stepExecutionContext.putInt("da-riga", daRiga);
			stepExecutionContext.putInt("a-riga", aRiga);
			stepExecutionContext.putString("file-output", "springbatch.out."
					+ i);

			System.out.printf("partition-%d:  da-riga=%6d  a-riga=%6d\n", i,
					daRiga, aRiga);

			daRiga = aRiga;
		}

		return result;
	}

}
