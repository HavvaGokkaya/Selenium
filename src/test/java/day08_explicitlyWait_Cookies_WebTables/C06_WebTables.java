package day08_explicitlyWait_Cookies_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C06_WebTables extends TestBase {

    @Test
    public void test01(){
        //  1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //  2. Headers da bulunan basliklari yazdirin
        List<WebElement> headerList = driver.findElements(By.xpath("//div[@role='columnheader']"));
        int basliksirano = 1;
        for (WebElement each:headerList
        ) {
            System.out.println(basliksirano+"---"+each.getText());
            basliksirano++;
        }
        //  3. 3.sutunun basligini yazdirin

        System.out.println(driver.findElement(By.xpath("(//div[@role='columnheader'])[3]")).getText());
        //  4. Tablodaki tum datalari yazdirin

        List<WebElement> dataListesi = driver.findElements(By.xpath("//div[@class='rt-td']"));

        int sirano=1;
        for (WebElement each:dataListesi
        ) {
            System.out.println(sirano+"--"+each.getText());
            sirano++;
        }
        //  5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin

        int count=0;
        for (WebElement each:dataListesi
        ) {
            if (!each.getText().isBlank()){
                count++;
            }
        }
        System.out.println(count+ "adet boş olmayan data vardır");
        //  6. Tablodaki satir sayisini yazdirin

        List<WebElement> satirlarList = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("Tabloda "+satirlarList.size()+" satır var.");

        //  7. Tablodaki sutun sayisini yazdirin

        List<WebElement> ilksatirSutunlari = driver.findElements(By.xpath("//div[@class='rt-tr-group'][1]//div[@class='rt-td']"));
        System.out.println("Tabloda "+ilksatirSutunlari.size()+" sütun var.");

        //  8. Tablodaki 3.kolonu yazdirin
        for (int i = 1; i <= satirlarList.size(); i++) {
            System.out.println(driver.findElement(By.xpath("//div[@class='rt-tr-group'][" + i + "]//div[@class='rt-td'][3]")).getText());
        }
        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        // 10. Bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde
        //     bana datayi yazdirsin
        writeData(2,4);
    }
    public void writeData(int satir,int sutun){


        String dataXpath ="//div[@class='rt-tr-group']["+satir+"]//div[@class='rt-td']["+sutun+"]";
        System.out.println(driver.findElement(By.xpath(dataXpath)).getText());

    }
}
