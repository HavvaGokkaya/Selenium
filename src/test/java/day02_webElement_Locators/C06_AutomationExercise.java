package day02_webElement_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_AutomationExercise {

    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class’i olusturun ilgili ayarlari yapin
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");
        //3- Sayfada 147 adet link bulundugunu test edin.
        List<WebElement> linkElementlerListesi = driver.findElements(By.tagName("a"));
        int actualLinkSayi = linkElementlerListesi.size();
        int expectedLinkSayi =147;

        if (actualLinkSayi==expectedLinkSayi){
            System.out.println("link sayisi testi PASSED");
        }else{
            System.out.println("Link sayisi testi FAILED" +
                    "\nSayfada var olan link sayisi : " + actualLinkSayi);
        }
        //4- Products linkine tiklayin

        driver.findElement(By.partialLinkText("Products")).click();
        //5- special offer yazisinin gorundugunu test edin
        WebElement offerYazi = driver.findElement(By.id("sale-image"));

        if (offerYazi.isDisplayed()){
            System.out.println("Special offer testi PASSED");
        }else{
            System.out.println("Special offer testi FAILED");
        }
        //6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();


    }
}
