package com.vs.anganbaditokengeneration.window;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vs.anganbaditokengeneration.LabharthiDto;
import com.vs.anganbaditokengeneration.service.ExcelWriterService;
import com.vs.anganbaditokengeneration.service.impl.TokenGeneratorServiceImpl;

import javax.swing.JButton;

@Component
public class ExportTokensWindow implements ActionListener{

	private JFrame frame;
	private JTable table;
	private JButton btnExportInExcel;
	private JButton btnExportInPdf;
	
	int count;
	
	int fileCount;
	
	@Autowired
	private TokenGeneratorServiceImpl tokenGeneratorServiceImpl;
	
	@Autowired
	private ExcelWriterService excelWriterService;
	
	
	public void initializer()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		

		DefaultTableModel defaultTableModel = new DefaultTableModel(0, 0);
		
		count = 0;
		fileCount = 0;

		String[] columnNames = new String[] { "Serial no.", "Kendra Id", "Father Name", "Mother Name", "Account no.", "Labharthi Name","Labharthi age in month", "Token Id"};

		defaultTableModel.setColumnIdentifiers(columnNames);
		
		Set<LabharthiDto> labharthiListSet = tokenGeneratorServiceImpl.getLabharthiDtoRepository();
		
		List<LabharthiDto> labharthiList  = Optional.of(labharthiListSet).orElseGet(Collections::emptySet)
				.stream().sorted(Comparator.comparing(LabharthiDto::getBenificeryName, Comparator.nullsLast(Comparator.naturalOrder()))).collect(Collectors.toList());
		
		
		if(!labharthiList.isEmpty())
		{
			labharthiList.forEach(labharthiDto -> 
			{
				defaultTableModel.addRow(new Object[] { ++count, labharthiDto.getKendraId(), labharthiDto.getNameOfFather(), labharthiDto.getNameOfMother(), labharthiDto.getAccountNum(), labharthiDto.getBenificeryName(), labharthiDto.getAgeInMonths(),labharthiDto.getTokenId()});
			});
		}
		
		table.setModel(defaultTableModel);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 22, 866, 498);
		frame.getContentPane().add(scrollPane);
		
		btnExportInExcel = new JButton("Export In Excel");
		btnExportInExcel.setBounds(287, 530, 133, 23);
		btnExportInExcel.addActionListener(this);
		frame.getContentPane().add(btnExportInExcel);
		
		btnExportInPdf = new JButton("Export In Pdf");
		btnExportInPdf.setBounds(484, 530, 127, 23);
		btnExportInPdf.addActionListener(this);
		frame.getContentPane().add(btnExportInPdf);
		
		frame.setVisible(true);
		
	}
	
	

	/**
	 * Launch the application.
	 *
	 *
	 */
	
	
	  public static void main(String[] args) { EventQueue.invokeLater(new
	  Runnable() { public void run() { try { new
	  ExportTokensWindow().initializer(); } catch (Exception e) { e.printStackTrace(); } } }); }



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnExportInPdf)
		{
			JOptionPane.showMessageDialog(frame, "Functionality not yet implemented. Please export Tokens in Excel by clicking on Export In Excel button ", "Information",
			        JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(e.getSource() == btnExportInExcel)
		{
			List<LabharthiDto> labharthDtoList = new ArrayList<>();
			
			labharthDtoList.addAll(tokenGeneratorServiceImpl.getLabharthiDtoRepository());
			
			if(!labharthDtoList.isEmpty())
			{
				excelWriterService.exportInExcel(labharthDtoList, frame, ++fileCount);
			}
			else
			{
				JOptionPane.showMessageDialog(frame, "No Tokens Generated Yet.", "ERROR",
				        JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	 

}
