package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sayfalar.AramaSayfasi;
import sayfalar.GlossSayfasi;
import sayfalar.Anasayfa;

import sayfalar.SepetimSayfasi;

public class Tests {
    static WebDriver driver;
    static Anasayfa anasayfa;
    static AramaSayfasi aramaSayfasi;
    static GlossSayfasi glossSayfasi;
    static SepetimSayfasi sepetimSayfasi ;
    static int milis= 1500;


@BeforeClass
public static void setUp() {

    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.rossmann.com.tr/");

    anasayfa = new Anasayfa(driver);
    aramaSayfasi = new AramaSayfasi(driver);
    glossSayfasi = new GlossSayfasi(driver);
    sepetimSayfasi = new SepetimSayfasi(driver);
}

   @AfterClass
   public static void tearDown(){
    driver.quit();

}

@Test
    public void test01() throws InterruptedException {

    anasayfa.gozukeneKadarBekleId(anasayfa.cookies);

    anasayfa.gozukeneKadarBekleCss(anasayfa.wpKapat);
    anasayfa.tiklaCss(anasayfa.wpKapat);
    anasayfa.tiklaId(anasayfa.cookies);

    anasayfa.tiklaId(anasayfa.aramaBox);

    anasayfa.yaziYazId(anasayfa.aramaBox,"Lip gloss");
    Thread.sleep(milis);
    anasayfa.tiklaXpath(anasayfa.enterBox);
    //  driver.switchTo().alert().accept();
    anasayfa.gozukeneKadarBekleCss(anasayfa.urunKontrol);
    anasayfa.kontrolCss(anasayfa.urunKontrol,"Lip gloss için arama sonuçları");

}

@Test
    public void test02(){
    aramaSayfasi.gozukeneKadarBekleXpath(aramaSayfasi.markaButonu);
    aramaSayfasi.tiklaXpath(aramaSayfasi.markaSec);
    aramaSayfasi.tiklaXpath(aramaSayfasi.dahaFazlaMarka);
    aramaSayfasi.tiklaXpath(aramaSayfasi.rivalSEc);
    aramaSayfasi.gozukeneKadarBekleXpath(aramaSayfasi.markaDogru);
    aramaSayfasi.kontrolXpath(aramaSayfasi.markaDogru, "Rival de Loop");

}

@Test
    public void test03(){
    aramaSayfasi.tiklaXpath(aramaSayfasi.plumpingSec);
    aramaSayfasi.urlKontrol("https://www.rossmann.com.tr/rival-de-loop-lipgloss-plumping-no-01-p-sr22110101");

}

@Test
    public void test04() throws InterruptedException {
    Thread.sleep(milis);
    glossSayfasi.tiklaXpath(glossSayfasi.sepeteEkle);
    Thread.sleep(milis);
    glossSayfasi.gozukeneKadarBekleCss(glossSayfasi.sepeteAttı);

    glossSayfasi.kontrolCss(glossSayfasi.sepeteAttı,"1");

}
    @Test
    public void test05() throws InterruptedException {

    glossSayfasi.tiklaCss(glossSayfasi.sepeteBas);
    glossSayfasi.ekranaYazdir(glossSayfasi.sepeteEklendiYazisi);
    glossSayfasi.tiklaXpath(glossSayfasi.alisverisiTamamla);
    glossSayfasi.gozukeneKadarBekleId(glossSayfasi.emailKutusu);
    glossSayfasi.gorunurlukKontrol(glossSayfasi.emailKutusu);

    }

    @Test
    public void test06() throws InterruptedException {

    glossSayfasi.tiklaId(glossSayfasi.emailKutusu);
    glossSayfasi.yaziYazId(glossSayfasi.emailKutusu, "earac265@gmail.com");
    sepetimSayfasi.tiklaId(sepetimSayfasi.isimYaz);
    sepetimSayfasi.yaziYazId(sepetimSayfasi.isimYaz, "Esra");
    sepetimSayfasi.tiklaId(sepetimSayfasi.soyadYaz);
    sepetimSayfasi.yaziYazId(sepetimSayfasi.soyadYaz, "Are");
    sepetimSayfasi.tiklaCss(sepetimSayfasi.adresYaz);
    sepetimSayfasi.yaziYazCss(sepetimSayfasi.adresYaz,"Ankara");

    sepetimSayfasi.tiklaId(sepetimSayfasi.ilSec);
    sepetimSayfasi.gozukeneKadarBekleXpath(sepetimSayfasi.ankaraSec);

    sepetimSayfasi.tiklaXpath(sepetimSayfasi.ankaraSec);
    sepetimSayfasi.tiklaId(sepetimSayfasi.ilceSec1);
    sepetimSayfasi.gozukeneKadarBekleXpath(sepetimSayfasi.ilceSec2);
    sepetimSayfasi.tiklaXpath(sepetimSayfasi.ilceSec2);
    sepetimSayfasi.tiklaId(sepetimSayfasi.telNoYaz);
    sepetimSayfasi.yaziYazId(sepetimSayfasi.telNoYaz, "1112223344");
    sepetimSayfasi.tiklaXpath(sepetimSayfasi.bireyselTikla);
    sepetimSayfasi.gozukeneKadarInId(sepetimSayfasi.tcKimlik);
    sepetimSayfasi.yaziYazId(sepetimSayfasi.tcKimlik, "11223334455");
    sepetimSayfasi.tiklaXpath(sepetimSayfasi.kaydet);
    sepetimSayfasi.gozukeneKadarBekleXpath(sepetimSayfasi.teslimatAdresi);
    sepetimSayfasi.liste();



    }


}