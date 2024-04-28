package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import sayfalar.Anasayfa;
import sayfalar.AramaSayfasi;
import sayfalar.GlossSayfasi;
import sayfalar.SepetimSayfasi;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


public class Tests {
    static WebDriver driver;
    static Anasayfa anasayfa;
    static AramaSayfasi aramaSayfasi;
    static GlossSayfasi glossSayfasi;
    static SepetimSayfasi sepetimSayfasi ;
    static int beklemeSuresi= 1500;
    List <WebElement> teslimatBilgileri;

    /**
     * Bu test sınıfı, Rossman web sitesinin çeşitli özelliklerini test etmek için tasarlanmıştır.
     * Sınıf içindeki testler, Rossman web sitesinin farklı bölümlerini (anasayfa, arama, ürün detayları,
     * sepet işlemleri) test eder ve her bir test belirli bir özelliği kontrol eder.
     */


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

    @Test()

    public void test01() throws InterruptedException {

    //Bu test, bir e-ticaret sitesinde ürünün doğru bir şekilde arandığını kontrol eder.
    // Test adımları yanında belirtildiği gibidir.

    // Adım 1: Cookie bildirimi görüntülenir ve kabul edilir
     anasayfa.gorunurlukBekleById(anasayfa.cookiesElementi);
     anasayfa.mouseKaydirById(anasayfa.cookiesElementi);

    // Adım 2: Arama kutusu görüntülenir ve kutuya tıklanır
     anasayfa.gorunurlukBekleById(anasayfa.aramaBox);
    anasayfa.mouseKaydirById(anasayfa.aramaBox);

    // Adım 3: Arama kutusuna tıklanır ve "Lip gloss" metni girilir
    anasayfa.yaziYazById(anasayfa.aramaBox,"Lip gloss");
    anasayfa.tiklaByXpath(anasayfa.enterBox);

    // Adım 4: Arama sonuçları görüntülenir ve link aracılığıyla doğru sayfa olduğu kontrol edilir
    anasayfa.gorunurlukBekleByCss(anasayfa.urunKontrol);
    anasayfa.metinKontrolByCss("Arama Sonuçları: ",anasayfa.urunKontrol,"Lip gloss için arama sonuçları");

}

    @Test

    public void test02(){
    // Bu test, Rosmann sitesinde doğru marka seçildiğini kontrol eder.
    // Test adımları yanında belirtildiği gibidir.

    // Adım 1: Arama sayfasının yüklenmesi ve marka butonunun görünür hale gelmesi beklenir
    aramaSayfasi.gorunurlukBekleByXpath(aramaSayfasi.markaButonu);

    // Adım 2: Marka butonuna tıklanır ve marka seçim ekranı açılır
    aramaSayfasi.tiklaByXpath(aramaSayfasi.markaSec);

    // Adım 3: Daha fazla marka seçeneği görüntülenir hale gelene kadar beklenir ve tıklanır
    aramaSayfasi.gorunurlukBekleByXpath(aramaSayfasi.dahaFazlaMarka);
    aramaSayfasi.tiklaByXpath(aramaSayfasi.dahaFazlaMarka);

    // Adım 4: Rival de Loop markası seçilir
    aramaSayfasi.tiklaByXpath(aramaSayfasi.rivalSEc);

    // Adım 5: Seçilen markanın doğru bir şekilde görüntülenmesi beklenir ve doğru marka seçildiği test edilir
    aramaSayfasi.gorunurlukBekleByXpath(aramaSayfasi.markaDogru);
    aramaSayfasi.metinKontrolByXpath("Marka sonuçları: ",aramaSayfasi.markaDogru, "Rival de Loop");



}

    @Test

    public void test03() throws InterruptedException {

    // Bu test, Rossmann sitesinde ürünün doğru bir şekilde seçildiğini kontrol eder.
    // Test adımları yanında belirtildiği gibidir.

    // Adım 1: İstenilen ürünün görüntülenmesi beklenir ve istenilen ürüne tıklanır
    aramaSayfasi.gorunurlukBekleByXpath(aramaSayfasi.plumpingSec);
    aramaSayfasi.tiklaByXpath(aramaSayfasi.plumpingSec);

    // Adım 2: Doğru ürün seçildiği url aracılığıyla test edilir
    aramaSayfasi.urlKarsilastir("https://www.rossmann.com.tr/rival-de-loop-lipgloss-plumping-no-01-p-sr22110101");

}

    @Test

