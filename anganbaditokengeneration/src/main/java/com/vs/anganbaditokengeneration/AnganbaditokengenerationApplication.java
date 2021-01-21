package com.vs.anganbaditokengeneration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vs.anganbaditokengeneration.control.HomeControl;

@SpringBootApplication
public class AnganbaditokengenerationApplication implements CommandLineRunner{
	
	@Autowired
	private HomeControl homeControl;

	public static void main(String[] args) {
		SpringApplication.run(AnganbaditokengenerationApplication.class, args);
	}

	@Override
	public void run(String...strings) throws Exception
	{
		homeControl.launchTokenGenetor();
	}
}
