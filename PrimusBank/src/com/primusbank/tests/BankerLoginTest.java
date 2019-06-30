package com.primusbank.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.primusbank.constants.PrimusBankConstants;
import com.primusbank.library.Bankerhomepage;
import com.primusbank.library.PrimusBankHomePage;

public class BankerLoginTest extends PrimusBankConstants{
	
	@Parameters({"bname","uid","pwd"})
	@Test
	public void bankerlogin(String bname,String uid,String pwd)
	{
		PrimusBankHomePage phome=new PrimusBankHomePage();
		boolean res=phome.bankerlogin(bname, uid,pwd);
		Assert.assertTrue(res);
		Bankerhomepage bhome=new Bankerhomepage();
		bhome.bankerlogout();
	}
	
	}
