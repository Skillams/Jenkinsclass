package exceloperations;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataManagementwithDataprovider 
{
	
  @Test(dataProvider = "getdata")
  public void f(String RunMode, String Browser,String UserName,String UserPassword) 
  {
	  
  }

  @DataProvider
  public Object[][] getdata() throws Exception 
  {
	   ExcelAPI e = new ExcelAPI("C:\\Users\\ravi\\Desktop\\suitex.xlsx");
		String sheetName = "data";
		String testName = "TestB";
		
		//To find the matching testcase RowNumber
		int testStartRowNum = 0;
		while(!e.getCellData(sheetName, 0, testStartRowNum).equals(testName))
		{
			testStartRowNum++;
		}
		System.out.println("Test start row Number : " + testStartRowNum );
		
		
		int colStartRowNum = testStartRowNum+1;
		int dataStartRowNum = testStartRowNum+2;
		
		//Calculate the rows of data
		int rows = 0;
		while(!e.getCellData(sheetName, 0, dataStartRowNum+rows).equals(""))
		{
			rows++;
		}
		System.out.println("Total rows are : " + rows);
		
		//Calculate the cols of Data
		int cols = 0;
		while(!e.getCellData(sheetName, cols, colStartRowNum).equals(""))
		{
			cols++;
		}
		System.out.println("Total cols are : " +  cols);
		
		//Read the test data
		int dataRow = 0 ;
		Object[][] data = new Object[rows][cols];
		for(int rnum =dataStartRowNum;rnum<dataStartRowNum+rows;rnum++)
		{
			for(int cnum=0;cnum<cols;cnum++)
			{
				//System.out.println(e.getCellData(sheetName, cnum, rnum));
				data[dataRow][cnum] = e.getCellData(sheetName, cnum, rnum);
			}
			dataRow++;
		}
		return data;

  }
}
