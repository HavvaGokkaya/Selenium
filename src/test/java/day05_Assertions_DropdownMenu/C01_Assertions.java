package day05_Assertions_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //	○ titleTest 	=> Sayfa başlığının “YouTube” oldugunu test edin
    //	○ imageTest 	=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //	○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //	○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    static WebDriver driver = new ChromeDriver();
@BeforeClass
    public static void setup(){
    WebDriverManager.chromedriver().setup();

    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("https://www.youtube.com");
}

@AfterClass
    public static void teardown(){
    driver.close();
}
@Test
    public void test01(){
    String actualTitle = driver.getTitle();
    String expectedTitle = "YouTube";
    Assert.assertEquals(expectedTitle,actualTitle);

}
@Test
    public void test02(){
    WebElement youtubeResim = driver.findElement(By.xpath("//yt-icon[@id='logo-icon'][1]"));
    Assert.assertTrue(youtubeResim.isDisplayed());
}

@Test
    public void test03(){
    WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='search']"));
    Assert.assertTrue(aramaKutusu.isEnabled());
}

@Test
    public void test04(){
    String expectedTitle = "youtube";
    String actualTitle = driver.getTitle();

    Assert.assertNotEquals(expectedTitle,actualTitle);
}
}
