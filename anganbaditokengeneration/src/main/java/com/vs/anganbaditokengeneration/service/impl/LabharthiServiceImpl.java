package com.vs.anganbaditokengeneration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vs.anganbaditokengeneration.service.ConfigService;
import com.vs.anganbaditokengeneration.service.LabharthiService;

public class LabharthiServiceImpl implements LabharthiService{

	@Autowired
	private ConfigService configService;
	
	
	@Override
	public void process() {
		configService.getDriver().get("http://icdsonline.bih.nic.in/AANGAN/Main.aspx");
	}

}
