package com.atmbanksystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame{
	
	    JLabel l1,l2,l3;
	    JTextField tf1;
	    JPasswordField pf2;
	    JButton b1,b2,b3;

		Login(){
			
			setTitle("AUTOMATED TELLER MACHINE");
			
			ImageIcon i  = new ImageIcon(ClassLoader.getSystemResource("icons/banklogo.jpg"));
			  Image i2 = i.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
			  
		        ImageIcon i3 = new ImageIcon(i2);
		        JLabel l11 = new JLabel(i3);
		        l11.setBounds(70, 10, 100, 100);
		        add(l11);
		        
		        l1 = new JLabel("WELCOME TO ATM");
		        l1.setFont(new Font("Osward", Font.BOLD, 38));
		        l1.setBounds(200,40,450,40);
		        add(l1);
		        
		        l2 = new JLabel("Card No:");
		        l2.setFont(new Font("Raleway", Font.BOLD, 28));
		        l2.setBounds(125,150,375,30);
		        add(l2);
		        
		        tf1 = new JTextField(15);
		        tf1.setBounds(300,150,230,30);
		        tf1.setFont(new Font("Arial", Font.BOLD, 14));
		        add(tf1);
		        
		        l3 = new JLabel("PIN:");
		        l3.setFont(new Font("Raleway", Font.BOLD, 28));
		        l3.setBounds(125,220,375,30);
		        add(l3);
		        
		        pf2 = new JPasswordField(15);
		        pf2.setFont(new Font("Arial", Font.BOLD, 14));
		        pf2.setBounds(300,220,230,30);
		        add(pf2);
		                
		        b1 = new JButton("SIGN IN");
		        b1.setBackground(Color.BLACK);
		        b1.setForeground(Color.WHITE);
		        
		        b2 = new JButton("CLEAR");
		        b2.setBackground(Color.BLACK);
		        b2.setForeground(Color.WHITE);
		        
		        b3 = new JButton("SIGN UP");
		        b3.setBackground(Color.BLACK);
		        b3.setForeground(Color.WHITE);
		        
		        setLayout(null);
		        
		        b1.setFont(new Font("Arial", Font.BOLD, 14));
		        b1.setBounds(300,300,100,30);
		        add(b1);
		        
		        b2.setFont(new Font("Arial", Font.BOLD, 14));
		        b2.setBounds(430,300,100,30);
		        add(b2);
		        
		        b3.setFont(new Font("Arial", Font.BOLD, 14));
		        b3.setBounds(300,350,230,30);
		        add(b3);
		        
		        b1.addActionListener((ActionListener) this);
		        b2.addActionListener((ActionListener) this);
		        b3.addActionListener((ActionListener) this);
		        
		        getContentPane().setBackground(Color.WHITE);
		        
			JLabel lable = new JLabel(i);
			add(lable);
			
			setSize(800, 480);
			setVisible(true);
			setLocation(350, 200);
		}
		
		public static void main(String[] args) {
			
			new Login();
		}
		
	}

