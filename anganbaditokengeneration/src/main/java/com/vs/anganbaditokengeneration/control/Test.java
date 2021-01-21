package com.vs.anganbaditokengeneration.control;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.ArrayUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.vs.anganbaditokengeneration.LabharthiDto;

public class Test {
	
	public static PDPage blankPage= new PDPage();
    public  static float PAGE_MARGIN = 20;
    public static float newPagepositionY = blankPage.getMediaBox().getHeight() - PAGE_MARGIN;
    public static float positionY = newPagepositionY;
    
    static int filename = 0;
    

	public static void main(String[] args) throws IOException {
		
		Set<LabharthiDto> labharthi = new HashSet<>();
		
		labharthi.add(new LabharthiDto("1","1","Test","Test","Test","Test","Test","Test1"));
		labharthi.add(new LabharthiDto("1","1","Test","Test","Test","Test","Test","Test2"));
		labharthi.add(new LabharthiDto("1","1","Test","Test","Test","Test","Test","Test3"));
		labharthi.add(new LabharthiDto("1","1","Test","Test","Test","Test","Test","Test4"));
		labharthi.add(new LabharthiDto("1","1","Test","Test","Test","Test","Test","Test5"));
		labharthi.add(new LabharthiDto("1","1","Test","Test","Test","Test","Test","Test6"));
		
		try(Workbook workBook = new XSSFWorkbook())
		{
			Sheet sheet = workBook.createSheet("aagan_report");
			
			short headerFoegroundColor = IndexedColors.AQUA.getIndex();
			
			String[] headers = { "Serial no.", "Kendra Id", "Father Name", "Mother Name", "Account no.", "Labharthi Name","Labharthi age in month", "Token Id"};
			
			createHeader(workBook, sheet, headerFoegroundColor, headers);
			
			List<LabharthiDto> labh = new ArrayList<>();
			labh.addAll(labharthi);
			
			createDataRows(labh, workBook, sheet);
			
			// Making size of column auto resize to fit with data
			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(3);
			sheet.autoSizeColumn(4);
			sheet.autoSizeColumn(5);
			sheet.autoSizeColumn(6);
			
			
			//Write the workbook in file system
			Files.createDirectories(Paths.get("C:\\aagan_folder"));
			try {
				FileOutputStream outputStream = new FileOutputStream(new File("C:\\aagan_folder\\tokens_"+labharthi.stream().findFirst().get().getKendraId()+"("+(++filename)+")"+".xlsx"));
				workBook.write(outputStream);
				
			}catch(Exception e)
			{
				System.out.println("Exception");
			}
			
			System.out.println("Done");
		}
	}

	private static void createDataRows(List<LabharthiDto> labharthi, Workbook workBook, Sheet sheet) {

		int count = 0;
		for(int index = 0; index < labharthi.size(); index ++)
		{
			Row dataRow = sheet.createRow(index+1);
			
			LabharthiDto labharthiDto = labharthi.get(index);
			
			checkForNull(dataRow.createCell(0), ++count);
			checkForNull(dataRow.createCell(1), labharthiDto.getKendraId());
			checkForNull(dataRow.createCell(2), labharthiDto.getNameOfFather());
			checkForNull(dataRow.createCell(3), labharthiDto.getNameOfMother());
			checkForNull(dataRow.createCell(4), labharthiDto.getAccountNum());
			checkForNull(dataRow.createCell(5), labharthiDto.getBenificeryName());
			checkForNull(dataRow.createCell(6), labharthiDto.getAgeInMonths());
			checkForNull(dataRow.createCell(7), labharthiDto.getTokenId());
			
		}
	}
	
	private static void checkForNull(Cell cell, Object value)
	{
		if(value instanceof String)
		{
			cell.setCellValue(String.valueOf(value));
		}
		else if(value instanceof Long)
		{
			cell.setCellValue((Long)value);
		}
		else if(value instanceof Integer)
		{
			cell.setCellValue((Integer)value);
		}
		else if(value instanceof Date)
		{
			cell.setCellValue((Date)value);
		}
	}

	public static void createHeader(Workbook workbook, Sheet sheet, short hederForeignGrondColor, String[] headers)
	{
		if(ArrayUtils.isEmpty(headers))
		{
			return;
		}
		
		Row row = sheet.createRow(0);
		
		// Header Style - Starts
		CellStyle headerCellStyle  = workbook.createCellStyle();
		
		headerCellStyle.setFillForegroundColor(hederForeignGrondColor);
		headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		headerCellStyle.setBorderLeft(BorderStyle.THIN);
		headerCellStyle.setBorderRight(BorderStyle.THIN);
		headerCellStyle.setBorderTop(BorderStyle.THIN);
		headerCellStyle.setBorderBottom(BorderStyle.THIN);
		
		// Header Style - Ends
		
		Cell cell = row.createCell(0);
		cell.setCellValue(headers[0]);
		cell.setCellStyle(headerCellStyle);
		
		for(int index = 1; index < headers.length; index ++)
		{
			cell = row.createCell(index);
			cell.setCellValue(headers[index]);
			cell.setCellStyle(headerCellStyle);
		}
	}
}