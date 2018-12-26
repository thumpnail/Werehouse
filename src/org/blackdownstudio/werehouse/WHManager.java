package org.blackdownstudio.werehouse;

import java.io.*;

public class WHManager {
  public static Werehouse werehouse1;
  public static Werehouse werehouse2;
  public static Werehouse werehouse3;
  public static Stats stats1;
  public static WHGui whGuiMain;
  public static WHGuiShop whGuiShop;
  public static WHGuiSell whGuiSell;
  public static WHGuiCraft whGuiCraft;
  
  public static void main(String[] args) throws IOException {
  
    werehouse1 = new Werehouse("WH1.txt");
    werehouse2 = new Werehouse("WH2.txt");
    werehouse3 = new Werehouse("WH3.txt");
    stats1 = new Stats("stats.txt");
    
    WHGui werehouseGui = new WHGui();
    werehouseGui.werehouseGui();
    
  }
}