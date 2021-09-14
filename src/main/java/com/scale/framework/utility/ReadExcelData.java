package com.scale.framework.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

public class ReadExcelData {

    private static Workbook WORK_BOOK;
    private static Sheet WORK_SHEET;
    private static String TESTDATA_FILE_PATH = System.getProperty("user.dir")  + "\\src\\test\\resources\\TestData\\TestData.xlsx";


    /**
     * Reads data from excel file
     *
     * @param sheetName Name of sheet to be accessed within the excel work book
     *
     * @return Map<String, Map<String, String>>
     *
     * @exception EncryptedDocumentException If the work book given is password protected
     * @exception FileNotFoundException If an error occurs while reading the data
     * @exception IOException If an I/O error occurs while opening or creating the file
     *
     */
    public static Map<String, Map<String, String>> extractData(String sheetName){
        Map<String, String> singleRow = new HashMap<>();
        Map<String, Map<String, String>> multipleRows = new HashMap<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(TESTDATA_FILE_PATH);
            WORK_BOOK = WorkbookFactory.create(fis);
        } catch (EncryptedDocumentException e) {
            System.out.println("Encrypt exception in getTestData method: " + e.getMessage());
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception in getTestData method: "  + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO exception in getTestData method: " + e.getMessage());
            e.printStackTrace();
        }

        WORK_SHEET = WORK_BOOK.getSheet(sheetName);
        for(int row = 0; row < WORK_SHEET.getLastRowNum(); row++){
            String key = null;
            singleRow = new HashMap<>();
            for(int col = 0; col < WORK_SHEET.getRow(0).getLastCellNum(); col++){
                Cell cell  = WORK_SHEET.getRow(row + 1).getCell(col);
                String column = WORK_SHEET.getRow(0).getCell(col).getStringCellValue();

                if(cell.getCellType() == CellType.BLANK){
                    singleRow.put(column, "-");
                    if (key == null)
                        key = "-";
                } else if(cell.getCellType() == CellType.BOOLEAN){
                    singleRow.put(column, cell.getBooleanCellValue()+"");
                    if (key == null)
                        key = cell.getBooleanCellValue()+"";
                } else if(cell.getCellType() == CellType.STRING){
                    singleRow.put(column, cell.getStringCellValue());
                    if (key == null)
                        key = cell.getStringCellValue();
                } else if(DateUtil.isCellDateFormatted(cell)){
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    String formattedDate = sdf.format(cell.getDateCellValue());
                    singleRow.put(column, formattedDate);
                    if (key == null)
                        key = formattedDate;
                } else if(cell.getCellType() == CellType.NUMERIC){
                    String numericValue = NumberToTextConverter.toText(cell.getNumericCellValue());
                    singleRow.put(column, numericValue);
                    if (key == null)
                        key = numericValue;
                } else {
                    System.out.println("Cell type is unknown in test data file");
                }
            }
            multipleRows.put(key, singleRow);
        }
        return multipleRows;
    }
}
