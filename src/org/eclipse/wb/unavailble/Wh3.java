package org.eclipse.wb.unavailble;

import java.io.*;

class WH3 {
	public void werehouse3() throws IOException {
		
		FileReader fr = new FileReader("E:/werehouse/WH3.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String Brot3 = br.readLine();
		String Medizin3 = br.readLine();
		String Reifen3 = br.readLine();
		String Gold3 = br.readLine();
		String Kokain3 = br.readLine();
		String Waffen3 = br.readLine();
		
		System.out.println("Were House 3 : -> "+Brot3+" / "+Medizin3+" / "+Reifen3+" / "+Gold3+" / "+Kokain3+" / "+Waffen3);
		br.close();
	}
}