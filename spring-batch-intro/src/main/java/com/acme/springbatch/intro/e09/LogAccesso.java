package com.acme.springbatch.intro.e09;

public class LogAccesso {

	public String dataAccesso;
	public String login;
	public String nome;

	public boolean isEsterno() {
		return login.startsWith("arx");
	}

}
