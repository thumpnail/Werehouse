package org.blackdownstudio.werehouse;

import java.io.*;
import java.lang.reflect.Field;

class Werehouse {

  public String filename;

  public Integer Brot;
  public Integer Medizin;
  public Integer Reifen;
  public Integer Gold;
  public Integer Kokain;
  public Integer Waffen;

  public Werehouse(String filename) throws IOException {
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

      System.out.println("Load " + filename);
      System.out.println("Were House : -> " + Brot + " / " + Medizin + " / " + Reifen + " / " + Gold + " / " + Kokain + " / " + Waffen);
    }
    br.close();

  }

  public void save() throws IOException {
    FileWriter fw = new FileWriter("C:/Users/nexus/workspace/workspace java/Werehouse2.0/" + filename);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write("Brot:\t\t" + Brot + "\n");
    bw.write("Medizin:\t" + Medizin + "\n");
    bw.write("Reifen:\t\t" + Reifen + "\n");
    bw.write("Gold:\t\t" + Gold + "\n");
    bw.write("Kokain:\t\t" + Kokain + "\n");
    bw.write("Waffen:\t\t" + Waffen + "\n");
                                             
    System.out.println("Save " + filename);
    System.out.println("Were House : -> " + Brot + " / " + Medizin + " / " + Reifen + " / " + Gold + " / " + Kokain + " / " + Waffen);

    bw.close();
  }
}
