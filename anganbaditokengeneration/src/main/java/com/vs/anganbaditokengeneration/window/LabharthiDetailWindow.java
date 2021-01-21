package com.vs.anganbaditokengeneration.window;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vs.anganbaditokengeneration.domain.LabharthiDomain;
import com.vs.anganbaditokengeneration.login.LoginDetails;
import com.vs.anganbaditokengeneration.service.PDFProcessService;
import com.vs.anganbaditokengeneration.service.TokenGeneratorService;
import com.vs.anganbaditokengeneration.window.listner.ButtonColumn;

import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JTextField;

@Component
public class LabharthiDetailWindow implements ActionListener{

	private JFrame frame;
	private JTable table;
	private JLabel lblPassword;
	private JTextField textPassword;
	private JButton btnExportTokens;
	
	private List<LabharthiDomain> labharthiDomains;
	
	@Autowired
	private PDFProcessService pdfService;
	
	@Autowired
	private ExportTokensWindow exportTokensWindow;
	
	@Autowired
	private TokenGeneratorService tokenGeneratorService;
	
	public void initializer(HomeWindow homeWindow)
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 950, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();

		DefaultTableModel defaultTableModel = new DefaultTableModel(0, 0);

		String[] columnNames = new String[] { "Serial num", "Father Name", "Mother Name", "Aadhar No.", "Mobile No.","Action","Status"};

		defaultTableModel.setColumnIdentifiers(columnNames);
		
		String pdfPah = homeWindow.getTxtFilePath().getText();

		labharthiDomains = pdfService.convertPdfDataToDomainObjects(pdfService.getPDFData(pdfPah),
				pdfPah);

		labharthiDomains.forEach(labharthiDomain -> 
		{
			defaultTableModel.addRow(new Object[] { labharthiDomain.getSerivalNum(), labharthiDomain.getNameOfFather(),
					labharthiDomain.getNameOfMother(), labharthiDomain.getAadharNum(),
					labharthiDomain.getMobileNum(),"Get Token"
		});

		});
		 
		/*
		 * defaultTableModel.addRow(new Object[] { "","","","",""});
		 */
		table.setModel(defaultTableModel);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 48, 914, 468);
		frame.getContentPane().add(scrollPane);
		
		
		// Row Button Setting and action- Starts
		Action delete = new AbstractAction()
		{
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e)
		    {
		        JTable table = (JTable)e.getSource();
		        int modelRow = Integer.valueOf( e.getActionCommand() );
		        
		        String aadharNumber = (String) ((DefaultTableModel)table.getModel()).getValueAt(modelRow, 3);
		        
		        String mobileNum = (String) ((DefaultTableModel)table.getModel()).getValueAt(modelRow, 4);
		        
		        String password = textPassword.getText();
		        
		        System.out.println("Aadhar - - >"+aadharNumber+" --> Mobile - - >"+mobileNum);
		        
		        if(StringUtils.isNotBlank(aadharNumber) && StringUtils.isNotBlank(mobileNum) && StringUtils.isNotBlank(password))
		        {
		        	try {
		        		tokenGeneratorService.generateLabharthiDetailsFromPortal(new LoginDetails(aadharNumber, mobileNum, password));
		        	}
		        	catch(Exception e1)
		        	{
		        		e1.printStackTrace();
		        		System.out.println("No token Present.");
		        	}
		        	
		        	((DefaultTableModel)table.getModel()).setValueAt("Clicked",modelRow, 6);
		        }
		        else
		        {
		        	JOptionPane.showMessageDialog(frame, "Please Enter password for Token.", "ERROR",
					        JOptionPane.ERROR_MESSAGE);
		        }
		        
		        //((DefaultTableModel)table.getModel()).removeRow(modelRow);
		    }
		};
		 
		ButtonColumn buttonColumn = new ButtonColumn(table, delete, 5);
		
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(25, 11, 74, 14);
		frame.getContentPane().add(lblPassword);
		
		textPassword = new JTextField("1234");
		textPassword.setBounds(109, 8, 147, 20);
		frame.getContentPane().add(textPassword);
		textPassword.setColumns(10);
		
		btnExportTokens = new JButton("Export Generated Tokens");
		btnExportTokens.setBounds(399, 527, 190, 23);
		btnExportTokens.addActionListener(this);
		frame.getContentPane().add(btnExportTokens);
		buttonColumn.setMnemonic(KeyEvent.VK_D);

		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		/*
		 * // Action on Get Token button if(actionEvent.getSource() == btnGetToken) {
		 * if(Objects.nonNull(labharthiDomains)) { //Sellinimum Code } else {
		 * JOptionPane.showMessageDialog(frame,
		 * "Sorry!! No data available from PDF Try to load from PDF again.", "ERROR",
		 * JOptionPane.ERROR_MESSAGE); } }
		 */
		if (actionEvent.getSource() == btnExportTokens) 
		{
			exportTokensWindow.initializer();
		}
	}

	/**
	 * Launch the application.
	 */
	
	
	
	
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { new
	 * LabharthiDetailWindow().initializer(null); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	 
}
