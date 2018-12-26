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

class WHGuiCraft {
	
	public JFrame frmWarehousesSell;
	public String from;
	public String product;
	public String amount;
	public Integer amountInt;
	public Integer Money1;
	public Integer price;
	

	public JFrame frmWarehousesCraft;
	public JTextField textFieldWH1Brot;

	/**
	 * Launch the application.
	 */
	public void CraftGui() throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WHGuiCraft CraftWindow = new WHGuiCraft();
					CraftWindow.frmWarehousesCraft.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WHGuiCraft() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmWarehousesCraft = new JFrame();
		frmWarehousesCraft.setType(Type.NORMAL);   
		frmWarehousesCraft.setTitle("Crafting Table");
		frmWarehousesCraft.setBounds(1100, 400, 175, 190);
		frmWarehousesCraft.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmWarehousesCraft.getContentPane().setLayout(null);
		frmWarehousesCraft.setAlwaysOnTop(true);
		
		JComboBox comboBoxAt = new JComboBox();
		comboBoxAt.setModel(new DefaultComboBoxModel(new String[] { "Werehouse 1", "Werehouse 2", "Werehouse 3" }));
		comboBoxAt.setBounds(10, 10, 149, 23);
		frmWarehousesCraft.getContentPane().add(comboBoxAt);

		JComboBox comboBoxProduct = new JComboBox();
		comboBoxProduct.setModel(new DefaultComboBoxModel(new String[] { "Brot", "Medizin", "Reifen", "Gold", "Kokain", "Waffen" }));
		comboBoxProduct.setBounds(10, 45, 149, 23);
		frmWarehousesCraft.getContentPane().add(comboBoxProduct);
		
