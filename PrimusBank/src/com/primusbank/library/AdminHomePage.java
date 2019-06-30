package com.primusbank.library;

import org.openqa.selenium.By;

import com.primusbank.constants.PrimusBankConstants;

public class AdminHomePage extends PrimusBankConstants{
	
	public boolean adminLogout()
	{
		driver.findElement(By.xpath("//img[@src='images/admin_but_03.jpg']")).click();
	if(driver.findElement(By.id("login")).isDisplayed())
	{
		return true;
	}
	else
	{
		return false;
	}
	}
	
	

}
