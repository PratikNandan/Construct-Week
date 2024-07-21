package Test_Scenarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Page_Objects.item_search;
import io.github.bonigarcia.wdm.WebDriverManager;

public class test_methods {
	WebDriver driver;
	ExtentHtmlReporter htmlreporter;
	ExtentReports extnt;
	ExtentTest test;
	
	@BeforeTest
	public void bt() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		htmlreporter = new ExtentHtmlReporter("extent.html");
		extnt = new ExtentReports();
		extnt.attachReporter(htmlreporter);

		
	}
	
	@Test
	public void tsk() throws InterruptedException, IOException {
		test = extnt.createTest("Extent Test Report");
		item_search search = new item_search(driver);

        FileInputStream fis = new FileInputStream("E:\\MASAI\\UNIT 3\\Construct_Week.xlsx");
        Workbook wrkbk = new XSSFWorkbook(fis);
        Sheet sheet = wrkbk.getSheet("products");
        
        for (Row row : sheet) {
            search.cleaar();
            String productName = row.getCell(0).getStringCellValue();
            search.searchitem(productName);
            test.info("Entered Product Name : "+productName);
            search.clicksearch();
            test.info("Clicked on Search Icon");

            search.clickproduct(productName);
            test.info("Clicked on "+ productName );

            
            String res = driver.getTitle();      //assertion
            SoftAssert sa = new SoftAssert();
            sa.assertEquals(productName,res);
            System.out.println(productName+" Found - Assertion Successful");
            sa.assertAll();
            
            search.imageclick();
            test.info("Clicked on "+productName+ " Image");

    		search.next_img();
            test.info("Clicked on Next Image");

    		search.prev_img();
            test.info("Clicked on Previous Image");

    		search.close_img();
            test.info("Clicked on Close Image");

            //search.cleaar();
           // driver.navigate().back(); // Navigate back to perform next search
            
        }
	test.info("Test Run Successful.");
    extnt.flush();


        
        

		
		
		
		
		
		
		
		
		
		//item_search search = new item_search(driver);
		//String productname = "iPhone";
		//search.searchitem(productname);
		//search.clicksearch();
//		search.clickproduct(productname);
//		search.imageclick();
//		search.next_img();
//		Thread.sleep(2000);
//		search.prev_img();
//		Thread.sleep(2000);
//		search.close_img();
//		search.clear();
		//search.searchitem("Canon EOS 5D");
	//	search.clicksearch();
		//search.clickproduct();
		//search.imageclick();
			
	}
	
	@AfterTest
	public void at() {
		driver.close();
	}
	
	
	
	
	
//dnt
}
