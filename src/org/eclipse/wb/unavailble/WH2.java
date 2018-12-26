package org.eclipse.wb.unavailble;

import java.io.*;

class WH2 {
	public void werehouse2() throws IOException {
		
		FileReader fr = new FileReader("E:/werehouse/WH2.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String Brot2 = br.readLine();
		String Medizin2 = br.readLine();
		String Reifen2 = br.readLine();
		String Gold2 = br.readLine();
		String Kokain2 = br.readLine();
		String Waffen2 = br.readLine();
		
		System.out.println("Were House 2 : -> "+Brot2+" / "+Medizin2+" / "+Reifen2+" / "+Gold2+" / "+Kokain2+" / "+Waffen2);
		br.close();
	}
}