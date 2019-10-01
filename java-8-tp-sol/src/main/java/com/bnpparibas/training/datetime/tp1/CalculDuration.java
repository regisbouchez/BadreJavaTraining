package com.bnpparibas.training.datetime.tp1;

import java.time.Duration;
import java.time.Instant;

public class CalculDuration {

	public static void main(String[] args) throws InterruptedException {
		Instant start = Instant.now();
		Thread.sleep(10000);
		Instant end = Instant.now();
		System.out.println("Took : " + Duration.between(start, end).toMillis() / 1000 + " sec");
	}

}
