package com.primusbank.library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.primusbank.constants.PrimusBankConstants;
import com.utils.UIUtils;

public class PrimusBankHomePage extends PrimusBankConstants {
	
	public boolean adminLogin(String uid,String pwd)
	{
		String expurl,acturl;
		expurl="adminflow";
		driver.findElement(By.id("txtuId")).sendKeys(uid);
		driver.findElement(By.id("txtPword")).sendKeys(pwd);
		driver.findElement(By.id("login")).click();
		acturl=driver.getCurrentUrl();
		if(acturl.contains(expurl))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean bankerlogin(String brname,String uid,String pwd)
	{
		
		String expval,actval;
		expval="Bankers_flow";
		UIUtils.selectItem(driver, "//*[@id='drlist']", brname);
		driver.findElement(By.id("txtuId")).sendKeys(uid);
		driver.findElement(By.id("txtPword")).sendKeys(pwd);
		driver.findElement(By.id("login")).click();
		actval=driver.getCurrentUrl();
		
		if(actval.contains(expval))
		{
			return true;
		}
		else
		{
			return false;
			
		}
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
