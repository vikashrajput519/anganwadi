package com.vs.anganbaditokengeneration.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.anganbaditokengeneration.domain.LabharthiDomain;
import com.vs.anganbaditokengeneration.service.ConfigService;
import com.vs.anganbaditokengeneration.service.PDFProcessService;

@Service
public class PDFProcessServiceImpl implements PDFProcessService{
	
	@Autowired
	private ConfigService configService;

	@Override
	public String[] getPDFData(String path) {
		
		String[] lines = null;

			if(Objects.nonNull(configService.getPdfDocument(path)))
			{
				PDDocument document = configService.getPdfDocument(path);
				PDFTextStripper pdfStripper;
				try {
					// Retrieving text from PDF document
					pdfStripper = new PDFTextStripper();
					String pdfFileInText = pdfStripper.getText(document);
					lines = pdfFileInText.split("\\r?\\n");
				} catch (IOException e) {
					// TODO Exception
					e.printStackTrace();
				}
			}
			else
			{
				// throw generic exception 
			}
		
		return lines;
	}

	@Override
	public Set<LabharthiDomain> convertPdfDataToDomainObjects(String[] lines, String pdfPath) 
	{
		
		List<String> lineList = getFilteredLine(lines);
		
		Set<LabharthiDomain> labharthiDomainList = new LinkedHashSet<>();
		
		for(String line : lineList)
		{
			LabharthiDomain labharthiDomain = new LabharthiDomain();
			
			String mobileNum = getLastWord(line);
			
			System.out.println(line);
			
			line = line.replace(mobileNum, "");
			
			String aadharNum = getLastWord(line.trim());
			
			line = line.replace(aadharNum, "");
			
			line = line.replace(getFirstWord(line), "");
			
			labharthiDomain.setMobileNum(mobileNum.trim());
			labharthiDomain.setAadharNum(aadharNum.trim());
			labharthiDomain.setAllFamilyNames(line);
			
			labharthiDomainList.add(labharthiDomain);
		}
		
		PDDocument document = configService.getPdfDocument(pdfPath);
		
		try {
			document.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return labharthiDomainList;
	}
	
	private List<String> getFilteredLine(String[] lines)
	{
		String sentence = "";
		
		List<String> stringList = new ArrayList<>();

		for (String line : lines) 
		{
			line = line.trim();
			
			if(StringUtils.contains(line, "Mobile"))
			{
				continue;
			}
			
			if(!isValidIndianMobile(getLastWord(line)))
			{
				sentence = sentence + " " + line.trim();
				line = "";
			}
			if(!StringUtils.contains(line, ".") && isValidIndianMobile(getLastWord(line.trim())))
			{
				sentence = sentence + " " + line.trim();
				line = sentence.trim();
				sentence = "";
			}
			
			if(StringUtils.isNotBlank(line))
			{
				stringList.add(line);
			}

		}
		
		return stringList;
	}
	
	private boolean isValidIndianMobile(String mobile) {

		if (mobile == null || mobile.trim().length() <= 0) {
			return false;
		}
		mobile = removeAllSpace(mobile);

		Pattern pattern = Pattern.compile("[1-9][0-9]{9}");
		Matcher matcher = pattern.matcher(mobile);
		return matcher.matches();
	}

	private String removeAllSpace(String s) {
		if (s == null)
			return "";
		return s.replaceAll("\\s", "");
	}

	private String getLastWord(String line) {
		return line.substring(line.lastIndexOf(" ") + 1);
	}

	private String getFirstWord(String line) {
		return line.split(" ", 2)[0];

	}

}
