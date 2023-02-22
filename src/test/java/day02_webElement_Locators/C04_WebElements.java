package day02_webElement_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WebElements {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // arama kutusunu locate edip bir webelement olarak kaydedin
        // id'si twotabsearchtextbox olan webelement seklinde locate edecegiz

        /*
            driver'a weblementi tarif etme islemine Locate ,
            bu tarifi yapabilmek icin kullanabilecegim degiskenlere de LOCATOR denir
            8 tane Locator vardir
            Locator'larin 6 tanesi webelement'in ozelliklerine baglidir
                - id
                - classname
                - name
                - tagname
                - linkText
                - partialLinkText
            Geriye kalan 2 locator ise her turlu webelementi locate etmek icin kullanilabilir
                - xpath
                - cssSelector
         */

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        // arama kutusuna "Nutella" yazip aratin

        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        driver.close();



    }
}
