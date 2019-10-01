package com.bnpparibas.training.datetime.tp4;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

public class CalculDureeTravail {

	public static void main(String[] args) {
		LocalDateTime arriveMatin = LocalDateTime.of(2017, Month.APRIL, 27, 9, 29, 30);
		LocalDateTime departSoir = LocalDateTime.of(2017, Month.APRIL, 27, 18, 25, 24);

		Duration dureeGlobal = Duration.between(arriveMatin, departSoir);

		LocalDateTime debutDej = LocalDateTime.of(2017, Month.APRIL, 27, 12, 30, 30);
		LocalDateTime finDej = LocalDateTime.of(2017, Month.APRIL, 27, 13, 20, 14);

		Duration dureeDej = Duration.between(debutDej, finDej);
		Duration dureePause = Duration.ofMinutes(20);

		Duration dureeEffective = dureeGlobal.minus(dureeDej).minus(dureePause);

		System.out.println(dureeEffective);
	}
}
