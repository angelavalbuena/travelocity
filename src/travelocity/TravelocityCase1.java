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

    protected static void initBrowser(String url, String browser) {

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
        String flyingFromLink = "//div[@class='multiLineDisplay' and contains(.,'" + flyingFrom + "')]";
        WebElement flyingFrom_Link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(flyingFromLink)));
        //Click en la opción seleccionada
        flyingFrom_Link.click();

        // Envía un destino al campo Flying To - LAX
        flyingToField.sendKeys(flyingTo);
        // Espera que la lista de elementos que coinciden con la búsqueda aparezcan y selecciona la opción correcta
        String flyingToLink = "//div[@class='multiLineDisplay' and contains(.,'" + flyingTo + "')]";
        WebElement flyingTo_link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(flyingToLink)));
        //Click en la opción seleccionada
        flyingTo_link.click();
    }


    protected static void selectDates(String monthDaP, String departingYear, String departingMonth, String departingDate) {

        // Se localiza en la página el campo Departing
        WebElement departingField = driver.findElement(By.id("flight-departing-hp-flight"));
        // Se localiza en la página el campo Returning
        WebElement returningField = driver.findElement(By.id("flight-returning-hp-flight"));
        //Se selecciona el campo Departing
        departingField.click();
        boolean monthFound = false;

        String month = getMonth(departingMonth);
        do {
            List<WebElement> calendarMonth = driver.findElements(By.xpath("//*[contains(@class, 'datepicker-cal-month-header')]"));
            String month1 = calendarMonth.get(0).getText();
            String month2 = calendarMonth.get(1).getText();


            //x, y e z
            if(month1.equals(month + " " + departingYear) || month2.equals(month + " " + departingYear)) {
                monthFound = true;
            } else {
                //hay que darle click al boton de next
                WebElement botonNext = driver.findElement(By.cssSelector(".datepicker-next"));
                botonNext.click();
            }
        } while (monthFound == false);
        WebElement tableMes = driver.findElement(By.xpath("//table[contains(., '"+month+ " "+ departingYear + "')]"));
        WebElement diaCorrecto = tableMes.findElement(By.xpath("//button[@data-day='"+departingDate+"']"));
        diaCorrecto.click();



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

    private static String getMonth(String departingMonth) {
        switch (departingMonth) {
            case "1":
                return "Jan";
            case "2":
                return "Feb";

            case "3":
                return "Mar";

            case "4":
                return "Apr";

            case "5":
                return "May";

            case "6":
                return "Jun";

            case "7":
                return "Jul";

            case "8":
                return "Aug";

            case "9":
                return "Sep";

            case "10":
                return "Oct";

            case "11":
                return "Nov";

            case "12":
                return "Dec";


        }
        return null;
    }


    protected static void closeBrowser() {
        driver.quit();
    }


}
