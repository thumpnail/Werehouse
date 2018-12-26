package org.blackdownstudio.werehouse;

import java.awt.EventQueue;
import java.io.*;
import java.util.concurrent.BrokenBarrierException;
import java.lang.*;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.omg.CORBA.portable.ValueOutputStream;
import org.omg.Messaging.SyncScopeHelper;
import javax.swing.filechooser.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.*;

import java.awt.*;
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
import java.awt.color.*;

class WHGui {
	
	public String from;
	public String to;
	public String product;
	public String amount;
	public Integer amountInt;
	
	public Integer Brot;
	public Integer Medizin;
	public Integer Reifen;
	public Integer Gold;
	public Integer Kokain;
	public Integer Waffen;

	public Integer Money1;
	
	public JFrame frmWarehouses;
	public JTextField textFieldWH1Brot;

	/**
	 * Launch the application.
	 */
	public void werehouseGui() throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WHGui window = new WHGui();
					window.frmWarehouses.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WHGui() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmWarehouses = new JFrame();
		frmWarehouses.setType(Type.NORMAL);
		frmWarehouses.setTitle("Warehouses");
		frmWarehouses.setBounds(500, 400, 600, 408);
		frmWarehouses.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWarehouses.getContentPane().setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 300, 23);
		frmWarehouses.getContentPane().add(toolBar);

		JMenuBar menuBar = new JMenuBar();
		toolBar.add(menuBar);
		
		JMenu mnDatei = new JMenu("Datei");
		menuBar.add(mnDatei);
		
		JMenuItem mntmRefresh = new JMenuItem("ReRead");
		mnDatei.add(mntmRefresh);
		mntmRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(300, 11, 2, 222);
		frmWarehouses.getContentPane().add(panel);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(SystemColor.menu);
		panel2.setBounds(10, 244, 585, 2);
		frmWarehouses.getContentPane().add(panel2);

		
		//Combo boxes
		
		JComboBox comboBoxFrom = new JComboBox();
		comboBoxFrom.setModel(new DefaultComboBoxModel(new String[] { "Werehouse 1", "Werehouse 2", "Werehouse 3" }));
		comboBoxFrom.setBounds(10, 32, 149, 23);
		frmWarehouses.getContentPane().add(comboBoxFrom);
		
		JComboBox comboBoxTo = new JComboBox();
		comboBoxTo.setModel(new DefaultComboBoxModel(new String[] { "Werehouse 1", "Werehouse 2", "Werehouse 3" }));
		comboBoxTo.setBounds(10, 67, 149, 23);
		frmWarehouses.getContentPane().add(comboBoxTo);

		JComboBox comboBoxProduct = new JComboBox();
		comboBoxProduct.setModel(new DefaultComboBoxModel(new String[] { "Brot", "Medizin", "Reifen", "Gold", "Kokain", "Waffen" }));
		comboBoxProduct.setBounds(10, 102, 149, 23);
		frmWarehouses.getContentPane().add(comboBoxProduct);
		
		JComboBox comboBoxAmount = new JComboBox();
		comboBoxAmount.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "40", "50", "100" }));
		comboBoxAmount.setBounds(10, 136, 149, 23);
		frmWarehouses.getContentPane().add(comboBoxAmount);
		
		
		//left side
		
		JTextPane txtpnWichWerehouse = new JTextPane();
		txtpnWichWerehouse.setText("from");
		txtpnWichWerehouse.setEditable(false);
		txtpnWichWerehouse.setBackground(SystemColor.menu);
		txtpnWichWerehouse.setBounds(169, 34, 116, 23);
		frmWarehouses.getContentPane().add(txtpnWichWerehouse);

		JTextPane txtpnWichWerehouse_1 = new JTextPane();
		txtpnWichWerehouse_1.setText("to");
		txtpnWichWerehouse_1.setEditable(false);
		txtpnWichWerehouse_1.setBackground(SystemColor.menu);
		txtpnWichWerehouse_1.setBounds(169, 68, 116, 23);
		frmWarehouses.getContentPane().add(txtpnWichWerehouse_1);

		JTextPane txtpnWichProduct = new JTextPane();
		txtpnWichProduct.setText("wich Product");
		txtpnWichProduct.setEditable(false);
		txtpnWichProduct.setBackground(SystemColor.menu);
		txtpnWichProduct.setBounds(169, 102, 116, 23);
		frmWarehouses.getContentPane().add(txtpnWichProduct);

		JTextPane txtpnAmount = new JTextPane();
		txtpnAmount.setText("amount");
		txtpnAmount.setEditable(false);
		txtpnAmount.setBackground(SystemColor.menu);
		txtpnAmount.setBounds(169, 136, 116, 23);
		frmWarehouses.getContentPane().add(txtpnAmount);

		//Right side
		
		JTextPane txtpnBrot = new JTextPane();
		txtpnBrot.setEditable(false);
		txtpnBrot.setText("Brot");
		txtpnBrot.setBackground(SystemColor.menu);
		txtpnBrot.setBounds(318, 34, 61, 23);
		frmWarehouses.getContentPane().add(txtpnBrot);

		JTextPane txtpnMedizin = new JTextPane();
		txtpnMedizin.setEditable(false);
		txtpnMedizin.setText("Medizin");
		txtpnMedizin.setBackground(SystemColor.menu);
		txtpnMedizin.setBounds(318, 68, 61, 23);
		frmWarehouses.getContentPane().add(txtpnMedizin);

		JTextPane txtpnReifen = new JTextPane();
		txtpnReifen.setEditable(false);
		txtpnReifen.setText("Reifen");
		txtpnReifen.setBackground(SystemColor.menu);
		txtpnReifen.setBounds(318, 102, 61, 23);
		frmWarehouses.getContentPane().add(txtpnReifen);

		JTextPane txtpnGold = new JTextPane();
		txtpnGold.setEditable(false);
		txtpnGold.setText("Gold");
		txtpnGold.setBackground(SystemColor.menu);
		txtpnGold.setBounds(318, 136, 61, 23);
		frmWarehouses.getContentPane().add(txtpnGold);

		JTextPane txtpnKokain = new JTextPane();
		txtpnKokain.setEditable(false);
		txtpnKokain.setText("Kokain");
		txtpnKokain.setBackground(SystemColor.menu);
		txtpnKokain.setBounds(318, 170, 61, 23);
		frmWarehouses.getContentPane().add(txtpnKokain);

		JTextPane txtpnWaffen = new JTextPane();
		txtpnWaffen.setEditable(false);
		txtpnWaffen.setText("Waffen");
		txtpnWaffen.setBackground(SystemColor.menu);
		txtpnWaffen.setBounds(318, 204, 61, 23);
		frmWarehouses.getContentPane().add(txtpnWaffen);

		JTextPane txtpnWh_2 = new JTextPane();
		txtpnWh_2.setText("WH1");
		txtpnWh_2.setEditable(false);
		txtpnWh_2.setBackground(SystemColor.menu);
		txtpnWh_2.setBounds(389, 1, 61, 23);
		frmWarehouses.getContentPane().add(txtpnWh_2);
			
		JTextPane txtpnWh = new JTextPane();
		txtpnWh.setBackground(SystemColor.menu);
		txtpnWh.setText("WH2");
		txtpnWh.setEditable(false);
		txtpnWh.setBounds(460, 1, 61, 23);
		frmWarehouses.getContentPane().add(txtpnWh);

		JTextPane txtpnWh_1 = new JTextPane();
		txtpnWh_1.setBackground(SystemColor.menu);
		txtpnWh_1.setText("WH3");
		txtpnWh_1.setEditable(false);
		txtpnWh_1.setBounds(531, 1, 61, 23);
		frmWarehouses.getContentPane().add(txtpnWh_1);
		
		JTextPane txtpnMoney_1 = new JTextPane();
		txtpnMoney_1.setText("");
		txtpnMoney_1.setEditable(false);
		txtpnMoney_1.setBackground(SystemColor.menu);
		txtpnMoney_1.setBounds(318, 1, 61, 23);
		frmWarehouses.getContentPane().add(txtpnMoney_1);

		//give out
		
		JTextPane txtpnWH1Brot = new JTextPane();
		txtpnWH1Brot.setText(" ");
		txtpnWH1Brot.setEditable(false);
		txtpnWH1Brot.setBackground(SystemColor.menu);
		txtpnWH1Brot.setBounds(389, 34, 61, 23);
		frmWarehouses.getContentPane().add(txtpnWH1Brot);

		JTextPane txtpnWH1Medi = new JTextPane();
		txtpnWH1Medi.setEditable(false);
		txtpnWH1Medi.setBackground(SystemColor.menu);
		txtpnWH1Medi.setBounds(389, 68, 61, 23);
		frmWarehouses.getContentPane().add(txtpnWH1Medi);

		JTextPane txtpnWH1Reifen = new JTextPane();
		txtpnWH1Reifen.setEditable(false);
		txtpnWH1Reifen.setBackground(SystemColor.menu);
		txtpnWH1Reifen.setBounds(389, 102, 61, 23);
		frmWarehouses.getContentPane().add(txtpnWH1Reifen);

		JTextPane txtpnWH1Gold = new JTextPane();
		txtpnWH1Gold.setEditable(false);
		txtpnWH1Gold.setBackground(SystemColor.menu);
		txtpnWH1Gold.setBounds(389, 136, 61, 23);
		frmWarehouses.getContentPane().add(txtpnWH1Gold);

		JTextPane txtpnWH1Kokain = new JTextPane();
		txtpnWH1Kokain.setEditable(false);
		txtpnWH1Kokain.setBackground(SystemColor.menu);
		txtpnWH1Kokain.setBounds(389, 170, 61, 23);
		frmWarehouses.getContentPane().add(txtpnWH1Kokain);

		JTextPane txtpnWH1Waffen = new JTextPane();
		txtpnWH1Waffen.setEditable(false);
		txtpnWH1Waffen.setBackground(SystemColor.menu);
		txtpnWH1Waffen.setBounds(389, 204, 61, 23);
		frmWarehouses.getContentPane().add(txtpnWH1Waffen);

		JTextPane txtpnWH2Brot = new JTextPane();
		txtpnWH2Brot.setEditable(false);
		txtpnWH2Brot.setBackground(SystemColor.menu);
		txtpnWH2Brot.setBounds(460, 34, 61, 23);
		frmWarehouses.getContentPane().add(txtpnWH2Brot);

		JTextPane txtpnWH2Medi = new JTextPane();
		txtpnWH2Medi.setEditable(false);
		txtpnWH2Medi.setBackground(SystemColor.menu);
		txtpnWH2Medi.setBounds(460, 68, 61, 23);
		frmWarehouses.getContentPane().add(txtpnWH2Medi);

		JTextPane txtpnWH2Reifen = new JTextPane();
		txtpnWH2Reifen.setEditable(false);
		txtpnWH2Reifen.setBackground(SystemColor.menu);
		txtpnWH2Reifen.setBounds(460, 102, 61, 23);
		frmWarehouses.getContentPane().add(txtpnWH2Reifen);

		JTextPane txtpnWH2Gold = new JTextPane();
		txtpnWH2Gold.setEditable(false);
		txtpnWH2Gold.setBackground(SystemColor.menu);
		txtpnWH2Gold.setBounds(460, 136, 61, 23);
		frmWarehouses.getContentPane().add(txtpnWH2Gold);

		JTextPane txtpnWH2Kokain = new JTextPane();
		txtpnWH2Kokain.setEditable(false);
		txtpnWH2Kokain.setBackground(SystemColor.menu);
		txtpnWH2Kokain.setBounds(460, 170, 61, 23);
		frmWarehouses.getContentPane().add(txtpnWH2Kokain);

		JTextPane txtpnWH2Waffen = new JTextPane();
		txtpnWH2Waffen.setEditable(false);
		txtpnWH2Waffen.setBackground(SystemColor.menu);
		txtpnWH2Waffen.setBounds(460, 204, 61, 23);
		frmWarehouses.getContentPane().add(txtpnWH2Waffen);

		JTextPane txtpnWH3Brot = new JTextPane();
		txtpnWH3Brot.setEditable(false);
		txtpnWH3Brot.setBackground(SystemColor.menu);
		txtpnWH3Brot.setBounds(531, 34, 61, 23);
		frmWarehouses.getContentPane().add(txtpnWH3Brot);

		JTextPane txtpnWH3Medi = new JTextPane();
		txtpnWH3Medi.setEditable(false);
		txtpnWH3Medi.setBackground(SystemColor.menu);
		txtpnWH3Medi.setBounds(531, 68, 61, 23);
		frmWarehouses.getContentPane().add(txtpnWH3Medi);

		JTextPane txtpnWh3Reifen = new JTextPane();
		txtpnWh3Reifen.setEditable(false);
		txtpnWh3Reifen.setBackground(SystemColor.menu);
		txtpnWh3Reifen.setBounds(531, 102, 61, 23);
		frmWarehouses.getContentPane().add(txtpnWh3Reifen);

		JTextPane txtpnWH3Gold = new JTextPane();
		txtpnWH3Gold.setEditable(false);
		txtpnWH3Gold.setBackground(SystemColor.menu);
		txtpnWH3Gold.setBounds(531, 136, 61, 23);
		frmWarehouses.getContentPane().add(txtpnWH3Gold);

		JTextPane txtpnWH3Kokain = new JTextPane();
		txtpnWH3Kokain.setEditable(false);
		txtpnWH3Kokain.setBackground(SystemColor.menu);
		txtpnWH3Kokain.setBounds(531, 170, 61, 23);
		frmWarehouses.getContentPane().add(txtpnWH3Kokain);

		JTextPane txtpnWH3Waffen = new JTextPane();
		txtpnWH3Waffen.setEditable(false);
		txtpnWH3Waffen.setBackground(SystemColor.menu);
		txtpnWH3Waffen.setBounds(531, 204, 61, 23);
		frmWarehouses.getContentPane().add(txtpnWH3Waffen);

		JButton btnSellButton = new JButton("Sell");
		btnSellButton.setBounds(10, 355, 149, 43);
		frmWarehouses.getContentPane().add(btnSellButton);		
		btnSellButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			WHGuiSell SellGui = new WHGuiSell();
			try {
				SellGui.SellGui();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	});
		
		JButton btnCraftButton = new JButton("Crafting Table");
		btnCraftButton.setBounds(10, 305, 149, 43);
		frmWarehouses.getContentPane().add(btnCraftButton);		
		btnCraftButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			WHGuiCraft CraftGui = new WHGuiCraft();
			try {
				CraftGui.CraftGui();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	});
		
		JButton btnShopButton = new JButton("Shop");
		btnShopButton.setBounds(10, 255, 149, 43);
		frmWarehouses.getContentPane().add(btnShopButton);		
		btnShopButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			WHGuiShop ShopGui = new WHGuiShop();
			try {
				ShopGui.ShopGui();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	});
		
		
		//go button
		
		JButton btnGoButton = new JButton("go!");
		btnGoButton.setBounds(169, 170, 80, 63);
		frmWarehouses.getContentPane().add(btnGoButton);		
		btnGoButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
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
			
			from = (String)comboBoxFrom.getSelectedItem();
			to = (String)comboBoxTo.getSelectedItem();
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
			
			if (from == Werehouse1){	
						if (to == Werehouse2) {
									if (product == Brots) {
										txtpnWH1Brot.setBackground(SystemColor.RED);
										txtpnWH2Brot.setBackground(SystemColor.GREEN);
										ai = 121;
									} else if (product == Medizins) {
										txtpnWH1Medi.setBackground(SystemColor.RED);
										txtpnWH2Medi.setBackground(SystemColor.GREEN);
										ai = 122;
									} else if (product == Reifens) {
										txtpnWH1Reifen.setBackground(SystemColor.RED);
										txtpnWH2Reifen.setBackground(SystemColor.GREEN);
										ai = 123;
									} else if (product == Golds) {
										txtpnWH1Gold.setBackground(SystemColor.RED);
										txtpnWH2Gold.setBackground(SystemColor.GREEN);
										ai = 124;
									} else if (product == Kokains) {
										txtpnWH1Kokain.setBackground(SystemColor.RED);
										txtpnWH2Kokain.setBackground(SystemColor.GREEN);
										ai = 125;
									} else if (product == Waffens) {
										txtpnWH1Waffen.setBackground(SystemColor.RED);
										txtpnWH2Waffen.setBackground(SystemColor.GREEN);
										ai = 126;
									} else {System.out.println(e003);}
						} else if (to == Werehouse3) {
									if (product == Brots) {
										txtpnWH1Brot.setBackground(SystemColor.RED);
										txtpnWH3Brot.setBackground(SystemColor.GREEN);
										ai = 131;
									} else if (product == Medizins) {
										txtpnWH1Medi.setBackground(SystemColor.RED);
										txtpnWH3Medi.setBackground(SystemColor.GREEN);
										ai = 132;
									} else if (product == Reifens) {
										txtpnWH1Reifen.setBackground(SystemColor.RED);
										txtpnWh3Reifen.setBackground(SystemColor.GREEN);
										ai = 133;
									} else if (product == Golds) {
										txtpnWH1Gold.setBackground(SystemColor.RED);
										txtpnWH3Gold.setBackground(SystemColor.GREEN);
										ai = 134;
									} else if (product == Kokains) {
										txtpnWH1Kokain.setBackground(SystemColor.RED);
										txtpnWH3Kokain.setBackground(SystemColor.GREEN);
										ai = 135;
									} else if (product == Waffens) {
										txtpnWH1Waffen.setBackground(SystemColor.RED);
										txtpnWH3Waffen.setBackground(SystemColor.GREEN);
										ai = 136;
									} else {System.out.println(e003);}
									} else if (to == Werehouse1) {System.out.println(e004);
						} else {System.out.println(e002);}
			} else if (from == Werehouse2) {
						if (to == Werehouse1) {
									if (product == Brots) {
										txtpnWH2Brot.setBackground(SystemColor.RED);
										txtpnWH1Brot.setBackground(SystemColor.GREEN);
										ai = 211;
									} else if (product == Medizins) {
										txtpnWH2Medi.setBackground(SystemColor.RED);
										txtpnWH1Medi.setBackground(SystemColor.GREEN);
										ai = 212;
									} else if (product == Reifens) {
										txtpnWH2Reifen.setBackground(SystemColor.RED);
										txtpnWH1Reifen.setBackground(SystemColor.GREEN);
										ai = 213;
									} else if (product == Golds) {
										txtpnWH2Gold.setBackground(SystemColor.RED);
										txtpnWH1Gold.setBackground(SystemColor.GREEN);
										ai = 214;
									} else if (product == Kokains) {
										txtpnWH2Kokain.setBackground(SystemColor.RED);
										txtpnWH1Kokain.setBackground(SystemColor.GREEN);
										ai = 215;
									} else if (product == Waffens) {
										txtpnWH2Waffen.setBackground(SystemColor.RED);
										txtpnWH1Waffen.setBackground(SystemColor.GREEN);
										ai = 216;
									} else {System.out.println(e003);}
						} else if (to == Werehouse3) {
									if (product == Brots) {
										txtpnWH2Brot.setBackground(SystemColor.RED);
										txtpnWH3Brot.setBackground(SystemColor.GREEN);
										ai = 231;
									} else if (product == Medizins) {
										txtpnWH2Medi.setBackground(SystemColor.RED);
										txtpnWH3Medi.setBackground(SystemColor.GREEN);
										ai = 232;
									} else if (product == Reifens) {
										txtpnWH2Reifen.setBackground(SystemColor.RED);
										txtpnWh3Reifen.setBackground(SystemColor.GREEN);
										ai = 233;
									} else if (product == Golds) {
										txtpnWH2Gold.setBackground(SystemColor.RED);
										txtpnWH3Gold.setBackground(SystemColor.GREEN);
										ai = 234;
									} else if (product == Kokains) {
										txtpnWH2Kokain.setBackground(SystemColor.RED);
										txtpnWH3Kokain.setBackground(SystemColor.GREEN);
										ai = 235;
									} else if (product == Waffens) {
										txtpnWH2Waffen.setBackground(SystemColor.RED);
										txtpnWH3Waffen.setBackground(SystemColor.GREEN);
										ai = 236;
									} else {System.out.println(e003);}
						} else if (to == Werehouse2){System.out.println(e004);
						} else {System.out.println(e002);}
			} else if (from == Werehouse3) {
						if (to == Werehouse1) {
									if (product == Brots) {
										txtpnWH3Brot.setBackground(SystemColor.RED);
										txtpnWH1Brot.setBackground(SystemColor.GREEN);
										ai = 311;
									} else if (product == Medizins) {
										txtpnWH3Medi.setBackground(SystemColor.RED);
										txtpnWH1Medi.setBackground(SystemColor.GREEN);
										ai = 312;
									} else if (product == Reifens) {
										txtpnWh3Reifen.setBackground(SystemColor.RED);
										txtpnWH1Reifen.setBackground(SystemColor.GREEN);
										ai = 313;
									} else if (product == Golds) {
										txtpnWH3Gold.setBackground(SystemColor.RED);
										txtpnWH1Gold.setBackground(SystemColor.GREEN);
										ai = 314;
									} else if (product == Kokains) {
										txtpnWH3Kokain.setBackground(SystemColor.RED);
										txtpnWH1Kokain.setBackground(SystemColor.GREEN);
										ai = 315;
									} else if (product == Waffens) {
										txtpnWH3Waffen.setBackground(SystemColor.RED);
										txtpnWH1Waffen.setBackground(SystemColor.GREEN);
										ai = 316;
									} else {System.out.println(e003);}
						} else if (to == Werehouse2) {
									if (product == Brots) {
										txtpnWH3Brot.setBackground(SystemColor.RED);
										txtpnWH2Brot.setBackground(SystemColor.GREEN);
										ai = 321;
									} else if (product == Medizins) {
										txtpnWH3Medi.setBackground(SystemColor.RED);
										txtpnWH2Medi.setBackground(SystemColor.GREEN);
										ai = 322;
									} else if (product == Reifens) {
										txtpnWh3Reifen.setBackground(SystemColor.RED);
										txtpnWH2Reifen.setBackground(SystemColor.GREEN);
										ai = 323;
									} else if (product == Golds) {
										txtpnWH3Gold.setBackground(SystemColor.RED);
										txtpnWH2Gold.setBackground(SystemColor.GREEN);
										ai = 324;
									} else if (product == Kokains) {
										txtpnWH3Kokain.setBackground(SystemColor.RED);
										txtpnWH2Kokain.setBackground(SystemColor.GREEN);
										ai = 325;
									} else if (product == Waffens) {
										txtpnWH3Waffen.setBackground(SystemColor.RED);
										txtpnWH2Waffen.setBackground(SystemColor.GREEN);
										ai = 326;
									} else {System.out.println(e003);}
						} else if (to == Werehouse3) {System.out.println(e004);
						} else {System.out.println(e002);}
			} else {System.out.println(e001);}
			
			
			System.out.println("-----------------------------------------------");
			System.out.println("| "+amountInt+" "+product+" Von "+ from +" Nach "+to);
			System.out.println("|");
			System.out.println("| ai code "+ ai);
			System.out.println("| from " + from);
			System.out.println("| to " + to);
			System.out.println("| product " + product);
			System.out.println("| amount " + amount);
			System.out.println("-----------------------------------------------");
			
			
			int amountFinal;
			
			amountFinal = amountInt;
			
			if (ai == 121) {
					if (amountFinal <= Brot1) {
						System.out.println("In progress");
						WHManager.werehouse1.Brot = WHManager.werehouse1.Brot - amountFinal;
						WHManager.werehouse2.Brot = WHManager.werehouse2.Brot + amountFinal;
					} else if (amountFinal > Brot1) {
						System.out.println(e005);
					} else {System.out.println(e006);}
			} else if (ai == 122) {				
					if (amountFinal <= Medizin1) {
						System.out.println("In progress");
						WHManager.werehouse1.Medizin = WHManager.werehouse1.Medizin - amountFinal;
						WHManager.werehouse2.Medizin = WHManager.werehouse2.Medizin + amountFinal;
					} else if (amountFinal > Medizin1) {
						System.out.println(e005);
					} else {System.out.println(e006);}
			} else if (ai == 123) {
					if (amountFinal <= Reifen1) {
						System.out.println("In progress");
						WHManager.werehouse1.Reifen = WHManager.werehouse1.Reifen - amountFinal;
						WHManager.werehouse2.Reifen = WHManager.werehouse2.Reifen + amountFinal;
					} else if (amountFinal > Reifen1) {
						System.out.println(e005);
					} else {System.out.println(e006);}
			} else if (ai == 124) {
					if (amountFinal <= Gold1) {
						System.out.println("In progress");
						WHManager.werehouse1.Gold = WHManager.werehouse1.Gold - amountFinal;
						WHManager.werehouse2.Gold = WHManager.werehouse2.Gold + amountFinal;
					} else if (amountFinal > Gold1) {
						System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 125) {
					if (amountFinal <= Kokain1) {
						System.out.println("In progress");
						WHManager.werehouse1.Kokain = WHManager.werehouse1.Kokain - amountFinal;
						WHManager.werehouse2.Kokain = WHManager.werehouse2.Kokain + amountFinal;
					} else if (amountFinal > Kokain1) {
						System.out.println(e005);
					} else {System.out.println(e006);}
			} else if (ai == 126) {
					if (amountFinal <= Waffen1) {
						System.out.println("In progress");
						WHManager.werehouse1.Waffen = WHManager.werehouse1.Waffen - amountFinal;
						WHManager.werehouse2.Waffen = WHManager.werehouse2.Waffen + amountFinal;
					} else if (amountFinal > Waffen1) {
						System.out.println(e005);
					} else {System.out.println(e006);}
			} else if (ai == 131) {
					if (amountFinal <= Brot1) {
						System.out.println("In progress");
						WHManager.werehouse1.Brot = WHManager.werehouse1.Brot - amountFinal;
						WHManager.werehouse3.Brot = WHManager.werehouse3.Brot + amountFinal;
					} else if (amountFinal > Brot1) {
						System.out.println(e005);
					} else {System.out.println(e006);}
			} else if (ai == 132) {
					if (amountFinal <= Medizin1) {
						System.out.println("In progress");
						WHManager.werehouse1.Medizin = WHManager.werehouse1.Medizin - amountFinal;
						WHManager.werehouse3.Medizin = WHManager.werehouse3.Medizin + amountFinal;
					} else if (amountFinal > Medizin1) {
						System.out.println(e005);
					} else {System.out.println(e006);}
			} else if (ai == 133) {
					if (amountFinal <= Reifen1) {
						System.out.println("In progress");
						WHManager.werehouse1.Reifen = WHManager.werehouse1.Reifen - amountFinal;
						WHManager.werehouse3.Reifen = WHManager.werehouse3.Reifen + amountFinal;
					} else if (amountFinal > Reifen1) {
						System.out.println(e005);
					} else {System.out.println(e006);}
			} else if (ai == 134) {
					if (amountFinal <= Gold1) {
						System.out.println("In progress");
						WHManager.werehouse1.Gold = WHManager.werehouse1.Gold - amountFinal;
						WHManager.werehouse3.Gold = WHManager.werehouse3.Gold + amountFinal;
					} else if (amountFinal > Gold1) {
						System.out.println(e005);
					} else {System.out.println(e006);}
			} else if (ai == 135) {
					if (amountFinal <= Kokain1) {
						System.out.println("In progress");
						WHManager.werehouse1.Kokain = WHManager.werehouse1.Kokain - amountFinal;
						WHManager.werehouse3.Kokain = WHManager.werehouse3.Kokain + amountFinal;
					} else if (amountFinal > Kokain1) {
						System.out.println(e005);
					} else {System.out.println(e006);}
			} else if (ai == 136) {
					if (amountFinal <= Waffen1) {
						System.out.println("In progress");
						WHManager.werehouse1.Waffen = WHManager.werehouse1.Waffen - amountFinal;
						WHManager.werehouse3.Waffen = WHManager.werehouse3.Waffen + amountFinal;
					} else if (amountFinal > Waffen1) {
						System.out.println(e005);
					} else {System.out.println(e006);}
			} else if (ai == 211) {
				if (amountFinal <= Brot2) {
					System.out.println("In progress");
					WHManager.werehouse2.Brot = WHManager.werehouse2.Brot - amountFinal;
					WHManager.werehouse1.Brot = WHManager.werehouse1.Brot + amountFinal;
				} else if (amountFinal > Brot2) {
					System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 212) {
				if (amountFinal <= Medizin2) {
					System.out.println("In progress");
					WHManager.werehouse2.Medizin = WHManager.werehouse2.Medizin - amountFinal;
					WHManager.werehouse1.Medizin = WHManager.werehouse1.Medizin + amountFinal;
				} else if (amountFinal > Medizin2) {
					System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 213) {
				if (amountFinal <= Reifen2) {
					System.out.println("In progress");
					WHManager.werehouse2.Reifen = WHManager.werehouse2.Reifen - amountFinal;
					WHManager.werehouse1.Reifen = WHManager.werehouse1.Reifen + amountFinal;
				} else if (amountFinal > Reifen2) {
					System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 214) {
				if (amountFinal <= Gold2) {
					System.out.println("In progress");
					WHManager.werehouse2.Gold = WHManager.werehouse2.Gold - amountFinal;
					WHManager.werehouse1.Gold = WHManager.werehouse1.Gold + amountFinal;
				} else if (amountFinal > Gold2) {
					System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 215) {
				if (amountFinal <= Kokain2) {
					System.out.println("In progress");
					WHManager.werehouse2.Kokain = WHManager.werehouse2.Kokain - amountFinal;
					WHManager.werehouse1.Kokain = WHManager.werehouse1.Kokain + amountFinal;
				} else if (amountFinal > Kokain2) {
					System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 216) {
				if (amountFinal <= Waffen2) {
					System.out.println("In progress");
					WHManager.werehouse2.Waffen = WHManager.werehouse2.Waffen - amountFinal;
					WHManager.werehouse1.Waffen = WHManager.werehouse1.Waffen + amountFinal;
				} else if (amountFinal > Waffen2) {
					System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 231) {
				if (amountFinal <= Brot2) {
					System.out.println("In progress");
					WHManager.werehouse2.Brot = WHManager.werehouse2.Brot - amountFinal;
					WHManager.werehouse3.Brot = WHManager.werehouse3.Brot + amountFinal;
				} else if (amountFinal > Brot2) {
					System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 232) {
				if (amountFinal <= Medizin2) {
					System.out.println("In progress");
					WHManager.werehouse2.Medizin = WHManager.werehouse2.Medizin - amountFinal;
					WHManager.werehouse3.Medizin = WHManager.werehouse3.Medizin + amountFinal;
				} else if (amountFinal > Medizin2) {
					System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 233) {
				if (amountFinal <= Reifen2) {
					System.out.println("In progress");
					WHManager.werehouse2.Reifen = WHManager.werehouse2.Reifen - amountFinal;
					WHManager.werehouse3.Reifen = WHManager.werehouse3.Reifen + amountFinal;
				} else if (amountFinal > Reifen2) {
					System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 234) {
				if (amountFinal <= Gold2) {
					System.out.println("In progress");
					WHManager.werehouse2.Gold = WHManager.werehouse2.Gold - amountFinal;
					WHManager.werehouse3.Gold = WHManager.werehouse3.Gold + amountFinal;
				} else if (amountFinal > Gold2) {
					System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 235) {
				if (amountFinal <= Kokain2) {
					System.out.println("In progress");
					WHManager.werehouse2.Kokain = WHManager.werehouse2.Kokain - amountFinal;
					WHManager.werehouse3.Kokain = WHManager.werehouse3.Kokain + amountFinal;
				} else if (amountFinal > Kokain2) {
					System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 236) {
				if (amountFinal <= Waffen2) {
					System.out.println("In progress");
					WHManager.werehouse2.Waffen = WHManager.werehouse2.Waffen - amountFinal;
					WHManager.werehouse3.Waffen = WHManager.werehouse3.Waffen + amountFinal;
				} else if (amountFinal > Waffen2) {
					System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 311) {
				if (amountFinal <= Brot3) {
					System.out.println("In progress");
					WHManager.werehouse3.Brot = WHManager.werehouse3.Brot - amountFinal;
					WHManager.werehouse1.Brot = WHManager.werehouse1.Brot + amountFinal;
				} else if (amountFinal > Brot3) {
					System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 312) {
				if (amountFinal <= Medizin3) {
					System.out.println("In progress");
					WHManager.werehouse3.Medizin = WHManager.werehouse3.Medizin - amountFinal;
					WHManager.werehouse1.Medizin = WHManager.werehouse1.Medizin + amountFinal;
				} else if (amountFinal > Medizin3) {
					System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 313) {
				if (amountFinal <= Reifen3) {
					System.out.println("In progress");
					WHManager.werehouse3.Reifen = WHManager.werehouse3.Reifen - amountFinal;
					WHManager.werehouse1.Reifen = WHManager.werehouse1.Reifen + amountFinal;
				} else if (amountFinal > Reifen3) {
					System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 314) {
				if (amountFinal <= Gold3) {
					System.out.println("In progress");
					WHManager.werehouse3.Gold = WHManager.werehouse3.Gold - amountFinal;
					WHManager.werehouse1.Gold = WHManager.werehouse1.Gold + amountFinal;
				} else if (amountFinal > Gold3) {
					System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 315) {
				if (amountFinal <= Kokain3) {
					System.out.println("In progress");
					WHManager.werehouse3.Kokain = WHManager.werehouse3.Kokain - amountFinal;
					WHManager.werehouse1.Kokain = WHManager.werehouse1.Kokain + amountFinal;
				} else if (amountFinal > Kokain3) {
					System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 316) {
				if (amountFinal <= Waffen3) {
					System.out.println("In progress");
					WHManager.werehouse3.Waffen = WHManager.werehouse3.Waffen - amountFinal;
					WHManager.werehouse1.Waffen = WHManager.werehouse1.Waffen + amountFinal;
				} else if (amountFinal > Waffen3) {
					System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 321) {
				if (amountFinal <= Brot3) {
					System.out.println("In progress");
					WHManager.werehouse3.Brot = WHManager.werehouse3.Brot - amountFinal;
					WHManager.werehouse2.Brot = WHManager.werehouse2.Brot + amountFinal;
				} else if (amountFinal > Waffen1) {
					System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 322) {
				if (amountFinal <= Medizin3) {
					System.out.println("In progress");
					WHManager.werehouse3.Medizin = WHManager.werehouse3.Medizin - amountFinal;
					WHManager.werehouse2.Medizin = WHManager.werehouse2.Medizin + amountFinal;
				} else if (amountFinal > Medizin3) {
					System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 323) {
				if (amountFinal <= Reifen3) {
					System.out.println("In progress");
					WHManager.werehouse3.Reifen = WHManager.werehouse3.Reifen - amountFinal;
					WHManager.werehouse2.Reifen = WHManager.werehouse2.Reifen + amountFinal;
				} else if (amountFinal > Reifen3) {
					System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 324) {
				if (amountFinal <= Gold3) {
					System.out.println("In progress");
					WHManager.werehouse3.Gold = WHManager.werehouse3.Gold - amountFinal;
					WHManager.werehouse2.Gold = WHManager.werehouse2.Gold + amountFinal;
				} else if (amountFinal > Gold3) {
					System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 325) {
				if (amountFinal <= Kokain3) {
					System.out.println("In progress");
					WHManager.werehouse3.Kokain = WHManager.werehouse3.Kokain - amountFinal;
					WHManager.werehouse2.Kokain = WHManager.werehouse2.Kokain + amountFinal;
				} else if (amountFinal > Kokain3) {
					System.out.println(e005);
				} else {System.out.println(e006);}
			} else if (ai == 326) {
				if (amountFinal <= Waffen3) {
					System.out.println("In progress");
					WHManager.werehouse3.Waffen = WHManager.werehouse3.Waffen - amountFinal;
					WHManager.werehouse2.Waffen = WHManager.werehouse2.Waffen + amountFinal;
				} else if (amountFinal > Waffen3) {System.out.println(e005);
				} else {System.out.println(e006);}
			} else {System.out.println(e006);}
			
			try {
			
			//Data load
				WHManager.werehouse1.save();
				WHManager.werehouse2.save();
				WHManager.werehouse3.save();
				WHManager.stats1.save();
			
			
			/* Integer */
			
				
			WHManager.werehouse1.load();
			WHManager.werehouse2.load();
			WHManager.werehouse3.load();
			WHManager.stats1.load();
			
			 Brot1 = WHManager.werehouse1.Brot;
			 Brot2 = WHManager.werehouse2.Brot;
			 Brot3 = WHManager.werehouse3.Brot;

			 Medizin1 = WHManager.werehouse1.Medizin;
			 Medizin2 = WHManager.werehouse2.Medizin;
			 Medizin3 = WHManager.werehouse3.Medizin;

			 Reifen1 = WHManager.werehouse1.Reifen;
			 Reifen2 = WHManager.werehouse2.Reifen;
			 Reifen3 = WHManager.werehouse3.Reifen;

			 Gold1 = WHManager.werehouse1.Gold;
			 Gold2 = WHManager.werehouse2.Gold;
			 Gold3 = WHManager.werehouse3.Gold;

			 Kokain1 = WHManager.werehouse1.Kokain;
			 Kokain2 = WHManager.werehouse2.Kokain;
			 Kokain3 = WHManager.werehouse3.Kokain;

			 Waffen1 = WHManager.werehouse1.Waffen;
			 Waffen2 = WHManager.werehouse2.Waffen;
			 Waffen3 = WHManager.werehouse3.Waffen;
			 
			 int Money1 = WHManager.stats1.Geld;

			/* String */
			String Brot1s = String.valueOf(Brot1);
			String Brot2s = String.valueOf(Brot2);
			String Brot3s = String.valueOf(Brot3);

			String Medizin1s = String.valueOf(Medizin1);
			String Medizin2s = String.valueOf(Medizin2);
			String Medizin3s = String.valueOf(Medizin3);

			String Reifen1s = String.valueOf(Reifen1);
			String Reifen2s = String.valueOf(Reifen2);
			String Reifen3s = String.valueOf(Reifen3);

			String Gold1s = String.valueOf(Gold1);
			String Gold2s = String.valueOf(Gold2);
			String Gold3s = String.valueOf(Gold3);

			String Kokain1s = String.valueOf(Kokain1);
			String Kokain2s = String.valueOf(Kokain2);
			String Kokain3s = String.valueOf(Kokain3);

			String Waffen1s = String.valueOf(Waffen1);
			String Waffen2s = String.valueOf(Waffen2);
			String Waffen3s = String.valueOf(Waffen3);
			
			String Money1s = String.valueOf(Money1);
			
			/* TextField */
			txtpnWH1Brot.setText(Brot1s);
			txtpnWH2Brot.setText(Brot2s);
			txtpnWH3Brot.setText(Brot3s);

			txtpnWH1Medi.setText(Medizin1s);
			txtpnWH2Medi.setText(Medizin2s);
			txtpnWH3Medi.setText(Medizin3s);

			txtpnWH1Reifen.setText(Reifen1s);
			txtpnWH2Reifen.setText(Reifen2s);
			txtpnWh3Reifen.setText(Reifen3s);

			txtpnWH1Gold.setText(Gold1s);
			txtpnWH2Gold.setText(Gold2s);
			txtpnWH3Gold.setText(Gold3s);

			txtpnWH1Kokain.setText(Kokain1s);
			txtpnWH2Kokain.setText(Kokain2s);
			txtpnWH3Kokain.setText(Kokain3s);

			txtpnWH1Waffen.setText(Waffen1s);
			txtpnWH2Waffen.setText(Waffen2s);
			txtpnWH3Waffen.setText(Waffen3s);
			
			txtpnMoney_1.setText(Money1s + "€");
			
			System.out.println("Transfere complet");
			
			} catch (Exception e1) {
				e1.printStackTrace();
				System.out.println(e007);
			}
		}
	});

		
		//Refresh button
	
		JButton btnRefresh_1 = new JButton("Refresh");
		btnRefresh_1.setBounds(10, 170, 149, 63);
		frmWarehouses.getContentPane().add(btnRefresh_1);
		btnRefresh_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					//variabel aufruf
					WHManager.werehouse1.load();
					WHManager.werehouse2.load();
					WHManager.werehouse3.load();
					WHManager.stats1.load();

					/* Integer */
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
					
					int Money1 = WHManager.stats1.Geld;

					/* String */
					String Brot1s = String.valueOf(Brot1);
					String Brot2s = String.valueOf(Brot2);
					String Brot3s = String.valueOf(Brot3);

					String Medizin1s = String.valueOf(Medizin1);
					String Medizin2s = String.valueOf(Medizin2);
					String Medizin3s = String.valueOf(Medizin3);

					String Reifen1s = String.valueOf(Reifen1);
					String Reifen2s = String.valueOf(Reifen2);
					String Reifen3s = String.valueOf(Reifen3);

					String Gold1s = String.valueOf(Gold1);
					String Gold2s = String.valueOf(Gold2);
					String Gold3s = String.valueOf(Gold3);

					String Kokain1s = String.valueOf(Kokain1);
					String Kokain2s = String.valueOf(Kokain2);
					String Kokain3s = String.valueOf(Kokain3);

					String Waffen1s = String.valueOf(Waffen1);
					String Waffen2s = String.valueOf(Waffen2);
					String Waffen3s = String.valueOf(Waffen3);
					
					String Money1s = String.valueOf(Money1);

					/* TextField */
					txtpnWH1Brot.setText(Brot1s);
					txtpnWH2Brot.setText(Brot2s);
					txtpnWH3Brot.setText(Brot3s);

					txtpnWH1Medi.setText(Medizin1s);
					txtpnWH2Medi.setText(Medizin2s);
					txtpnWH3Medi.setText(Medizin3s);

					txtpnWH1Reifen.setText(Reifen1s);
					txtpnWH2Reifen.setText(Reifen2s);
					txtpnWh3Reifen.setText(Reifen3s);

					txtpnWH1Gold.setText(Gold1s);
					txtpnWH2Gold.setText(Gold2s);
					txtpnWH3Gold.setText(Gold3s);

					txtpnWH1Kokain.setText(Kokain1s);
					txtpnWH2Kokain.setText(Kokain2s);
					txtpnWH3Kokain.setText(Kokain3s);

					txtpnWH1Waffen.setText(Waffen1s);
					txtpnWH2Waffen.setText(Waffen2s);
					txtpnWH3Waffen.setText(Waffen3s);
					
					txtpnMoney_1.setText(Money1s + "€");

					System.out.println("Were House : -> " + Brot1s + " / " + Medizin1s + " / " + Reifen1s + " / " + Gold1s + " / " + Kokain1s + " / " + Waffen1s);
					System.out.println("Were House : -> " + Brot2s + " / " + Medizin2s + " / " + Reifen2s + " / " + Gold2s + " / " + Kokain2s + " / " + Waffen2s);
					System.out.println("Were House : -> " + Brot3s + " / " + Medizin3s + " / " + Reifen3s + " / " + Gold3s + " / " + Kokain3s + " / " + Waffen3s);
					System.out.println("Money : -> " + Money1s + "€");

					WHManager.werehouse1.save();
					WHManager.werehouse2.save();
					WHManager.werehouse3.save();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				txtpnWH1Brot.setBackground(SystemColor.menu);
				txtpnWH2Brot.setBackground(SystemColor.menu);
				txtpnWH3Brot.setBackground(SystemColor.menu);
				txtpnWH1Medi.setBackground(SystemColor.menu);
				txtpnWH2Medi.setBackground(SystemColor.menu);
				txtpnWH3Medi.setBackground(SystemColor.menu);
				txtpnWH1Reifen.setBackground(SystemColor.menu);
				txtpnWH2Reifen.setBackground(SystemColor.menu);
				txtpnWh3Reifen.setBackground(SystemColor.menu);
				txtpnWH1Gold.setBackground(SystemColor.menu);
				txtpnWH2Gold.setBackground(SystemColor.menu);
				txtpnWH3Gold.setBackground(SystemColor.menu);
				txtpnWH1Kokain.setBackground(SystemColor.menu);
				txtpnWH2Kokain.setBackground(SystemColor.menu);
				txtpnWH3Kokain.setBackground(SystemColor.menu);
				txtpnWH1Waffen.setBackground(SystemColor.menu);
				txtpnWH2Waffen.setBackground(SystemColor.menu);
				txtpnWH3Waffen.setBackground(SystemColor.menu);
			}
				
		});
		
		frmWarehouses.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {
				frmWarehouses.getContentPane(), toolBar, menuBar, mnDatei, mntmRefresh, btnGoButton, btnCraftButton, btnRefresh_1, btnSellButton, btnShopButton }));
	}
		
}
