// Generated by Selenium IDE
package es.upm.dit.isst.webLab.tests;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
public class ExchangeRatesServletSeleniumTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
	System.setProperty( "webdriver.chrome.driver", "/home/narrietal/git/currency-exchange/chromedriver");
	driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void ExchangeRatesServletSeleniumTest() {
    driver.get("http://localhost:8085/CE/PrincipalServlet?email=");
    driver.manage().window().setSize(new Dimension(1365, 719));
    driver.findElement(By.linkText("Exchange rates")).click();
    driver.findElement(By.linkText("Choose currency to compare")).click();
    driver.findElement(By.linkText("EUR")).click();
    driver.findElement(By.linkText("Choose currency to compare")).click();
    driver.findElement(By.linkText("CHF")).click();
    {
      WebElement dropdown = driver.findElement(By.name("email"));
      dropdown.findElement(By.xpath("//option[. = 'Marta']")).click();
    }
    {
      WebElement element = driver.findElement(By.name("email"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.name("email"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.name("email"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.name("email")).click();
    driver.findElement(By.linkText("Exchange rates")).click();
    driver.findElement(By.linkText("Choose currency to compare")).click();
    driver.findElement(By.linkText("CHF")).click();
    driver.findElement(By.linkText("Choose currency to compare")).click();
    driver.findElement(By.linkText("AUD")).click();
    {
      WebElement dropdown = driver.findElement(By.name("email"));
      dropdown.findElement(By.xpath("//option[. = 'John']")).click();
    }
    {
      WebElement element = driver.findElement(By.name("email"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.name("email"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.name("email"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.name("email")).click();
    driver.findElement(By.linkText("Exchange rates")).click();
    assertThat(driver.findElement(By.cssSelector(".col-3")).getText(), is("1 GBP ="));
    {
      WebElement dropdown = driver.findElement(By.name("email"));
      dropdown.findElement(By.xpath("//option[. = 'Admin']")).click();
    }
    {
      WebElement element = driver.findElement(By.name("email"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.name("email"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.name("email"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.name("email")).click();
    driver.findElement(By.linkText("Exchange rates")).click();
    driver.findElement(By.linkText("Choose currency to compare")).click();
    driver.findElement(By.linkText("CAD")).click();
    assertThat(driver.findElement(By.cssSelector(".col-3")).getText(), is("1 CAD ="));
  }
}
