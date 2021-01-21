package com.vs.anganbaditokengeneration.control;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.vs.anganbaditokengeneration.LabharthiDto;

public class PDFTest {

	public static void main(String[] args) throws IOException {

		List<LabharthiDto> labharthi = new ArrayList<>();
		
		labharthi.add(new LabharthiDto("1","1","Test","Test","Test","Test","Test","Test1"));
		labharthi.add(new LabharthiDto("1","1","Test","Test","Test","Test","Test","Test2"));
		labharthi.add(new LabharthiDto("1","1","Test","Test","Test","Test","Test","Test3"));
		labharthi.add(new LabharthiDto("1","1","Test","Test","Test","Test","Test","Test4"));
		labharthi.add(new LabharthiDto("1","1","Test","Test","Test","Test","Test","Test5"));
		labharthi.add(new LabharthiDto("1","1","Test","Test","Test","Test","Test","Test6"));
		
		Document document = new Document();
	      try
	      {
	    	 Files.createDirectories(Paths.get("C:\\aagan_folder"));
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\aagan_folder\\HelloWorld.pdf"));
	         document.open();
	         
	         document.addHeader("Test", "Hello");
	         document.add(new Paragraph("Hello World PDF document"));
	         document.close();
	         writer.close();
	         System.out.println("Done");
	      } catch (DocumentException e)
	      {
	         e.printStackTrace();
	      } catch (FileNotFoundException e)
	      {
	         e.printStackTrace();
	      }
	}

}
