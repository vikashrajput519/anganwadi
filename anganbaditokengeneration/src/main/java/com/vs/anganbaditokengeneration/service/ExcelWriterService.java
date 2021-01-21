package com.vs.anganbaditokengeneration.service;

import java.util.List;

import javax.swing.JFrame;

import com.vs.anganbaditokengeneration.LabharthiDto;

public interface ExcelWriterService {
	
	void exportInExcel(List<LabharthiDto> labharthiList, JFrame frame, int fileNameCount);

}
