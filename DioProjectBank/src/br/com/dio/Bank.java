package br.com.dio;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;

public class Bank extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAccountNumber;
	private JTextField textFieldAgencyNumber;
	private JPasswordField textFieldPassword;
	private JTextField textFieldBalance;
	private JTextField textFieldValue;
	private JLabel mainLabel;
	private JPanel panelFirstScreen;
	private JLabel agencyNumber;
	private JLabel password;
	private JLabel accountNumber;
	private JButton btnGo;
	private JSeparator separator;
	private JPanel panelTransactions;
	private JLabel labelSuccess;
	private JLabel labelBalance;
	private JLabel labelData;
	private JLabel labelValue;
	private JButton btnGo2;
	private JSeparator separator_1;
	private JToggleButton buttonGroupDeposit;
	private JToggleButton buttonGroupWithdraw;
	private JToggleButton buttonGroupBalance;
	private JSeparator separator_2;
	private JLabel lblNewLabel_5;
	private JButton btnGoExit;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Customer customer = null;
	private Account account = null;
	private boolean flagDeposit = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				Bank frame = new Bank();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	}
		
	

	/**
	 * Create the frame.
	 */
	public Bank() {
	
		setTitle("River Bank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
			
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelFirstScreen = new JPanel();
		panelFirstScreen.setBounds(122, 26, 560, 212);
		contentPane.add(panelFirstScreen);
		panelFirstScreen.setLayout(null);
		
		
		mainLabel = new JLabel("Fill with your agency, account and Password, please.");
		mainLabel.setBounds(103, 13, 378, 15);
		panelFirstScreen.add(mainLabel);
		
		textFieldAgencyNumber = new JTextField();
		textFieldAgencyNumber.setBounds(238, 108, 114, 19);
		panelFirstScreen.add(textFieldAgencyNumber);
		textFieldAgencyNumber.setColumns(10);
		
		agencyNumber = new JLabel("Agency Number:");
		agencyNumber.setFont(new Font("Dialog", Font.BOLD, 14));
		agencyNumber.setBounds(79, 102, 141, 30);
		panelFirstScreen.add(agencyNumber);
		
		password = new JLabel("Password:");
		password.setFont(new Font("Dialog", Font.BOLD, 14));
		password.setBounds(79, 150, 141, 30);
		panelFirstScreen.add(password);
		
		accountNumber = new JLabel("Account number:");
		accountNumber.setFont(new Font("Dialog", Font.BOLD, 14));
		accountNumber.setBounds(79, 59, 141, 30);
		panelFirstScreen.add(accountNumber);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(238, 156, 114, 19);
		panelFirstScreen.add(textFieldPassword);
		
		textFieldAccountNumber = new JTextField();
		textFieldAccountNumber.setBounds(238, 67, 114, 19);
		panelFirstScreen.add(textFieldAccountNumber);
		textFieldAccountNumber.setColumns(10);

		
		btnGo = new JButton("Go");
				btnGo.setBounds(428, 105, 53, 25);
		panelFirstScreen.add(btnGo);
		
		separator = new JSeparator();
		separator.setForeground(new Color(192, 192, 192));
		separator.setBounds(12, 34, 536, 8);
		panelFirstScreen.add(separator);
		
		panelTransactions = new JPanel();
		panelTransactions.setLayout(null);
		panelTransactions.setBounds(122, 286, 560, 212);
		contentPane.add(panelTransactions);
		
		labelData = new JLabel("## Data Here ##");
		labelData.setHorizontalAlignment(SwingConstants.CENTER);
		labelData.setFont(new Font("Dialog", Font.BOLD, 16));
		labelData.setBounds(22, 12, 526, 15);
		panelTransactions.add(labelData);
		
		textFieldBalance = new JTextField();
		textFieldBalance.setEditable(false);
		textFieldBalance.setColumns(10);
		textFieldBalance.setBounds(372, 150, 151, 29);
		panelTransactions.add(textFieldBalance);
		textFieldBalance.setVisible(false);
		
		labelSuccess = new JLabel("Transaction success!");
		labelSuccess.setForeground(new Color(98, 160, 234));
		labelSuccess.setFont(new Font("Arial", Font.BOLD, 20));
		labelSuccess.setBounds(311, 75, 237, 53);
		panelTransactions.add(labelSuccess);
		labelSuccess.setVisible(false);
		
		labelBalance = new JLabel("Balance:");
		labelBalance.setFont(new Font("Dialog", Font.BOLD, 14));
		labelBalance.setBounds(269, 149, 77, 30);
		panelTransactions.add(labelBalance);
		labelBalance.setVisible(false);
		
		labelValue = new JLabel("Value ($):");
		labelValue.setEnabled(false);
		labelValue.setFont(new Font("Dialog", Font.BOLD, 14));
		labelValue.setBounds(269, 61, 105, 30);
		panelTransactions.add(labelValue);
		
		textFieldValue = new JTextField();
		textFieldValue.setEnabled(false);
		textFieldValue.setColumns(10);
		textFieldValue.setBounds(372, 62, 151, 29);
		panelTransactions.add(textFieldValue);
		
		btnGo2 = new JButton("Go");
		btnGo2.setEnabled(false);
		btnGo2.setBounds(425, 103, 53, 25);
		panelTransactions.add(btnGo2);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(12, 34, 536, 8);
		panelTransactions.add(separator_1);
		
		buttonGroupDeposit = new JToggleButton("Deposit");
		buttonGroup.add(buttonGroupDeposit);
		buttonGroupDeposit.setBounds(22, 64, 167, 25);
		panelTransactions.add(buttonGroupDeposit);
		
		
		
		buttonGroupWithdraw = new JToggleButton("Withdraw");
		buttonGroup.add(buttonGroupWithdraw);
		buttonGroupWithdraw.setBounds(22, 90, 167, 25);
		panelTransactions.add(buttonGroupWithdraw);
		
		
		
		buttonGroupBalance = new JToggleButton("Balance");
		buttonGroup.add(buttonGroupBalance);
		buttonGroupBalance.setBounds(22, 117, 167, 25);
		panelTransactions.add(buttonGroupBalance);
		
		
		
		btnGoExit = new JButton("Exit");
		btnGoExit.setBounds(77, 164, 67, 25);
		panelTransactions.add(btnGoExit);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(new Color(192, 192, 192));
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(231, 40, 8, 149);
		panelTransactions.add(separator_2);
		
		panelTransactions.setVisible(false);
		
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Bank.class.getResource("/image/skyline-fresh.jpg")));
		lblNewLabel_5.setBounds(0, 0, 800, 560);
		contentPane.add(lblNewLabel_5);
		
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ReadWriteFile(textFieldAccountNumber.getText(),textFieldAgencyNumber.getText());
					labelData.setText(customer.getName() + " - Agency " + customer.getAgency() + " - Account " + customer.getAccountNumber());
					ReadWriteFile(textFieldAccountNumber.getText(),textFieldAgencyNumber.getText());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"You wrote an invalid caracter or the account doesn't exist. Try again please.",
						      "Error!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				panelFirstScreen.setVisible(false);
				panelTransactions.setBounds(122, 26, 560, 212);
				panelTransactions.setVisible(true);
				
			}
		});
		

		btnGo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				operation();
				buttonGroupDeposit.setEnabled(false);
				buttonGroupBalance.setEnabled(false);
				buttonGroupWithdraw.setEnabled(false);
			}
		});
		

		buttonGroupDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				depositWithdraw();
				
			}
		});
		
		buttonGroupBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				labelBalance.setVisible(true);
				textFieldBalance.setVisible(true);
				textFieldBalance.setDragEnabled(true);
				double balance = customer.getBalance();
				textFieldBalance.setText(String.valueOf("$"+balance));
				
			}
		});
		
		
		buttonGroupWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				flagDeposit = false;
				depositWithdraw();
								
			}
		});
		
		
		btnGoExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				System.exit(EXIT_ON_CLOSE);
			}
		});
		
	}
	
	
	void depositWithdraw() {
		labelValue.setEnabled(true);
		textFieldValue.setEnabled(true);
		btnGo2.setEnabled(true);
	}
		
		
		
		
	 void operation() {
		
		
		double total = 0.0;

		double money;
		String text = "";
		
		try {
			text = textFieldValue.getText();
			money = Double.parseDouble(text);
			if(flagDeposit) {
				total = account.deposit(money);
			}
			else {
			total = account.withdraw(money);
			JOptionPane.showMessageDialog(null,"Negative bank balance. You are using your overdraft.",
				      "CAUTION!", JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e) {	
			if(text.contains(","))
				text = "Replace the comma with a dot please.";
			else
				text = "You wrote an invalid caracter. Try again please.";
			JOptionPane.showMessageDialog(null,text,
				      "Error!", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		labelBalance.setVisible(true);
		textFieldBalance.setVisible(true);
		labelSuccess.setVisible(true);
		btnGo2.setVisible(false);
		labelValue.setVisible(false);
		textFieldValue.setVisible(false);
	 
		
		customer.setBalance(total);
		textFieldBalance.setText("$"+String.valueOf(total));
		
		String updateLine = customer.getName()+","+customer.getId()+","+customer.getAgency()+","+
				customer.getAccountNumber()+","+customer.getBalance();
		
		UpdateLine(updateLine);
		
	  }
	 
	 
	 
	
	   void ReadWriteFile(String accountNumber, String agencyNumber) {
	    	FileReader fr = null;
	    	FileWriter fw = null;
	    	BufferedReader br = null;
	    	BufferedWriter bw = null;
        
	    	try {
	    		fw = new FileWriter("bd.txt");
	    		bw = new BufferedWriter(fw);
	    		fr = new FileReader("data.txt");
	    		br = new BufferedReader(fr); 
			
	    		String line = br.readLine();
			
	    		while(line!=null){     
				
				   String str[] =  line.split(",");	
				   if (str[2].equals(accountNumber) && str[3].equals(agencyNumber)) {
					   customer = new Customer(str[0],str[1],str[2],str[3],Double.parseDouble(str[4]));
					   account = new Account(customer);
					   
				   }
				   else {
					   bw.append(line + "\n");						   
				   }
				   
				   line = br.readLine();					   
	    		}
			
			br.close();
			bw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	   
	   
	
	
	void UpdateLine(String updateLine) {
		
		
		FileReader fr = null;
    	FileWriter fw = null;
    	BufferedReader br = null;
    	BufferedWriter bw = null;
    
    	try {
    		fw = new FileWriter("data.txt");
    		bw = new BufferedWriter(fw);
    		fr = new FileReader("bd.txt");
    		br = new BufferedReader(fr); 
		
    		String line = br.readLine();
    		
    		while(line!=null){     
			
			   bw.append(line+"\n"); 			   
			   line = br.readLine();
			   
    		}
    		
    		bw.append(updateLine);
		
		br.close();
		bw.close();
	} catch (IOException e) {
		
		e.printStackTrace();
	} finally {
		
		
	}
			
		
	}
	
	
	void resetPanel() {
		buttonGroupDeposit.setEnabled(true);
		buttonGroupBalance.setEnabled(true);
		buttonGroupWithdraw.setEnabled(true);
	}
		
}

