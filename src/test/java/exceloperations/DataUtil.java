package exceloperations;

import java.util.Hashtable;

public class DataUtil 
{
	public static Object[][] getTestData(ExcelAPI e, String sheetName, String testName)
	{
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
