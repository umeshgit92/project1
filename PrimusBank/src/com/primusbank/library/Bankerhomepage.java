package com.primusbank.library;

import org.openqa.selenium.By;

import com.primusbank.constants.PrimusBankConstants;

public class Bankerhomepage extends PrimusBankConstants {
	
	public boolean bankerlogout()
	{
		driver.findElement(By.id("IMG1")).click();
		if(driver.findElement(By.id("login")).isDisplayed())
		{
			return false;
		}
		else
		{
			return false;
		}
				
	}
	
	
	
	

}