		JComboBox comboBoxAmount = new JComboBox();
		comboBoxAmount.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "40", "50", "100" }));
		comboBoxAmount.setBounds(10, 80, 149, 23);
		frmWarehousesCraft.getContentPane().add(comboBoxAmount);
		
		JButton btnCraft_1 = new JButton("Craft");
		btnCraft_1.setBounds(10, 114, 65, 63);
		frmWarehousesCraft.getContentPane().add(btnCraft_1);
		btnCraft_1.addActionListener(new ActionListener() {
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
				
				from = (String)comboBoxAt.getSelectedItem();
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
				
				if (from == Werehouse1) {
					if (product == Brots) {
						ai = 11;
						
					} else if (product == Medizins) {
						ai = 12;
						
					} else if (product == Reifens) {
						ai = 13;
						
					} else if (product == Golds) {
						ai = 14;
						
					} else if (product == Kokains) {
						ai = 15;
						
					} else if (product == Waffens) {
						ai = 16;
						
					} else {System.out.println(e006);}
				} else if (from == Werehouse2) {
					if (product == Brots) {
						ai = 21;
						
					} else if (product == Medizins) {
						ai = 22;
						
					} else if (product == Reifens) {
						ai = 23;
						
					} else if (product == Golds) {
						ai = 24;
						
					} else if (product == Kokains) {
						ai = 25;
						
					} else if (product == Waffens) {
						ai = 26;
						
					} else {System.out.println(e006);}
				} else if (from == Werehouse3) {
					if (product == Brots) {
						ai = 31;
						
					} else if (product == Medizins) {
						ai = 32;
						
					} else if (product == Reifens) {
						ai = 33;
						
					} else if (product == Golds) {
						ai = 34;
						
					} else if (product == Kokains) {
						ai = 35;
						
					} else if (product == Waffens) {
						ai = 36;
						
					} else {System.out.println(e006);}
				} else {System.out.println(e006);}
				
				System.out.println("-----------------------------------------------");
				System.out.println("| "+amountInt+ " " + product + " Nach " + from);
				System.out.println("|" + " Money " + WHManager.stats1.Geld + "€");
				System.out.println("|" + " cost " + price);
				System.out.println("| ai code "+ ai);
				System.out.println("| to " + from);
				System.out.println("| product " + product);
				System.out.println("| amount " + amount);
				System.out.println("-----------------------------------------------");
				
				Integer priceInt = new Integer(price);
				
				int amountFinal;
				
				amountFinal = amountInt;
				
				try {
				
				if (ai == 11) {
					if (amountFinal <= Brot1) {
						System.out.println("In progress");
						
					} else if (amountFinal > Brot1) {
						System.out.println(e005);
					} else {System.out.println(e006);}
				} else if (ai == 12) {
					if (amountFinal <= Medizin1) {
						System.out.println("In progress");
						
					} else if (amountFinal > Medizin1) {
						System.out.println(e005);
					} else {System.out.println(e006);}
				} else if (ai == 13) {
					if (amountFinal <= Reifen1) {
						System.out.println("In progress");
						
					} else if (amountFinal > Reifen1) {
						System.out.println(e005);
					} else {System.out.println(e006);}
				} else if (ai == 14) {
					if (amountFinal <= Gold1) {
						System.out.println("In progress");
						
					} else if (amountFinal > Gold1) {
						System.out.println(e005);
					} else {System.out.println(e006);}
				} else if (ai == 15) {
					if (amountFinal <= Kokain1) {
						System.out.println("In progress");
						
					} else if (amountFinal > Kokain1) {
						System.out.println(e005);
					} else {System.out.println(e006);}
				} else if (ai == 16) {
					if (amountFinal <= Waffen1) {
						System.out.println("In progress");
						
					} else if (amountFinal > Brot1) {
						System.out.println(e005);
					} else {System.out.println(e006);}
				} else if (ai == 21) {
					if (amountFinal <= Brot2) {
						System.out.println("In progress");
						
					} else if (amountFinal > Brot2) {
						System.out.println(e005);
					} else {System.out.println(e006);}
				} else if (ai == 22) {
					if (amountFinal <= Medizin2) {
						System.out.println("In progress");
						
					} else if (amountFinal > Medizin2) {
						System.out.println(e005);
					} else {System.out.println(e006);}
				} else if (ai == 23) {
					if (amountFinal <= Reifen2) {
						System.out.println("In progress");
						
					} else if (amountFinal > Reifen2) {
						System.out.println(e005);
					} else {System.out.println(e006);}
				} else if (ai == 24) {
					if (amountFinal <= Gold2) {
						System.out.println("In progress");
						
					} else if (amountFinal > Gold2) {
						System.out.println(e005);
					} else {System.out.println(e006);}
				} else if (ai == 25) {
					if (amountFinal <= Kokain2) {
						System.out.println("In progress");
						
					} else if (amountFinal > Kokain2) {
						System.out.println(e005);
					} else {System.out.println(e006);}
				} else if (ai == 26) {
					if (amountFinal <= Waffen2) {
						System.out.println("In progress");
						
					} else if (amountFinal > Waffen2) {
						System.out.println(e005);
					} else {System.out.println(e006);}
				} else if (ai == 31) {
					if (amountFinal <= Brot3) {
						System.out.println("In progress");
						
					} else if (amountFinal > Brot3) {
						System.out.println(e005);
					} else {System.out.println(e006);}
				} else if (ai == 32) {
					if (amountFinal <= Medizin3) {
						System.out.println("In progress");
						
					} else if (amountFinal > Medizin3) {
						System.out.println(e005);
					} else {System.out.println(e006);}
				} else if (ai == 33) {
					if (amountFinal <= Reifen3) {
						System.out.println("In progress");
						
					} else if (amountFinal > Reifen3) {
						System.out.println(e005);
					} else {System.out.println(e006);}
				} else if (ai == 34) {
					if (amountFinal <= Gold3) {
						System.out.println("In progress");
						
					} else if (amountFinal > Gold3) {
						System.out.println(e005);
					} else {System.out.println(e006);}
				} else if (ai == 35) {
					if (amountFinal <= Kokain3) {
						System.out.println("In progress");
						
					} else if (amountFinal > Kokain3) {
						System.out.println(e005);
					} else {System.out.println(e006);}
				} else if (ai == 36) {
					if (amountFinal <= Waffen3) {
						System.out.println("In progress");
						
					} else if (amountFinal > Waffen3) {
						System.out.println(e005);
					} else {System.out.println(e006);}
				} else {
					System.out.println(e007);
				}
				
				WHManager.werehouse1.save();
				WHManager.werehouse2.save();
				WHManager.werehouse3.save();
				WHManager.stats1.save();
				
				} catch (Exception e1) {
					e1.printStackTrace();
					System.out.println(e007);
				}
			}
		});
		
	}	
}
