package util;

import java.io.File;
import java.io.FileInputStream;


import jxl.Sheet;
import jxl.Workbook;

public class ReadExcelFile extends Base{
	

	
	File src = new File (readPropertiesFile("PathofExcelSheet"));
	FileInputStream fls;
	Workbook wb ;
	Sheet sh = null ;	
	
	public Sheet getSheet()
	{
		try
		{		
		 fls = new FileInputStream(src);		
		 wb = Workbook.getWorkbook(fls);		
		 sh = wb.getSheet(readPropertiesFile("ExcelSheetName"));
		}
		catch (Exception e)
		{
		System.out.println();
		}
		return sh;
	}
	
	public String readExcel(int rowNum, String colName)
	{	
		getSheet();
		return sh.getCell(findColumnIndex(sh, colName ), rowNum).getContents();
	}
	
	public int findColumnIndex(Sheet sheetName, String ColumnName )
	{
		int colIndex =-1;
		for(int i=0;i<sheetName.getColumns();i++)
		{
			if(ColumnName.equalsIgnoreCase(sheetName.getCell(i, 0).getContents()))
			{
				colIndex =i;
				break;
			}
		}
		return colIndex;
	}
	
	public int totalNumberOfRow()
	{
		getSheet();
		return sh.getRows();
	}

}
