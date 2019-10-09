import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.html.HTMLImageElement;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class travelocityCase1 {

    String url="https://www.travelocity.com";
    String browser="Chrome";

   static WebDriver driver = new ChromeDriver();
   static WebDriverWait wait = new WebDriverWait(driver, 10);

   // Abrir el navegador en la página
   protected static void initBrowser(String url, String browser){

       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.manage().window().maximize();
       driver.get(url);

   }

   protected static void selectFligt(String flyingFrom, String flyingTo) throws InterruptedException {

       WebElement flightsBtn = driver.findElement(By.id("tab-flight-tab-hp"));
       WebElement roundTripBtn = driver.findElement(By.id("flight-type-roundtrip-label-hp-flight"));
       WebElement flyingFromField = driver.findElement(By.id("flight-origin-hp-flight"));
       WebElement flyingToField = driver.findElement(By.id("flight-destination-hp-flight"));
       flightsBtn.click();
       roundTripBtn.click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flight-destination-hp-flight")));
       flyingFromField.sendKeys(flyingFrom);
      // Thread.sleep(1*1000);
       flyingToField.sendKeys(flyingTo);


   }



   protected static void selectDates(String departingYear, String departingMonth, String departingDate){

       //WebElement departingField = driver.findElement(By.id("flight-departing-hp-flight"));
       WebElement departingField = driver.findElement(By.xpath("//*[@id=\"flight-departing-wrapper-hp-flight\"]/label/span[2]"));
       WebElement returningField = driver.findElement(By.id("flight-returning-hp-flight"));
       WebElement departingDateDataPicker = driver.findElement(By.xpath("//button[@data-year='"+departingYear+"'" +
               "and @data-month='"+departingMonth+"' and @data-day='"+departingDate+"']"));
       //WebElement returningDate = driver.findElement(By.id());

       departingField.click();
       departingDateDataPicker.sendKeys(departingYear,departingMonth,departingDate);
       returningField.click();

   }


   protected static void closeBrowser(){
       driver.quit();
   }


}
