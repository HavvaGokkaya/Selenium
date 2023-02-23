package day03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CookiesGecme {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.google.com");

        // cookies'i kabul ederek cookies ekranini kapatin
        // driver.findElement(By.xpath("//div[text()='Accept all']")).click();

        // arama cubuguna Java yazip aratin
        WebElement aramaCubugu= driver.findElement(By.xpath("//input[@name='q']"));
        aramaCubugu.sendKeys("Java" + Keys.ENTER);

        // bulunan sonuc sayisinin 100binden cok oldugunu test edin
        String sonucYazisi = driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
        String[] sonucYazisiArr = sonucYazisi.split(" ");
        String sonucSayisiStr = sonucYazisiArr[1];
        sonucSayisiStr=sonucSayisiStr.replaceAll("\\D","");

        int actualSonucSayi = Integer.parseInt(sonucSayisiStr);
        int expectedSonucSayi = 100000;

        if (actualSonucSayi>expectedSonucSayi)
            System.out.println("Arama sonuc sayısı testi PASSED");
        else System.out.println("Arama sonuc sayısı testi FAILED");

        driver.close();
    }
}
