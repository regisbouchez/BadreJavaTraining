package com.bnpparibas.training.datetime.tp3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeFormatterSample {

	public static void main(String[] args) {
		LocalDateTime example = LocalDateTime.now();

		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd MMMM , yyyy HH:mm:ss");
		System.out.println("Format 2: " + example.format(formatter2));

		DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		System.out.println("Format 1: " + example.format(formatter1));

	}

}
