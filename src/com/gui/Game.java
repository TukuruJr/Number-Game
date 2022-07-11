package com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;


import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Game implements ActionListener{

	private JFrame frmPlayGame;
	private JTextField getstake;
	private JTextField getdeposit;
	private JTextField showbal;
	private JButton btnPlay,btnWithdraw,btnOk;
	private double balance;
	private JComboBox select;
	private double stake;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.frmPlayGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlayGame = new JFrame();
		frmPlayGame.setTitle("Play Game");
		frmPlayGame.setBounds(100, 100, 712, 430);
		frmPlayGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlayGame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(12, 12, 688, 372);
		frmPlayGame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("A GAME OF NUMBERS -> GUESS CORRECT NUMBER AND STAKE VALUE IS TRIPPLED, OTHER CORRECT PREDICTIONS ,STAKE DOUBLED ");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel.setBounds(12, 46, 664, 26);
		panel.add(lblNewLabel);
		
		JLabel lblAbout = new JLabel("ABOUT GAME");
		lblAbout.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblAbout.setForeground(Color.RED);
		lblAbout.setBounds(245, 12, 110, 15);
		panel.add(lblAbout);
		
		select = new JComboBox();
		select.setForeground(new Color(255, 0, 0));
		select.setBackground(new Color(255, 255, 0));
		select.setModel(new DefaultComboBoxModel(new String[] {"", "CORRECT VALUE", "ODD VALUE", "EVEN VALUE", "LESS THAN 5", "GREATER THAN FIVE"}));
		select.setBounds(35, 121, 295, 26);
		panel.add(select);
		
		JLabel lblNewLabel_1 = new JLabel("SELECT A BET OF CHOICE");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(109, 104, 186, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NUMBERS RANGE FROM 0 TO 10");
		lblNewLabel_2.setForeground(new Color(0, 51, 51));
		lblNewLabel_2.setBounds(50, 77, 244, 15);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "STAKE AND PLAY", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(153, 153, 0));
		panel_1.setBounds(24, 170, 306, 190);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("STAKE: ");
		lblNewLabel_3.setForeground(new Color(51, 0, 0));
		lblNewLabel_3.setBounds(25, 62, 70, 15);
		panel_1.add(lblNewLabel_3);
		
		getstake = new JTextField();
		getstake.setBounds(96, 53, 154, 33);
		panel_1.add(getstake);
		getstake.setColumns(10);
		
		btnPlay = new JButton("PLAY");
		btnPlay.setEnabled(false);
		btnPlay.setForeground(new Color(255, 255, 255));
		btnPlay.setBackground(new Color(0, 51, 0));
		btnPlay.setBounds(100, 125, 150, 39);
		btnPlay.addActionListener(this);
		panel_1.add(btnPlay);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "MANAGE ACCOUNT", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 102)));
		panel_2.setBackground(new Color(102, 51, 255));
		panel_2.setBounds(342, 84, 334, 276);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		getdeposit = new JTextField();
		getdeposit.setBounds(134, 48, 176, 35);
		panel_2.add(getdeposit);
		getdeposit.setColumns(10);
		
		JLabel lblDeposit = new JLabel("DEPOSIT");
		lblDeposit.setForeground(new Color(255, 153, 0));
		lblDeposit.setBounds(46, 58, 70, 15);
		panel_2.add(lblDeposit);
		
		JLabel lblNewLabel_4 = new JLabel("Minimun Value of Ksh 10");
		lblNewLabel_4.setForeground(new Color(0, 51, 0));
		lblNewLabel_4.setBounds(82, 21, 206, 15);
		panel_2.add(lblNewLabel_4);
		
		showbal = new JTextField();
		showbal.setFont(new Font("Dialog", Font.BOLD, 12));
		showbal.setForeground(new Color(0, 0, 0));
		showbal.setEditable(false);
		showbal.setBounds(183, 245, 138, 19);
		panel_2.add(showbal);
		showbal.setColumns(10);
		
		JLabel lblAccountBalance = new JLabel("ACCOUNT BALANCE");
		lblAccountBalance.setForeground(new Color(153, 0, 0));
		lblAccountBalance.setBounds(183, 218, 148, 15);
		panel_2.add(lblAccountBalance);
		
		btnOk = new JButton("OK");
		btnOk.setForeground(new Color(204, 153, 204));
		btnOk.setBackground(new Color(153, 0, 51));
		btnOk.setBounds(193, 95, 117, 25);
		btnOk.addActionListener(this);
		btnOk.setFocusable(false);
		panel_2.add(btnOk);
		
		btnWithdraw = new JButton("WITHDRAW");
		btnWithdraw.setForeground(new Color(255, 255, 255));
		btnWithdraw.setBackground(new Color(0, 102, 0));
		btnWithdraw.setBounds(193, 181, 117, 25);
		btnWithdraw.addActionListener(this);
		panel_2.add(btnWithdraw);
		
		JLabel lblfrancode = new JLabel("@FRANCODE");
		lblfrancode.setForeground(new Color(51, 255, 0));
		lblfrancode.setBounds(23, 247, 93, 15);
		panel_2.add(lblfrancode);
	}

	@Override
	public void actionPerformed(ActionEvent btn) {
		// TODO Auto-generated method stub
		//no blank for deposit
		if(btn.getSource().equals(btnOk)) {
			if(getdeposit.getText().isBlank()) {
				JOptionPane.showMessageDialog(frmPlayGame, "A minimum of KSh 10 allowed","Warning",JOptionPane.WARNING_MESSAGE);
				return;
			}	
			//handle deposit
			else {
				double amt = Double.parseDouble(getdeposit.getText());
				//deposit below 10
				if(amt<10) {
					JOptionPane.showMessageDialog(frmPlayGame, "A minimum of KSh 10 allowed","Warning",JOptionPane.WARNING_MESSAGE);
					return;
				}else {
					balance = balance+amt;
					showbal.setText(amt+"");
					btnPlay.setEnabled(true);
					getdeposit.setText("");
				}
			}
		}
		
		/**
		 * handle withdraw
		 */
		else if(btn.getSource().equals(btnWithdraw)) {
			double amt = Double.parseDouble(JOptionPane.showInputDialog("Enter Amount"));
			Withdraw(amt);
		}
		
		else if(btn.getSource().equals(btnPlay)) {
			Play();
		}
		
	}
	
	private void Withdraw(double val) {
		if(val>balance) {
			JOptionPane.showMessageDialog(frmPlayGame, "Top up Account","Warning",JOptionPane.WARNING_MESSAGE);
		}else {
			balance = balance-val;
			JOptionPane.showMessageDialog(frmPlayGame, "Withdrawal Success balance "+balance);
			showbal.setText(balance+"");
		}
	}
	
	private void Play() {
		Random ran = new Random();
	   int answer = ran.nextInt(10)+1; //generate a value 1-10 inclusive
		if(getstake.getText().isBlank()) {
			JOptionPane.showMessageDialog(frmPlayGame, "Enter Stake Value!!");
			return;
		}else {
			stake = Double.parseDouble(getstake.getText());
			
			//stake greater than balance value
			if(stake>balance) {
				JOptionPane.showMessageDialog(frmPlayGame, "Low Balance!!","Warning",JOptionPane.WARNING_MESSAGE);
				return;
			}else {
				balance=balance-stake;
				showbal.setText(balance+"");
			if(select.getSelectedIndex()==0) {
				JOptionPane.showMessageDialog(frmPlayGame, "Select an option!!");
				balance=balance+stake;
				showbal.setText(balance+"");
				btnPlay.setEnabled(false);
			}
			else if(select.getSelectedIndex()==1) {
				//correct value
				int guess = Integer.parseInt(JOptionPane.showInputDialog("Correct number?"));
				if(guess==answer) {
					balance=(stake*3)+balance;
					JOptionPane.showMessageDialog(null, "You won the Value Was "+answer);
					showbal.setText(balance+"");
				}else {
					Lost(answer);
				}
			}
			
			else if(select.getSelectedIndex()==2) {
				//odd number
				if(answer%2==0) {
					Lost(answer);
				}else {
					Won(answer);
				}
			}
				
				else if(select.getSelectedIndex()==3) {
					//even number
					if(answer%2==0) {
						Won(answer);	
					}else {
						Lost(answer);
					}	
			}
			
				else if(select.getSelectedIndex()==4) {
					// number less than five
					if(answer<5) {
						Won(answer);	
					}else {
						Lost(answer);
					}	
			}
			
				else if(select.getSelectedIndex()==5) {
					//odd number
					if(answer>5) {
						Won(answer);	
					}else {
						Lost(answer);
					}	
			}
		}
	
		}
	}

	private void Lost(int answer) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "You lost the Value Was "+answer,"Lost",JOptionPane.WARNING_MESSAGE);
		showbal.setText(balance+"");
	}

	private void Won(int answer) {
		// TODO Auto-generated method stub
		balance = (stake*2)+balance;
		showbal.setText(balance+"");
		JOptionPane.showMessageDialog(null, "You won the Value Was "+answer);
		
	}
}