    public void test04() throws InterruptedException {

    // Bu test, Rossmann sitesinde bir ürünün sepete eklenip eklenmediğini kontrol eder.
    // Test adımları yanında belirtildiği gibidir.

    // Adım 1: Ürünü sepete eklemek için "Sepete ekle" butonuna basılır
    glossSayfasi.gorunurlukBekleByXpath(glossSayfasi.sepeteEkle);
    glossSayfasi.tiklaByXpath(glossSayfasi.sepeteEkle);
    Thread.sleep(beklemeSuresi);

    // Adım 2: Sepete eklendiğine dair sepette, "1" ifadesinin görülmesi beklenir ve test edilir
    glossSayfasi.gorunurlukBekleByCss(glossSayfasi.sepeteAtti);
    glossSayfasi.metinKontrolByCss("Sepete eklenen adet: ",glossSayfasi.sepeteAtti,"1");

}
    @Test

    public void test05() throws InterruptedException {
    // Bu test, Rossmann sitesinin,doğru bir şekilde bilgi girilme alanına yönlendirildiğini kontrol eder.
    // Test adımları yanında belirtildiği gibidir.

    // Adım 1: "Sepete eklendi" yazısı ekrana yazırılır ve Sepet'e gidilmesi için sepet simgesine basılır
    glossSayfasi.gorunurlukBekleByXpath(glossSayfasi.sepeteEklendiYazisi);
    glossSayfasi.ekranaYaz(glossSayfasi.sepeteEklendiYazisi);
    glossSayfasi.tiklaByCss(glossSayfasi.sepetSimgesineBas);


    // Adım 2: Açılan pencerede "Alışverişi Tamamla" butonuna basılır
    glossSayfasi.tiklaByXpath(glossSayfasi.alisverisiTamamla);

    // Adım 3: Bilgi girme adımına gelindiğini kontrol etmek amacıyla "email" kutusunun görünür olması beklenir test edilir
    glossSayfasi.gorunurlukBekleById(glossSayfasi.emailKutusu);
    glossSayfasi.gorunurlukKontrol(glossSayfasi.emailKutusu);

    }

    @Test

    public void test06() throws InterruptedException {
    // Bu test, Rossmann sitesinde geçesiz Tc bilgisi girilmesi sonucu testi geçememesi beklenir .
    // Test adımları yanında belirtildiği gibidir.

    // Adım 1: Doldurulması gereken kutular doldurulur ve "Kaydet" butonuna basılır
    glossSayfasi.tiklaById(glossSayfasi.emailKutusu);
    glossSayfasi.yaziYazById(glossSayfasi.emailKutusu, "earac265@gmail.com");
    sepetimSayfasi.tiklaById(sepetimSayfasi.isimYaz);
    sepetimSayfasi.yaziYazById(sepetimSayfasi.isimYaz, "Esra");
    sepetimSayfasi.tiklaById(sepetimSayfasi.soyadYaz);
    sepetimSayfasi.yaziYazById(sepetimSayfasi.soyadYaz, "Are");
    sepetimSayfasi.tiklaByCss(sepetimSayfasi.adresYaz);
    sepetimSayfasi.yaziYazByCss(sepetimSayfasi.adresYaz,"Ankara");
    sepetimSayfasi.tiklaById(sepetimSayfasi.ilSec);
    sepetimSayfasi.gorunurlukBekleByXpath(sepetimSayfasi.ankaraSec);
    sepetimSayfasi.tiklaByXpath(sepetimSayfasi.ankaraSec);
    sepetimSayfasi.tiklaById(sepetimSayfasi.ilceSec1);
    sepetimSayfasi.gorunurlukBekleByXpath(sepetimSayfasi.ilceSec2);
    sepetimSayfasi.tiklaByXpath(sepetimSayfasi.ilceSec2);
    sepetimSayfasi.tiklaById(sepetimSayfasi.telNoYaz);
    sepetimSayfasi.yaziYazById(sepetimSayfasi.telNoYaz, "1112223344");
    sepetimSayfasi.tiklaByXpath(sepetimSayfasi.bireyselTikla);
    sepetimSayfasi.gozukeneKadarInId(sepetimSayfasi.tcKimlik);
    sepetimSayfasi.yaziYazById(sepetimSayfasi.tcKimlik, "11223334455");
    sepetimSayfasi.tiklaByXpath(sepetimSayfasi.kaydet);

    // Adım 2: Yanlış Tc girildiğinde kabul etmediği test edilir
    sepetimSayfasi.gorunurlukBekleByXpath(sepetimSayfasi.uyariBekle);
    sepetimSayfasi.tcKimlikKontrol();

    }

    //  @Test

    //  public void test07(){
    // Bu test, bir e-ticaret sitesinde girilen bilgilerin doğru olduğunu kontrol eder.
     // Test adımları yanında belirtildiği gibidir.
     // Adım 1: Testin bu adımı doğru tc ile girildiğinde diğer bilgilerin doğrulunu kontrol etmeyi amaçlar.
     // test06'da tcKimlik alanını geçerli olarak doldurarak testin bu kısmını inceleyebilirsiniz.
    // sepetimSayfasi.liste();}



}