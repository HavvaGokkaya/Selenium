package day02_webElement_Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverMethodlari {
    public static void main(String[] args) {
        //Yeni bir class olusturalim (Homework)
        //ChromeDriver kullanarak, facebook sayfasina gidin
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.facebook.com");

        // ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify),
        // degilse dogru basligi yazdirin.

        String expectedTitle = "facebook";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title testi PASSED");
        }else {
            System.out.println("Title testi FAILED \n" +
                    "Gerçekleşen title : "+actualTitle);
        }

        //Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin,
        // icermiyorsa “actual” URL’i yazdirin.

        String expectedicerik = "facebook";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedicerik)){
            System.out.println("URL testi PASSED");
        }else {
            System.out.println("URL testi FAILED\n" +
                    "gerçekleşen URL : "+actualUrl);
        }

        // https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com");
        // Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String walmartExpectedIcerik= "Walmart.com";
        String walmartActualTitle= driver.getTitle();

        if (walmartActualTitle.contains(walmartExpectedIcerik)){
            System.out.println("Walmart title testi PASSED");
        }else{
            System.out.println("Walmart title testi FAILED");
        }
        // Tekrar “facebook” sayfasina donun
        driver.navigate().back();

        // Sayfayi yenileyin
        driver.navigate().refresh();

        // Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
    }
}
