package com.acme.springbatch.intro.e09;

import org.springframework.batch.item.file.transform.LineAggregator;

public class LogAccessoLineAggregator implements LineAggregator<LogAccesso> {

	@Override
	public String aggregate(LogAccesso item) {
		StringBuilder sb = new StringBuilder();

		sb.append(item.dataAccesso);
		sb.append(",");
		sb.append(item.nome);
		sb.append(",");
		sb.append(item.login);
		sb.append(",");
		sb.append(item.isEsterno() ? "Esterno" : "Interno");

		return sb.toString();
	}

}
