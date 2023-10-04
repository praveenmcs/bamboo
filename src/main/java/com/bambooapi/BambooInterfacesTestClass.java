package com.bambooapi;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;

public class BambooInterfacesTestClass extends BambooAPIClass{

	BambooAPIClass restValidation = new BambooAPIClass();
	String className = this.getClass().getSimpleName();
	String baseUrl ="https://bambooclub.bambooairways.com/services/bamboo-club/account";
	String queryParam ="";
	@Test
	@Epic("Master APIs")
	@Story("Country API")
	@Description("Test case to validate country master API")
	public void countryAPIValidation()
	{
		
		
		restValidation.sendGETRequest(baseUrl);
		//restValidation.validateAirportCodePresent("HAN")
		//restValidation.validateResponseSpecification()
			;
	}
}
