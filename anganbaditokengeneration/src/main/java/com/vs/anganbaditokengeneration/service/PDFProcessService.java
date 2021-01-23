package com.vs.anganbaditokengeneration.service;


import java.util.Set;

import com.vs.anganbaditokengeneration.domain.LabharthiDomain;

public interface PDFProcessService {
	
	String[] getPDFData(String path);
	
	Set<LabharthiDomain> convertPdfDataToDomainObjects(String[] lines, String pdfPath);

}
