package com.primusbank.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.primusbank.constants.PrimusBankConstants;
import com.primusbank.library.AdminHomePage;
import com.primusbank.library.Bankerhomepage;
import com.primusbank.library.PrimusBankHomePage;
import com.utils.XlUtils;

public class PrimusBankBatchTest extends PrimusBankConstants  
{

	String uid,pwd,brname;
	
	
	@Test
	public void batchTest() throws IOException
	{
		String keywordfile="C:\\frameworks1130\\PrimusBank\\src\\com\\primusbank\\keywords\\PrimusBankKeywords.xlsx";
		String tcsheet="TestCases";
		String tssheet="TestSteps";
		String tcexeflag,tcid,tstcid,keyword,tsres,tcres;
		boolean res = false;
		
		
		
		
		int tccount,tscount;
		tccount=XlUtils.getRowCount(keywordfile, tcsheet);
		tscount=XlUtils.getRowCount(keywordfile, tssheet);
		
		PrimusBankHomePage phome=new PrimusBankHomePage();
		AdminHomePage ahome=new AdminHomePage();
		Bankerhomepage bhome=new Bankerhomepage();
		
		
		
		for (int i = 1; i <=tccount; i++) 
		{
			 tcexeflag=XlUtils.getCellData(keywordfile, tcsheet, i, 2);
			 if (tcexeflag.equalsIgnoreCase("y")) 
			 {
				tcid=XlUtils.getCellData(keywordfile, tcsheet, i, 0);
				for (int j = 1; j <=tscount ; j++) 
				{
					tstcid=XlUtils.getCellData(keywordfile, tssheet, j, 0);
					if (tcid.equalsIgnoreCase(tstcid)) 
					{
						keyword=XlUtils.getCellData(keywordfile, tssheet, j, 4);
						switch (keyword.toLowerCase()) 
						{
						case "adminlogin":
							uid=XlUtils.getCellData(keywordfile, tssheet, j, 5);
							pwd=XlUtils.getCellData(keywordfile, tssheet, j, 6);
							res=phome.adminLogin(uid, pwd);
							break;
						case "adminlogout":
							res=ahome.adminLogout();
							break;
						case "bankerlogin":
							brname=XlUtils.getCellData(keywordfile, tssheet, j, 5);
							uid=XlUtils.getCellData(keywordfile, tssheet, j, 6);
							pwd= XlUtils.getCellData(keywordfile, tssheet, j, 7);
							res=phome.bankerlogin(brname, uid, pwd);
							break;
						case "bankerlogout":
							res=bhome.bankerlogout();
							break;
						}
						if (res) 
						{
							tsres="Pass";
							XlUtils.setCellData(keywordfile, tssheet, j, 3, tsres);
							XlUtils.fillGreenColor(keywordfile, tssheet, j, 3);
						} else 
						{
							tsres="Fail";
							XlUtils.setCellData(keywordfile, tssheet, j, 3, tsres);
							XlUtils.fillRedColor(keywordfile, tssheet, j, 3);
						}
						
						//Code to update TestCase Result
						tcres=XlUtils.getCellData(keywordfile, tcsheet, i, 3);
						if (!tcres.equalsIgnoreCase("fail")) 
						{
							XlUtils.setCellData(keywordfile, tcsheet, i, 3, tsres);
						}
						tcres=XlUtils.getCellData(keywordfile, tcsheet, i, 3);
						if (tcres.equalsIgnoreCase("pass")) 
						{
							XlUtils.fillGreenColor(keywordfile, tcsheet, i, 3);
						} else 
						{
							XlUtils.fillRedColor(keywordfile, tcsheet, i, 3);
						}
						
						
					}
				} 
				 
				 
			 } else 
			 {
				 XlUtils.setCellData(keywordfile, tcsheet, i, 3, "Blocked");
				 XlUtils.fillRedColor(keywordfile, tcsheet, i, 3);
			 }
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
