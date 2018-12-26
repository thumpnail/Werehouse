package org.blackdownstudio.werehouse;

import java.io.*;
import java.lang.reflect.Field;

class Stats {

	public String filename;

	public Integer Geld;
	public Integer Brot = 5;
	public Integer Medizin = 30;
	public Integer Reifen = 50;
	public Integer Gold = 25000;
	public Integer Kokain = 300;
	public Integer Waffen = 2000;

	public Stats(String filename) throws IOException {
		this.filename = filename;
		load();
	}

	public void load() throws IOException {
		FileReader fr = new FileReader("C:/Users/nexus/workspace/workspace java/Werehouse2.0/" + filename);
		BufferedReader br = new BufferedReader(fr);
		String line;

		while ((line = br.readLine()) != null) {

			String[] parts = line.split(":");
			String name = parts[0].trim();
			Integer value = new Integer(parts[1].trim());

			if (name.equalsIgnoreCase("Geld")) {
				Geld = value;
			} else {
				System.out.println("null");
			}

			System.out.println("Load " + filename);
			System.out.println("Stats geld : -> " + Geld + "€");
		}
		br.close();

	}

	public void save() throws IOException {
		FileWriter fw = new FileWriter("C:/Users/nexus/workspace/workspace java/Werehouse2.0/" + filename);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Geld:\t\t" + Geld + "\n");

		System.out.println("Save " + filename);
		System.out.println("Stats : -> " + Geld + "€");

		bw.close();
	}
}
