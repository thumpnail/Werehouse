package org.blackdownstudio.werehouse;

import java.awt.EventQueue;
import java.io.*;
import java.util.concurrent.BrokenBarrierException;
import java.lang.*;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.omg.CORBA.portable.ValueOutputStream;
import org.omg.Messaging.SyncScopeHelper;
import javax.swing.filechooser.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import java.awt.Component;
import java.awt.Choice;
import java.awt.TextField;
import java.awt.Canvas;
import java.awt.List;
import java.awt.Panel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.ScrollPane;
import java.awt.Window.Type;
import java.awt.color.CMMException;

class WHGuiShop {

	public JFrame frmWarehousesShop;
	public JTextField textFieldWH1Brot;
	public String to;
	public String product;
	public String amount;
	public Integer amountInt;
	public Integer Money1;
	
	public Integer price;

	/**
	 * Launch the application.
	 */
	public void ShopGui() throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WHGuiShop shopWindow = new WHGuiShop();
					shopWindow.frmWarehousesShop.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WHGuiShop() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void initialize() {
		
		frmWarehousesShop = new JFrame();
		frmWarehousesShop.setType(Type.NORMAL);
		frmWarehousesShop.setTitle("Shop");
		frmWarehousesShop.setBounds(325, 400, 175, 190);
		frmWarehousesShop.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmWarehousesShop.getContentPane().setLayout(null);
		frmWarehousesShop.setAlwaysOnTop(true);

		JComboBox comboBoxAt = new JComboBox();
		comboBoxAt.setModel(new DefaultComboBoxModel(new String[] { "Werehouse 1", "Werehouse 2", "Werehouse 3" }));
		comboBoxAt.setBounds(10, 10, 149, 23);
		frmWarehousesShop.getContentPane().add(comboBoxAt);

		JComboBox comboBoxProduct = new JComboBox();
		comboBoxProduct.setModel(new DefaultComboBoxModel(new String[] { "Brot", "Medizin", "Reifen", "Gold", "Kokain", "Waffen" }));
		comboBoxProduct.setBounds(10, 45, 149, 23);
		frmWarehousesShop.getContentPane().add(comboBoxProduct);
		
		JComboBox comboBoxAmount = new JComboBox();
		comboBoxAmount.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "40", "50", "100" }));
		comboBoxAmount.setBounds(10, 80, 149, 23);
		frmWarehousesShop.getContentPane().add(comboBoxAmount);
		
		JButton btnBuy_1 = new JButton("Buy");
		btnBuy_1.setBounds(10, 114, 65, 63);
		frmWarehousesShop.getContentPane().add(btnBuy_1);
		btnBuy_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//data base
				
				String Werehouse1 = "Werehouse 1";
				String Werehouse2 = "Werehouse 2";
				String Werehouse3 = "Werehouse 3";
				
				String Brots = "Brot";
				String Medizins = "Medizin";
				String Reifens = "Reifen";
				String Golds = "Gold";
				String Kokains = "Kokain";
				String Waffens = "Waffen";
				

				
				int Brot1 = WHManager.werehouse1.Brot;
				int Brot2 = WHManager.werehouse2.Brot;
				int Brot3 = WHManager.werehouse3.Brot;

				int Medizin1 = WHManager.werehouse1.Medizin;
				int Medizin2 = WHManager.werehouse2.Medizin;
				int Medizin3 = WHManager.werehouse3.Medizin;
				
				int Reifen1 = WHManager.werehouse1.Reifen;
				int Reifen2 = WHManager.werehouse2.Reifen;
				int Reifen3 = WHManager.werehouse3.Reifen;

				int Gold1 = WHManager.werehouse1.Gold;
				int Gold2 = WHManager.werehouse2.Gold;
				int Gold3 = WHManager.werehouse3.Gold;

				int Kokain1 = WHManager.werehouse1.Kokain;
				int Kokain2 = WHManager.werehouse2.Kokain;
				int Kokain3 = WHManager.werehouse3.Kokain;

				int Waffen1 = WHManager.werehouse1.Waffen;
				int Waffen2 = WHManager.werehouse2.Waffen;
				int Waffen3 = WHManager.werehouse3.Waffen;
				
	
				//get selected item
				
				to = (String)comboBoxAt.getSelectedItem();
				product = (String)comboBoxProduct.getSelectedItem();
				amount = (String)comboBoxAmount.getSelectedItem();
				
				//convert
				
				amountInt = new Integer(amount);
				
				//Error codes
				
				final String ANSI_Reset = "\u001B[0m";
				final String ANSI_BLACK = "\u001B[30m";
				final String ANSI_RED = "\u001B[31m";
				final String ANSI_GREEN = "\u001B[32m";
				final String ANSI_YELLOW = "\u001B[33m";
				final String ANSI_BLUE = "\u001B[34m";
				final String ANSI_PURPLE = "\u001B[35m";
				final String ANSI_CYAN = "\u001B[36m";
				final String ANSI_WHITE = "\u001B[37m";
				
				String e001 = ANSI_RED + "Error : e001 = vorgang abgebrochen" + ANSI_Reset; //keine datei übereinstimmung
				String e002 = ANSI_RED + "Error : e002 = vorgang abgebrochen" + ANSI_Reset; //keine datei übereinstimmung
				String e003 = ANSI_RED + "Error : e003 = vorgang abgebrochen" + ANSI_Reset; //keine datei übereinstimmung
				String e004 = ANSI_RED + "Inviled Enauncemend : e004 = vorgang abgebrochen" + ANSI_Reset; //falsche eingabe
				String e005 = ANSI_RED + "Storeg Error: e005 = vorgang abgebrochen" + ANSI_Reset; //werehouse lager problem
				String e006 = ANSI_RED + "FATAL ERROR : e006_1 = vorgang abgebrochen" + ANSI_Reset; //...
				String e007 = ANSI_RED + "Transfere uncomplet : e007 = fehler bei der ausführung" + ANSI_Reset;
				
				//Questions
				
				int ai = 0;
				
				if (to == Werehouse1) {
					if (product == Brots) {
						ai = 11;
						price = WHManager.stats1.Brot * amountInt;
					} else if (product == Medizins) {
						ai = 12;
						price = WHManager.stats1.Medizin * amountInt;
					} else if (product == Reifens) {
						ai = 13;
						price = WHManager.stats1.Reifen * amountInt;
					} else if (product == Golds) {
						ai = 14;
						price = WHManager.stats1.Gold * amountInt;
					} else if (product == Kokains) {
						ai = 15;
						price = WHManager.stats1.Kokain * amountInt;
					} else if (product == Waffens) {
						ai = 16;
						price = WHManager.stats1.Waffen * amountInt;
					} else {System.out.println(e006);}
				} else if (to == Werehouse2) {
					if (product == Brots) {
						ai = 21;
						price = WHManager.stats1.Brot * amountInt;
					} else if (product == Medizins) {
						ai = 22;
						price = WHManager.stats1.Medizin * amountInt;
					} else if (product == Reifens) {
						ai = 23;
						price = WHManager.stats1.Reifen * amountInt;
					} else if (product == Golds) {
						ai = 24;
						price = WHManager.stats1.Gold * amountInt;
					} else if (product == Kokains) {
						ai = 25;
						price = WHManager.stats1.Kokain * amountInt;
					} else if (product == Waffens) {
						ai = 26;
						price = WHManager.stats1.Waffen * amountInt;
					} else {System.out.println(e006);}
				} else if (to == Werehouse3) {
					if (product == Brots) {
						ai = 31;
						price = WHManager.stats1.Brot * amountInt;
					} else if (product == Medizins) {
						ai = 32;
						price = WHManager.stats1.Medizin * amountInt;
					} else if (product == Reifens) {
						ai = 33;
						price = WHManager.stats1.Reifen * amountInt;
					} else if (product == Golds) {
						ai = 34;
						price = WHManager.stats1.Gold * amountInt;
					} else if (product == Kokains) {
						ai = 35;
						price = WHManager.stats1.Kokain * amountInt;
					} else if (product == Waffens) {
						ai = 36;
						price = WHManager.stats1.Waffen * amountInt;
					} else {System.out.println(e006);}
				} else {System.out.println(e006);}
				
				System.out.println("-----------------------------------------------");
				System.out.println("| "+amountInt+ " " + product + " Nach " + to);
				System.out.println("|" + " Money " + WHManager.stats1.Geld + "€");
				System.out.println("|" + " cost " + price);
				System.out.println("| ai code "+ ai);
				System.out.println("| to " + to);
				System.out.println("| product " + product);
				System.out.println("| amount " + amount);
				System.out.println("-----------------------------------------------");
				
				Integer priceInt = new Integer(price);
				
				int amountFinal;
				
				amountFinal = amountInt;
				
				try {
				
				if (ai == 11) {
					WHManager.stats1.Geld -= priceInt;
					WHManager.werehouse1.Brot += amountFinal;
				} else if (ai == 12) {
					WHManager.stats1.Geld -= priceInt;
					WHManager.werehouse1.Medizin += amountFinal;
				} else if (ai == 13) {
					WHManager.stats1.Geld -= priceInt;
					WHManager.werehouse1.Reifen += amountFinal;
				} else if (ai == 14) {
					WHManager.stats1.Geld -= priceInt;
					WHManager.werehouse1.Gold += amountFinal;
				} else if (ai == 15) {
					WHManager.stats1.Geld -= priceInt;
					WHManager.werehouse1.Kokain += amountFinal;
				} else if (ai == 16) {
					WHManager.stats1.Geld -= priceInt;
					WHManager.werehouse1.Waffen += amountFinal;
				} else if (ai == 21) {
					WHManager.stats1.Geld -= priceInt;
					WHManager.werehouse2.Brot += amountFinal;
				} else if (ai == 22) {
					WHManager.stats1.Geld -= priceInt;
					WHManager.werehouse2.Medizin += amountFinal;
				} else if (ai == 23) {
					WHManager.stats1.Geld -= priceInt;
					WHManager.werehouse2.Reifen += amountFinal;
				} else if (ai == 24) {
					WHManager.stats1.Geld -= priceInt;
					WHManager.werehouse2.Gold += amountFinal;
				} else if (ai == 25) {
					WHManager.stats1.Geld -= priceInt;
					WHManager.werehouse2.Kokain += amountFinal;
				} else if (ai == 26) {
					WHManager.stats1.Geld -= priceInt;
					WHManager.werehouse2.Waffen += amountFinal;
				} else if (ai == 31) {
					WHManager.stats1.Geld -= priceInt;
					WHManager.werehouse3.Brot += amountFinal;
				} else if (ai == 32) {
					WHManager.stats1.Geld -= priceInt;
					WHManager.werehouse3.Medizin += amountFinal;
				} else if (ai == 33) {
					WHManager.stats1.Geld -= priceInt;
					WHManager.werehouse3.Reifen += amountFinal;
				} else if (ai == 34) {
					WHManager.stats1.Geld -= priceInt;
					WHManager.werehouse3.Gold += amountFinal;
				} else if (ai == 35) {
					WHManager.stats1.Geld -= priceInt;
					WHManager.werehouse3.Kokain += amountFinal;
				} else if (ai == 36) {
					WHManager.stats1.Geld -= priceInt;
					WHManager.werehouse3.Waffen += amountFinal;
				} else {
					System.out.println(e007);
				}
				
				WHManager.werehouse1.save();
				WHManager.werehouse2.save();
				WHManager.werehouse3.save();
				WHManager.stats1.save();
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnOK_2 = new JButton("Abort");
		btnOK_2.setBounds(94, 114, 75, 63);
		frmWarehousesShop.getContentPane().add(btnOK_2);
		
	}
}
