package com.acme.springbatch.intro.e07bis;

public class LogAccesso {

	public String dataAccesso;
	public String login;
	public String nome;
	public boolean valido;

	public boolean isEsterno() {
		return login.startsWith("arx");
	}

}
