package com.vs.anganbaditokengeneration.service;

import java.util.List;

import com.vs.anganbaditokengeneration.LabharthiDto;
import com.vs.anganbaditokengeneration.login.LoginDetails;

public interface TokenGeneratorService {

	void generateLabharthiDetailsFromPortal(LoginDetails loginDetails);
}
