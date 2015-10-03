package com.gmail.volodymyrdosenko.vttcreater;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class T {

	public static void main(String[] args) {
		LocalTime t = LocalTime.parse("00:00:01.900");
		
		System.out.println(t.format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")));
		System.out.println(t.plus(100, ChronoUnit.MILLIS).format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")));

	}

}