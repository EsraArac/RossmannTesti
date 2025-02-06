package tests;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
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
    static int beklemeSuresi= 1500;


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
        //driver.quit();

    }

    @Test

    public void test01() throws InterruptedException {
//        anasayfa.gorunurlukBekleCss(anasayfa.reklamCarpi);
//        anasayfa.tiklaCss(anasayfa.reklamCarpi);
        anasayfa.tiklaByXpath(anasayfa.aramaBox);
        anasayfa.yaziYazXpath(anasayfa.aramaBox,"Lip gloss");
        Thread.sleep(beklemeSuresi);


        anasayfa.gorunurlukBekleCss(anasayfa.urunKontrol);
        anasayfa.metinKontrolCss(anasayfa.urunKontrol,"Lip gloss için arama sonuçları");

    }

    @Test

    public void test02() throws InterruptedException{
        Thread.sleep(beklemeSuresi);
        aramaSayfasi.gorunurlukBekleXpath(aramaSayfasi.markaButonu);
        aramaSayfasi.tiklaByXpath(aramaSayfasi.markaSec);
        aramaSayfasi.tiklaByXpath(aramaSayfasi.dahaFazlaMarka);
        aramaSayfasi.tiklaByXpath(aramaSayfasi.rivalSEc);
        aramaSayfasi.gorunurlukBekleXpath(aramaSayfasi.markaDogru);
        aramaSayfasi.kontrolXpath(aramaSayfasi.markaDogru, "Rival de Loop");


    }

    @Test

    public void test03(){
        aramaSayfasi.tiklaByXpath(aramaSayfasi.plumpingSec);
        aramaSayfasi.urlKarsilatir("https://www.rossmann.com.tr/p-sr22110101");

    }

    @Test

    public void test04() throws InterruptedException {
        Thread.sleep(beklemeSuresi);
        glossSayfasi.tiklaByXpath(glossSayfasi.sepeteEkle);
        Thread.sleep(beklemeSuresi);
        glossSayfasi.gorunurlukBekleCss(glossSayfasi.sepeteAttı);

        glossSayfasi.metinKontrolCss(glossSayfasi.sepeteAttı,"1");

    }
    @Test

    public void test05() throws InterruptedException {

        glossSayfasi.tiklaCss(glossSayfasi.sepeteBas);
        glossSayfasi.ekranaYazdir(glossSayfasi.sepeteEklendiYazisi);
        glossSayfasi.tiklaByXpath(glossSayfasi.alisverisiTamamla);
        glossSayfasi.gozukeneKadarBekleId(glossSayfasi.emailKutusu);
        glossSayfasi.gorunurlukKontrol(glossSayfasi.emailKutusu);

    }

    @Test

    public void test06() throws InterruptedException {

        glossSayfasi.tiklaById(glossSayfasi.emailKutusu);
        glossSayfasi.yaziYazId(glossSayfasi.emailKutusu, "earac265@gmail.com");
        sepetimSayfasi.tiklaById(sepetimSayfasi.isimYaz);
        sepetimSayfasi.yaziYazId(sepetimSayfasi.isimYaz, "Esra");
        sepetimSayfasi.tiklaById(sepetimSayfasi.soyadYaz);
        sepetimSayfasi.yaziYazId(sepetimSayfasi.soyadYaz, "Are");
        sepetimSayfasi.tiklaCss(sepetimSayfasi.adresYaz);
        sepetimSayfasi.yaziYazCss(sepetimSayfasi.adresYaz,"Ankara");

        sepetimSayfasi.tiklaById(sepetimSayfasi.ilSec);
        sepetimSayfasi.gorunurlukBekleXpath(sepetimSayfasi.ankaraSec);

        sepetimSayfasi.tiklaByXpath(sepetimSayfasi.ankaraSec);
        sepetimSayfasi.tiklaById(sepetimSayfasi.ilceSec1);
        sepetimSayfasi.gorunurlukBekleXpath(sepetimSayfasi.ilceSec2);
        sepetimSayfasi.tiklaByXpath(sepetimSayfasi.ilceSec2);
        sepetimSayfasi.tiklaById(sepetimSayfasi.telNoYaz);
        sepetimSayfasi.yaziYazId(sepetimSayfasi.telNoYaz, "1112223344");
        sepetimSayfasi.tiklaByXpath(sepetimSayfasi.bireyselTikla);
        sepetimSayfasi.gozukeneKadarInId(sepetimSayfasi.tcKimlik);
        sepetimSayfasi.yaziYazId(sepetimSayfasi.tcKimlik, "11223334455");
        sepetimSayfasi.tiklaByXpath(sepetimSayfasi.kaydet);
        sepetimSayfasi.gorunurlukBekleXpath(sepetimSayfasi.teslimatAdresi);
        sepetimSayfasi.liste();



    }
}
