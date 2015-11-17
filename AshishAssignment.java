package Login_To_Prod;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AshishAssignment {
    WebDriver driver;
    
    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception{

    	if(browser.equalsIgnoreCase("chrome")){
        
    		//set path to chromedriver.exe You may need to download it from http://code.google.com/p/selenium/wiki/ChromeDriver
    		System.setProperty("webdriver.chrome.driver","/home/nikh-o-hkin/Desktop/Selenium/setups/chromedriver");
    	    	
            driver = new ChromeDriver();
            driver.get("http://www.google.com/xhtml");
            driver.manage().window().maximize();
        	driver.manage().deleteAllCookies();         

        }

        else{
            //If no browser passed throw exception

            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void login() throws InterruptedException{
    	driver.get("http://www.walmart.com/");

    	driver.findElement(By.linkText("My Account")).click();	//Finding Login section onto landing page

    	try{
    		WebElement userName = driver.findElement(By.id("login-username"));
    		userName.sendKeys("ashishpandya2299@gmail.com");

    		WebElement password = driver.findElement(By.name("login-password"));
    		password.sendKeys("pass@123");

    		if(userName==null || password==null)
    		{
    			System.out.println("Username/Password field cannot be empty");
    		}
    	}
    	catch(NoSuchElementException e){
    		e.printStackTrace(); 
    	}
    	WebElement submitBtn = driver.findElement(By.xpath("//button[@class='btn login-sign-in-btn js-login-sign-in btn-block-max-s btn-block-max-s' and normalize-space(text()='Sign In')]"));
    	submitBtn.click();
    }
        @Test
        public void searchProduct() throws InterruptedException{

        	driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
        	driver.findElement(By.xpath("//div[@class='recent-orders']//h1[text()='Welcome to your Walmart account!']"));

        	WebElement searchField = driver.findElement(By.id("search"));	// to spot search field
        	searchField.clear();											//clearing if previously had any content
        	driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS); 
        	searchField.sendKeys("iphone 6");								// enter into search field search item

        	if(searchField!=null){
        		driver.findElement(By.xpath("//button[@class='searchbar-submit js-searchbar-submit']")).click();// click search icon
        	}
        	driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

        	//this element chooses 1st iphone 6 of user choice
        	driver.findElement(By.xpath("//h4//a[@href='/ip/Straight-Talk-Apple-iPhone-6-LTE-16GB-Prepaid-Smartphone/39665237']")).click();
        	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

        	driver.findElement(By.cssSelector("span.variant-swatch")).click();//to choose color of product
        }
        
        @Test
        public void addItemsToCart() throws InterruptedException{

   			//Select button " Add to Cart"
    			try{
    				WebElement addbtn = driver.findElement(By.id("WMItemAddToCartBtn"));

    				System.out.println("Add to Cart button exist "+addbtn);
    				if (addbtn!=null)
    					addbtn.click();
    			}catch(Exception e)
    			{
    				e.printStackTrace(); 
    				e.getMessage();
    				System.out.println("Unable to proceed as either the Add to Cart button is not visible or not selectable");

    			}         
    	//this line is to assert choosen product is in tray
    	assert(driver.findElement(By.className("cart-item-name js-product-title"))).equals("Straight Talk Apple iPhone 6 LTE 16GB Prepaid Smartphone");
    	
		WebElement prodCount = driver.findElement(By.xpath("//div[contains(@class='chooser-option-current')]"));
		
		if(prodCount!=null){
			System.out.println("Product is choosen");
		}
		else
			System.out.println("Please choose product for Checkout!!");

        }
        
    	@AfterTest
    	public void closeBrowser()
    	{
    		  driver.quit();
    	}
   }    

