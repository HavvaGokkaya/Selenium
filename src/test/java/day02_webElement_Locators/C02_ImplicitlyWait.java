package day02_webElement_Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ImplicitlyWait {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

         /*
            driver'i bir web uygulamasina gonderdigimizde
            o sayfanin acilmasi,
            orada istedigimiz islemleri yapmak icin elementleri bulmasi... gibi islemler
            zaman gerektirebilir

            implicitlyWait bu tur zaman isteyen islemler icin
            driver'in max. ne kadar bekleyecegini belirler
         */


    }
}
