package travelocity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TravelocityCase1 {

    // Se crea el objeto driver
    static WebDriver driver = new ChromeDriver();
    // Se crea el objeto wait
    static WebDriverWait wait = new WebDriverWait(driver, 10);
    // método para abrir la página travelocity

   protected static void initBrowser(String url, String browser){

       // Se define una espera implicita de 10 segundos
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // Se maximiza la ventana del navegador
       driver.manage().window().maximize();
       // Se abre la pagína definida
       driver.get(url);

   }

    // método para seleccionar el origen y el destino del vuelo

   protected static void selectFligt(String flyingFrom, String flyingTo) throws InterruptedException {

       // Se localiza en la página el botón Flights
       WebElement flightsBtn = driver.findElement(By.id("tab-flight-tab-hp"));
       // Se localiza en la página el botón RoundTrip
       WebElement roundTripBtn = driver.findElement(By.id("flight-type-roundtrip-label-hp-flight"));
       // Se localiza en la página el campo Flying From
       WebElement flyingFromField = driver.findElement(By.id("flight-origin-hp-flight"));
       // Se localiza en la página el campo Flying To
       WebElement flyingToField = driver.findElement(By.id("flight-destination-hp-flight"));

       // interacciones
       // click en el botón Flights
       flightsBtn.click();
       // click en el botón RoundTrip
       roundTripBtn.click();
       // Espera que el campo Flying From aparezca
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flight-origin-hp-flight")));
       // Espera que el campo Flying To aparezca
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flight-destination-hp-flight")));

       // Envía un origin al campo Flying From - LAS
       flyingFromField.sendKeys(flyingFrom);
       // Espera que la lista de elementos que coinciden con la búsqueda aparezcan y selecciona la opción correcta
       String flyingFromLink="//div[@class='multiLineDisplay' and contains(.,'"+flyingFrom+"')]";
       WebElement flyingFrom_Link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(flyingFromLink)));
       //Click en la opción seleccionada
       flyingFrom_Link.click();

       // Envía un destino al campo Flying To - LAX
       flyingToField.sendKeys(flyingTo);
       // Espera que la lista de elementos que coinciden con la búsqueda aparezcan y selecciona la opción correcta
       String flyingToLink="//div[@class='multiLineDisplay' and contains(.,'"+flyingTo+"')]";
       WebElement flyingTo_link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(flyingToLink)));
       //Click en la opción seleccionada
       flyingTo_link.click();
   }



   protected static void  selectDates(String monthDaP, String departingYear, String departingMonth, String departingDate){

       // Se localiza en la página el campo Departing
       WebElement departingField = driver.findElement(By.id("flight-departing-hp-flight"));
       // Se localiza en la página el campo Returning
       WebElement returningField = driver.findElement(By.id("flight-returning-hp-flight"));
       //Se selecciona el campo Departing
       departingField.click();

       List<WebElement> calendarMonth = driver.findElements(By.xpath("//*[contains(@class, 'datepicker-cal-month-header')]"));
       String month1= calendarMonth.get(0).getText();
       String month2= calendarMonth.get(1).getText();

       System.out.println("month 1 "+month1);
       System.out.println("month 2"+month2);
       System.out.println("monthDaP" + monthDaP);



       do{
           if(month1==monthDaP) {
               System.out.println("Acertaste Oct!");
               }

           else if (month2==monthDaP){
               System.out.println("Acertaste Nov!");
               }
           else{
               System.out.println("Intentalo de nuevo!");
           }
       }
       while(true);

 /*
       int month = Integer.parseInt(departingMonth);
       System.out.println("month string" + month);
       String monthCalendar="";
       switch(month){
           case 1:
               if(month  == 10) {
                   monthCalendar="Oct "+departingYear ;;
               }
               break;

           case 2:
               if(month  == 11) {
                   monthCalendar="Nov "+departingYear ;;
               }
               break;

               default:
               System.out.println("Invalid Month");
               break;
       }

       return  monthCalendar;*/
/*

       //Se localiza en la página el campo mes

       String monthDataPickerLo="//caption[@class='datepicker-cal-month-header' and contains(.,'"+monthDaP+"')]";
       WebElement monthDataPicker = driver.findElement(By.xpath(monthDataPickerLo));
       // Se localiza la fecha de salida del viaje
       WebElement departingDateDataPicker = driver.findElement(By.xpath("//button[@data-year='"+departingYear+"'" +
               "and @data-month='"+departingMonth+"' and @data-day='"+departingDate+"']"));
       //Se elige el día, mes y año
       departingDateDataPicker.sendKeys(departingYear,departingMonth,departingDate);
       //Se selecciona la fecha del viaje
       departingDateDataPicker.click();

      // returningField.click();*/
   }


   protected static void closeBrowser(){
       driver.quit();
   }


}
