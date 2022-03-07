package core;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;

//    String data;
//    public static Object[][] getTableArray(String FilePath, String SheetName, int startCol, int totalCols) throws Exception {
//        String[][] tabArray = null;
//        try {
//            FileInputStream ExcelFile = new FileInputStream(FilePath);
//            // Access the required test data sheet
//            ExcelWBook = new XSSFWorkbook(ExcelFile);
//            ExcelWSheet = ExcelWBook.getSheet(SheetName);
//            int startRow = 1;
//            int ci, cj;
//            int totalRows = ExcelWSheet.getLastRowNum();
//            tabArray = new String[totalRows][totalCols];
//            ci = 0;
//            for (int i = startRow; i <= totalRows; i++, ci++) {
//                cj = 0;
//                for (int j = startCol; j < totalCols + startCol; j++, cj++) {
//                    tabArray[ci][cj] = getCellData(i,j);
//                    Cell = ExcelWSheet.getRow(i).getCell(j);
//                    System.out.println("p:" + tabArray[ci][cj]);
//                }
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("Could not read the Excel sheet");
//            e.printStackTrace();
//        } catch (IOException e) {
//            System.out.println("Could not read the Excel sheet");
//            e.printStackTrace();
//        }
//        return (tabArray);
//    }

    public static Object[][] getTableArray(String FilePath, String SheetName, int startCol, int totalCols) throws Exception {
        String[][] tabArray = null;
        try {
            FileInputStream ExcelFile = new FileInputStream(FilePath);
            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
            int startRow = 1;
            int ci, cj;
            int totalRows = ExcelWSheet.getLastRowNum();
            tabArray = new String[totalRows][totalCols];
            ci = 0;
            for (int i = startRow; i <= totalRows; i++, ci++) {
                cj = 0;
                for (int j = startCol; j < totalCols + startCol; j++, cj++) {
                    tabArray[ci][cj] = getCellData(i, j);
                    System.out.println("p:" + tabArray[ci][cj]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return (tabArray);
    }

    public static String getCellData(int RowNum, int ColNum) throws Exception {
        try {
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum,
                    org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            String CellData = Cell.getStringCellValue();
            return CellData;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw (e);
        }
    }

//    public static void writeExcel(String FilePath, String SheetName) throws IOException {
//        FileInputStream ExcelFile = new FileInputStream(FilePath);
//        // Access the required test data sheet
//        ExcelWBook = new XSSFWorkbook(ExcelFile);
//        ExcelWSheet = ExcelWBook.getSheet(SheetName);
//        XSSFRow row;
//        Set<String> keyid = BaseTest.lsTest.keySet();
//        int rowid = 1;
//        for (String key : keyid) {
//            row = ExcelWSheet.getRow(rowid++);
//            TestObject testObject = BaseTest.lsTest.get(key);
//            System.out.println(key);
//            org.apache.poi.ss.usermodel.Cell cellChrome = row.createCell(1);
//            cellChrome.setCellValue(testObject.getChromeStatus());
//            org.apache.poi.ss.usermodel.Cell cellFirefox = row.createCell(2);
//            cellFirefox.setCellValue(testObject.getFirefoxStatus());
//        }
//        FileOutputStream out = new FileOutputStream(new File(FilePath));
//        ExcelWBook.write(out);
//        out.close();
//    }
}
