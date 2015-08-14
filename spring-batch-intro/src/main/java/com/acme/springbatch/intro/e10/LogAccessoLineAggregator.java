package com.acme.springbatch.intro.e10;

import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.beans.factory.annotation.Required;

public class LogAccessoLineAggregator implements LineAggregator<LogAccesso> {

	private String loginDaEvidenziare;

	@Required
	public void setLoginDaEvidenziare(String loginDaEvidenziare) {
		this.loginDaEvidenziare = loginDaEvidenziare;
	}

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

		if (item.login.equalsIgnoreCase(loginDaEvidenziare)) {
			sb.append(",X");
		}

		return sb.toString();
	}

}
