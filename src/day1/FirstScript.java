package day1;

//import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;

import static org.junit.Assert.*;


//import org.testng.annotations.BeforeTest;




//import dev.failsafe.internal.util.Assert;

public class FirstScript {

	@SuppressWarnings("deprecation")
	@Test
	public  void main() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Games\\Chahine Saman\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();

//		 Step 1 : Go To https://www.saucedemo.com/
		
		driver.get("https://www.saucedemo.com/");
		
//		Step 2 : Login with the provided credentials from the website itself.
		
		driver.findElement(By.id("user-name"));
		
		WebElement username=driver.findElement(By.id("user-name"));
		
		driver.findElement(By.id("password"));
		
		WebElement password=driver.findElement(By.id("password"));
		
		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement login=driver.findElement(By.id("login-button"));
		login.click();
		
			
		String actualUrl="https://www.saucedemo.com/inventory.html";
		String expectedUrl= driver.getCurrentUrl();
//		Assert.isTrue(actualUrl== expectedUrl);
////		Assert.assertEquals(expectedUrl,actualUrl);
		assertSame(actualUrl,expectedUrl);
		
		
		
		
//		driver.close();
		
//		Step 3 : Add to cart “Sauce Labs Backpack” item.
		
		WebElement addToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		addToCart.click();
		
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//		Step 4 : Navigate to the cart and assert quantity and item description.
		
		WebElement navigateToCart = driver.findElement(By.id("shopping_cart_container"));
		navigateToCart.click();
		
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//		Step 5 : Remove the item and assert cart is empty.
		
		WebElement remove = driver.findElement(By.id("remove-sauce-labs-backpack"));
		remove.click();
		
		
		
		WebElement checkCartForItem = driver.findElement(By.id("item_4_title_link"));  
		Assert.assertEquals(true, checkCartForItem.isDisplayed());
		System.out.println(" Cart contains item  – Assert passed ");
		
		
		WebElement navigateToHome = driver.findElement(By.id("continue-shopping"));
		navigateToHome.click();
		
//		Step 6 : Add another item “Test.allTheThings() T-Shirt (Red)” to the cart.
		
		WebElement addToCart1 = driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)"));
		addToCart1.click();
		
		WebElement navigateToCart1 = driver.findElement(By.id("shopping_cart_container"));
		navigateToCart1.click();
		
//		Step 7 : Click check out
		
		WebElement checkOut = driver.findElement(By.id("checkout"));
		checkOut.click();
		 
//		Step 8 : Click “CONTINUE” without filling any form and assert error message.
		
		WebElement continue1 = driver.findElement(By.id("continue"));
		continue1.click();
		
		String actual_msg = driver.findElement(By.xpath("//button[@class='error-message-container error']")).getText();
	
		String expect= "Error: Information is Required";
		
		Assert.assertEquals(actual_msg, expect);
		
//		Step 9 : Fill the form and verify checkout complete.
		
		
		driver.findElement(By.id("first-name"));
		
		WebElement firstname = driver.findElement(By.id("first-name"));
		
		driver.findElement(By.id("last-name"));
		
		WebElement lastname=driver.findElement(By.id("last-name"));
		
		driver.findElement(By.id("postal-code"));
		
		WebElement postalcode=driver.findElement(By.id("postal-code"));
		
		firstname.sendKeys("Abiral");
		lastname.sendKeys("Paudyal");
		postalcode.sendKeys("44600");
		
		WebElement continue2 = driver.findElement(By.id("continue"));
		continue2.click();
		
		WebElement finish = driver.findElement(By.id("finish"));
		finish.click();
		
		WebElement backToProducts = driver.findElement(By.id("back-to-products"));
	    backToProducts.click();
		
		WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
		menuButton.click();
	
//		Step 10 Logout and verify Login Page.
		
		WebElement logOut = driver.findElement(By.id("logout_sidebar_link"));
		logOut.click();
		
		String actualUrl1="https://www.saucedemo.com/";
		
		String expectedUrl1= driver.getCurrentUrl();
		
		Assert.assertEquals(expectedUrl1,actualUrl1);
		
		
		
		
		
		
		
		

//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

}
