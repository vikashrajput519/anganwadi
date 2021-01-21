package com.vs.anganbaditokengeneration.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vs.anganbaditokengeneration.window.HomeWindow;

@Component
public class HomeControl {
	
	@Autowired
	private HomeWindow homeWindow;
	
	  public void launchTokenGenetor() { homeWindow.initializer(); }
	 
}
