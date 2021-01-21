package com.vs.anganbaditokengeneration.service;


import java.util.List;

import com.vs.anganbaditokengeneration.domain.LabharthiDomain;

public interface PDFProcessService {
	
	String[] getPDFData(String path);
	
	List<LabharthiDomain> convertPdfDataToDomainObjects(String[] lines, String pdfPath);

}
