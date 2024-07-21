package Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class item_search {
	WebDriver driver;
	
	public item_search(WebDriver driver) {     //constructor
		this.driver = driver;
		
	}
		By searchbox = By.name("search");	
		
		
	// entering product name into searchbar
	public void searchitem(String searchinput) {
		// TODO Auto-generated method stub
		driver.findElement(searchbox).sendKeys(searchinput);
	}
	//clicking on search icon
	public void clicksearch() {
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	}
	
	//clicking on visible product
	public void clickproduct(String productname) throws InterruptedException {
		//driver.findElement(By.linkText("iPhone")).click();
		driver.findElement(By.linkText(productname)).click();
        Thread.sleep(2000);

		
		
				}
	
	//clicking on product image
	public void imageclick() {
		driver.findElement(By.xpath("(//a[@class='thumbnail'])[1]")).click();
		}
	
	public void next_img() throws InterruptedException {
		driver.findElement(By.xpath("//button[@title='Next (Right arrow key)']")).click();
        Thread.sleep(2000);


	}
	
	public void prev_img() throws InterruptedException {
		//title='Previous (Left arrow key)'
		driver.findElement(By.xpath("//button[@title='Previous (Left arrow key)']")).click();
        Thread.sleep(2000);

	}
	
	public void close_img() {
		driver.findElement(By.xpath("//button[@title='Close (Esc)']")).click();

	}
	
	public void cleaar() {
		driver.findElement(By.name("search")).clear();

	}
	
	
	
	
	
	
//dnt
}
