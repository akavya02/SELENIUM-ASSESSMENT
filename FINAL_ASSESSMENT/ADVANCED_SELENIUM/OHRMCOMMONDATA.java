package FINALASSESSMENT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class OHRMCOMMONDATA {

    String browser;
    public String url;
    public String username;
    public String password;

    // Read data from properties file
    public void data() throws IOException {

        FileInputStream fis =new FileInputStream("./src/test/resources/FINALASSESSMENT/OrangeHRMASSESSMENT.properties");

        Properties p = new Properties();

        p.load(fis);

        browser = p.getProperty("browser");
        url = p.getProperty("url");
        username = p.getProperty("username");
        password = p.getProperty("password");

        fis.close();
    }

    // Read Buzz post from Excel
    @DataProvider
    public Object[][] buzzData()throws EncryptedDocumentException, IOException {

        FileInputStream fis =new FileInputStream("./src/test/resources/FINALASSESSMENT/FINALASSESSMENT.xlsx");

        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet("Sheet1");
        int rowCount = sh.getLastRowNum();
        Object[][] obj = new Object[rowCount][1];
        for (int row = 1; row <= rowCount; row++) {
            obj[row - 1][0] =sh.getRow(row).getCell(0).getStringCellValue();
        }

        wb.close();
        fis.close();

        return obj;
    }
}
