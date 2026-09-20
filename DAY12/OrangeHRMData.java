package dataproviderOrange;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class OrangeHRMData {

    @DataProvider
    public Object[][] vacancyData()
            throws EncryptedDocumentException, IOException {

        FileInputStream fis =
                new FileInputStream(
                        "./src/test/resources/ORANGE/OrangeHRM.xlsx");

        Workbook wb = WorkbookFactory.create(fis);

        Sheet sh = wb.getSheet("Sheet1");

        int rowCount = sh.getLastRowNum();

        Object[][] obj = new Object[rowCount][5];

        for (int row = 1; row <= rowCount; row++) {

            obj[row - 1][0] =
                    sh.getRow(row).getCell(0).getStringCellValue();

            obj[row - 1][1] =
                    sh.getRow(row).getCell(1).getStringCellValue();

            obj[row - 1][2] =
                    sh.getRow(row).getCell(2).getStringCellValue();

            obj[row - 1][3] =
                    sh.getRow(row).getCell(3).getStringCellValue();

            obj[row - 1][4] =
                    sh.getRow(row).getCell(4).getStringCellValue();
        }

        wb.close();
        fis.close();

        return obj;
    }


    @DataProvider
    public Object[][] employeeData()
            throws EncryptedDocumentException, IOException {

        FileInputStream fis =
                new FileInputStream(
                        "./src/test/resources/ORANGE/OrangeHRM.xlsx");

        Workbook wb = WorkbookFactory.create(fis);

        Sheet sh = wb.getSheet("Sheet1");

        int rowCount = sh.getLastRowNum();

        Object[][] obj = new Object[rowCount][3];

        for (int row = 1; row <= rowCount; row++) {

            obj[row - 1][0] =
                    sh.getRow(row).getCell(5).getStringCellValue();

            obj[row - 1][1] =
                    sh.getRow(row).getCell(6).getStringCellValue();

            obj[row - 1][2] =
                    sh.getRow(row).getCell(7).getStringCellValue();
        }

        wb.close();
        fis.close();

        return obj;
    }
}
