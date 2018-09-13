package util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;


public class ExcelUtils {
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell xCell;

    

    
    

    //This method is to set the File path and to open the Excel file, from which we will gather Test Data from
    public static void setExcelFile(String Path,String SheetName) throws Exception {
        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(Path);

            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
        } catch (Exception e){
            throw (e);
        }       
    }

    
    

    
    
    //Gather Test Data
    public static String getCellDataOf(String cellContent) throws Exception {
    	//returns a cell Data based on the Header representing it and thus must first find the row of that Header(which will be passed into cellContent parameter), and once found, it will +1 to that row number and return the data
    	//note, the column number for this framework will always be fixed as 1 as it is only the row number that changes based on each Data Header
    	
        //Capture the row number of the CellContent, in other words the Data Header e.g. Email
        for (Row xRow : ExcelWSheet) {
            for (Cell cell : xRow) {
                    if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {
                        int theRowofInputData = xRow.getRowNum();  
                        
                        //returns the Data which is in the row captured within the variable 'theRowofInputData' and column 1
                        try{
                            xCell = ExcelWSheet.getRow(theRowofInputData).getCell(1);
                            return xCell.getStringCellValue();
                        }catch (Exception e){
                            return"";
                        }
                    }
            }
        }               
        return null;
    }

   
}





















