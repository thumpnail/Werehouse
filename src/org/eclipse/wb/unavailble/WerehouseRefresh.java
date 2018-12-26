package org.eclipse.wb.unavailble;

import java.io.*;

class WerehouseRefresh {
	
	public Integer Brot;
	public Integer Medizin;
	public Integer Reifen;
	public Integer Gold;
	public Integer Kokain;
	public Integer Waffen;
	

	public void WerehouseR(String filename) throws IOException {

		FileReader fr = new FileReader("E:/werehouse/" + filename);
		BufferedReader br = new BufferedReader(fr);
		String line;
		
		while ((line = br.readLine()) != null) {
			
			String[] parts = line.split(":");
			String name = parts[0].trim();
			Integer value = new Integer(parts[1].trim());
			
			if (name.equalsIgnoreCase("Brot")) {
				Brot = value;
			} else if (name.equalsIgnoreCase("Medizin")) {
				Medizin = value;
			} else if (name.equalsIgnoreCase("Reifen")) {
				Reifen = value;
			} else if (name.equalsIgnoreCase("Gold")) {
				Gold = value;
			} else if (name.equalsIgnoreCase("Kokain")) {
				Kokain = value;
			} else if (name.equalsIgnoreCase("Waffen")) {
				Waffen = value;
			} else {
				System.out.println("null");
			}
		}
		
	
		System.out.println("Were House : -> "+Brot+" / "+Medizin+" / "+Reifen+" / "+Gold+" / "+Kokain+" / "+Waffen);
		br.close();
	}
}
	