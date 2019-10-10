package travelocity;

import travelocity.TravelocityCase1;

public class TravelocityTest extends TravelocityCase1 {


     static String url="https://www.travelocity.com";
     static String browser="Chrome";
     static String flyingFrom="LAS";
     static String flyingTo="LAX";
     static String departingYear="2019";
     static String departingMonth="10";
     static String departingDate="19";
     static String monthDaPicker="Nov 2019";



    public static void main (String[] args) throws InterruptedException {

        // método para abrir la página travelocity
        initBrowser(url, browser);
        // método para seleccionar el origen y el destino del vuelo
        selectFligt(flyingFrom,flyingTo);
        // método para seleccionar la fecha de salida y de regreso del vuelo
        selectDates(monthDaPicker,departingYear,departingMonth,departingDate);

        // métod para cerrar el navegador
        closeBrowser();

    }


}
