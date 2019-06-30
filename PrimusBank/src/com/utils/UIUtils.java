package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UIUtils 
{

	
	
	public static void selectItem(WebDriver driver,String xpath,String item)
	{
		WebElement element;
		element=driver.findElement(By.xpath(xpath));
		Select list=new Select(element);
		list.selectByVisibleText(item);		
	}
	
	
	
	
	
	
	
	
}
