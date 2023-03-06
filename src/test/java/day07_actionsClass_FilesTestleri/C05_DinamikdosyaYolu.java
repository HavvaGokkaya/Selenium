package day07_actionsClass_FilesTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_DinamikdosyaYolu {

    @Test
    public void test01(){

        // Masaustumuzde theDelta.docx isimli bir dosya bulundugunu test edin

        String dosyaYolu = System.getProperty("user.home") + "/Desktop/Thedelta.docx";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
