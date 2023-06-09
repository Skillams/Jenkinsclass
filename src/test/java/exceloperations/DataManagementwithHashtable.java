package exceloperations;

import org.testng.annotations.Test;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;

public class DataManagementwithHashtable 
{
	
  @Test(dataProvider = "getdata")
  public void f(Hashtable<String, String> obj)  
  {
	  
  }

  @DataProvider
  public Object[][] getdata() throws Exception 
  {
	  ExcelAPI e = new ExcelAPI("C:\\Users\\ravi\\Desktop\\suitex.xlsx");
		String sheetName = "data";
		String testName = "Test";
		
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
		Object[][] data = new Object[rows][1];
		Hashtable<String, String> table = null;
		for(int rnum =dataStartRowNum;rnum<dataStartRowNum+rows;rnum++)
		{
			table = new Hashtable<String, String>();
			for(int cnum=0;cnum<cols;cnum++)
			{
				//System.out.println(e.getCellData(sheetName, cnum, rnum));
				//data[dataRow][cnum] = e.getCellData(sheetName, cnum, rnum);
				String key = e.getCellData(sheetName, cnum, colStartRowNum);
				String value = e.getCellData(sheetName, cnum, rnum);
				table.put(key, value);
			}
			data[dataRow][0]= table;
			dataRow++;
		}
		return data;
  }
}
