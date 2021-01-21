package com.vs.anganbaditokengeneration.service;

import java.util.Set;

import com.vs.anganbaditokengeneration.LabharthiDto;

public interface PDFWriterService {
	
	void writePDF(Set<LabharthiDto> labharthiDtos);

}
