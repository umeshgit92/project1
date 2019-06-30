package com.primusbank.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.primusbank.constants.PrimusBankConstants;
import com.primusbank.library.Bankerhomepage;
import com.primusbank.library.PrimusBankHomePage;
import com.utils.XlUtils;



public class BankEmployeeLoginDDT  extends PrimusBankConstants
{
	public String xlfile="C:\\frameworks1130\\PrimusBank\\src\\com\\primusbank\\testdata\\TestData.xlsx";
	public String xlsheet="LoginData";
	int j=1;
	
	
	
    @Test(dataProvider="testData")
    public void bankerLogin(String brname,String uid,String pwd) throws IOException
    {
     PrimusBankHomePage phome=new PrimusBankHomePage();
     boolean res=phome.bankerlogin(brname, uid, pwd);
     Assert.assertTrue(res);
     Bankerhomepage bhome=new Bankerhomepage();
     bhome.bankerlogout();
     
     
     if(res)
     {
    	 XlUtils.setCellData(xlfile, xlsheet, j, 3, "pass");
    	 XlUtils.fillGreenColor(xlfile, xlsheet, j, 3);
    	 
     }
     else
     {
    	 XlUtils.setCellData(xlfile, xlsheet, j, 3, "fail");
    	 XlUtils.fillRedColor(xlfile, xlsheet, j, 3);
     }
     j++;
  }
    
    
    
    @DataProvider
    public Object[][] testData() throws IOException
    {
    	
    	
    	int rc=XlUtils.getRowCount(xlfile, xlsheet);
    	Object[][] data=new Object[rc][3];
    	for(int i=1;i<=rc;i++)
    	{
    		data[i-1][0]=XlUtils.getCellData(xlfile, xlsheet, i, 0);
    		data[i-1][1]=XlUtils.getCellData(xlfile, xlsheet, i,1);
    		data[i-1][2]=XlUtils.getCellData(xlfile, xlsheet, i,2);
 		
    		
     	}
    	
        return data;  	
    	
    	
    	
    	
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
}
