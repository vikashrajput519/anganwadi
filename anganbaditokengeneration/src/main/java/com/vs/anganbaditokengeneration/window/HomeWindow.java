package com.vs.anganbaditokengeneration.window;

import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vs.anganbaditokengeneration.enums.ConfigEnums;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

@Component
public class HomeWindow implements ActionListener{

	private JFrame frame;
	private JTextField txtFilePath;
	private JPanel panel;
	private JLabel lblSelectPdf;
	private JButton btnBrows;
	private JButton btnLoadPdf;
	
	@Autowired
	private LabharthiDetailWindow labharthiDetailWindow;
	
	public void initializer()
	{
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 600, 400);
		frame.setTitle("Token Generator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 564, 339);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Select PDF path and click on Load PDF button"));
		
		lblSelectPdf = new JLabel("Select PDF");
		lblSelectPdf.setBounds(22, 33, 71, 20);
		panel.add(lblSelectPdf);
		
		txtFilePath = new JTextField();
		txtFilePath.setBounds(91, 33, 364, 20);
		txtFilePath.setColumns(10);
		panel.add(txtFilePath);
		
		btnBrows = new JButton("Brows");
		btnBrows.setBounds(465, 32, 89, 23);
		btnBrows.addActionListener(this);
		panel.add(btnBrows);
		
		btnLoadPdf = new JButton("Load PDF");
		btnLoadPdf.setBounds(213, 79, 89, 23);
		btnLoadPdf.addActionListener(this);
		panel.add(btnLoadPdf);
		
		JLabel lblDeginedAnd = new JLabel("@ Design and developed by Vikash Singh. For support call @ +91-9971917992");
		lblDeginedAnd.setFont(new Font("Lucida Handwriting", Font.BOLD, 11));
		lblDeginedAnd.setForeground(Color.BLUE);
		lblDeginedAnd.setBounds(38, 305, 483, 23);
		panel.add(lblDeginedAnd);
		
		JLabel lblAgan = new JLabel("Anganwadi Token Generator - V1.0");
		lblAgan.setForeground(new Color(0, 0, 205));
		lblAgan.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
		lblAgan.setBounds(143, 132, 291, 39);
		panel.add(lblAgan);
		
		frame.setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	
	  public static void main(String[] args) { EventQueue.invokeLater(new
	  Runnable() { public void run() { try { new HomeWindow().initializer(); } catch (Exception
	  e) { e.printStackTrace(); } } }); }
	 

	/**
	 * Create the frame.
	 */
	public HomeWindow() 
	{
		System.setProperty(ConfigEnums.HEADLESS.getConfigMessage(), ConfigEnums.FALSE.getConfigMessage());
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		// Action for Brows Button
		if(actionEvent.getSource() == btnBrows)
		{
			txtFilePath.setEditable(true);
			txtFilePath.setText("");
			FileDialog dialog = new FileDialog(frame, "Select File to Open");
		    dialog.setMode(FileDialog.LOAD);
		    dialog.setVisible(true);
		    
		    File[] files = dialog.getFiles();
		    txtFilePath.setText(files[0].getAbsolutePath());
		    txtFilePath.setEditable(false);
		}
		
		// Action for Load PDF button
		if(actionEvent.getSource() == btnLoadPdf)
		{
			
			// After 30 dec this version will stop working
			LocalDateTime dateTimeOne = LocalDateTime.now();
	         
	        LocalDateTime dateTimeTwo = LocalDateTime.parse("2021-01-30T02:07:00.000");
	         
	        boolean isBefore = dateTimeOne.isBefore(dateTimeTwo);
	        
	        if(!isBefore)
	        {
	        	JOptionPane.showMessageDialog(frame, "Please Please Contact To Vikash Your contract with this softare has ended.", "ERROR",
				        JOptionPane.ERROR_MESSAGE);
	        	throw new NullPointerException();
	        }
			
	     // After 30 dec this version will stop working
			
			
			if (checkForValidFile(txtFilePath.getText())) 
			{
				labharthiDetailWindow.initializer(this);
				frame.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(frame, "Please Select PDF file by clicking on Brows Button.", "ERROR",
				        JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	private boolean checkForValidFile(String fileName)
	{
		return StringUtils.isNotBlank(fileName) && StringUtils.endsWithIgnoreCase(fileName, ".PDF");
	}

	public JTextField getTxtFilePath() {
		return txtFilePath;
	}
	
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}
}
