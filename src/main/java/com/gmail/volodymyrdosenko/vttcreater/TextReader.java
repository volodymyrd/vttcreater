package com.gmail.volodymyrdosenko.vttcreater;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TextReader {

	private final int min = 100;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

	// private String text = "";
	private final File file;

	public TextReader(String fileName) throws FileNotFoundException {

		this.file = new File(fileName);

		if (!file.exists())
			throw new FileNotFoundException(fileName);
	}

	public void createVtt() throws IOException {
		LocalTime t = LocalTime.parse("00:00:00.000");

		StringBuilder sb = new StringBuilder("WEBVTT\n\n");
		// String s = "";
		int i = 0;
		int n = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				int l = line.length();
				i += l;
				if (line.trim().isEmpty()) {
					t = t.plus(l * min, ChronoUnit.MILLIS);

					continue;
				}

				if (n > 0)
					sb.append(n++ + "\n");
				else
					n++;

				String ts = t.format(formatter) + " --> ";
				t = t.plus(l * min, ChronoUnit.MILLIS);
				ts += t.format(formatter);
				sb.append(ts + "\n");
				sb.append(line + "\n\n");

			}
		}

		try (FileWriter fw = new FileWriter(file.getAbsolutePath() + ".vtt");) {
			fw.write(sb.toString());
		}
	}
}