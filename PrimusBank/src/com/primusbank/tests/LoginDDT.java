package com.primusbank.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDDT  
{
	
	@Test(dataProvider="testData")
	public void loginTest(String uid,String pwd)
	{
		System.out.println(uid+" "+pwd);
	}	

	@DataProvider
	public Object[][] testData()
	{
		Object[][] data=new Object[3][2]; 
		//First Row
		data[0][0]="uid1";
		data[0][1]="pwd1";
		
		//Second Row
		data[1][0]="uid2";
		data[1][1]="pwd2";
		
		//third Row
		data[2][0]="uid3";
		data[2][1]="pwd3";		
		return data;		
	}
	
	
	
	
	
	
	
	
	
	
	
}
