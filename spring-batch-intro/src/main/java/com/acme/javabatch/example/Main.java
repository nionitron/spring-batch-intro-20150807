package com.acme.javabatch.example;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println("INIZIO");

		Batch batch = new Batch();
		batch.run();

		System.out.println("FINE");
	}

}
