package sayfalar;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Komutlar {
    /**
     * Komutlar sınıfı, WebDriver üzerinde sıklıkla kullanılan bazı işlevleri içeren yardımcı bir sınıftır.
     * Bu sınıf, web elementlerine tıklama, yazı yazma, metin kontrolü, görünürlük kontrolü, bekleme, fare işlemleri ve diğer bazı yardımcı işlevleri içerir.
     */
    WebDriver driver;
    static int beklemeSuresi = 1500;
    static SoftAssert softAssert;
    static List<WebElement> teslimatBilgileri ;
    List<String> classList = new ArrayList<>();




    public Komutlar(WebDriver driver) {
        this.driver = driver;
    }

    public void tiklaById(String elementId){
        // Belirtilen id elementine tıklamak için kullanılan metot.
        driver.findElement(By.id(elementId)).click();

    }

    public void tiklaByXpath(String elementId){
        // Belirtilen xpath elementine tıklamak için kullanılan metot.
        driver.findElement(By.xpath(elementId)).click();

    }

    public void tiklaByCss(String elementId){
        // Belirtilen css elementine tıklamak için kullanılan metot.
        driver.findElement(By.cssSelector(elementId)).click();

    }

     public void yaziYazById(String elementId,String yaziId){

         // Belirtilen id elementine yazı yazmak için kullanılan metot.
         driver.findElement(By.id(elementId)).sendKeys(yaziId);

     }

    public void yaziYazByCss(String elementId,String yaziId){

        // Belirtilen css elementine yazı yazmak için kullanılan metot.
        driver.findElement(By.cssSelector(elementId)).sendKeys(yaziId);

    }

    public void metinKontrolByCss(String sonucId,String bulunanId,String aratilanId){

      // Belirtilen css elementine doğru metin girildiğini kontrol etmek için kullanılan metot.
      String bulunanArama = driver.findElement(By.cssSelector(bulunanId)).getText();
         System.out.println(sonucId+bulunanArama);
      Assert.assertEquals(bulunanArama,aratilanId);


     }

    public void metinKontrolByXpath(String sonucId, String bulunanId,String aratilanId){

        // Belirtilen xpath elementine doğru metin girildiğini kontrol etmek için kullanılan metot.
        String bulunanArama = driver.findElement(By.xpath(bulunanId)).getText();
        System.out.println(sonucId+bulunanArama);
        Assert.assertEquals(bulunanArama,aratilanId);


    }

    public void gorunurlukKontrol (String elementId){

        // Belirtilen elementin görünürlüğünü kontrol etmek için kullanılan metot.
        WebElement emailKutusu = driver.findElement(By.id(elementId));
        boolean kutuGor = emailKutusu.isDisplayed();
        Assert.assertTrue(kutuGor);

    }


     public void gorunurlukBekleByCss (String elementId){
         // Belirtilen css elementinin görünür olduğunu kontrol etmek için kullanılan metot.
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25L));
         wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementId)));

     }

    public void gorunurlukBekleByXpath (String elementId){

        // Belirtilen xpath elementinin görünür olduğunu kontrol etmek için kullanılan metot.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25L));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementId)));

    }
    public void gorunurlukBekleById (String elementId){

        // Belirtilen id elementinin görünür olduğunu kontrol etmek için kullanılan metot.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25L));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(elementId)));

    }

    public void urlKarsilastir (String beklenenUrl){
     //Sayfa url'ini alarak belirlenen url ile karşılaştıran metot.
     String urlContr= driver.getCurrentUrl();
     Assert.assertEquals(urlContr,beklenenUrl);


    }

    public void ekranaYaz (String elementId){

    //Ekrana istenen elementin metnini yazdıran metot.
    String yazdiralim=  driver.findElement(By.xpath(elementId)).getText();
        System.out.println("Şuanki işleminiz: "+yazdiralim);

    }


    public void mouseKaydirByXpath (String elementId) throws InterruptedException {

        //İstenen xpath elementine doğru fare hareketi sağlayan metot.
        WebElement sec = driver.findElement(By.xpath(elementId));
        Thread.sleep(beklemeSuresi);

        Actions actions = new Actions(driver);
        actions.moveToElement(sec).click().perform();

    }

    public void mouseKaydirById (String elementId) throws InterruptedException {

        //İstenen id elementine doğru fare hareketi sağlayan metot
        WebElement sec = driver.findElement(By.id(elementId));
        Thread.sleep(beklemeSuresi);

        Actions actions = new Actions(driver);
        actions.moveToElement(sec).click().perform();

    }

    public void gozukeneKadarInId(String elementId){

        //İstenen id elementi görünene kadar sayfayı aşağı kaydıran metot.
        WebElement kaydir = driver.findElement(By.id(elementId));

        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("arguments[0].scrollIntoView();", kaydir);

    }

    public void tcKimlikKontrol(){

    //Tc kimlik bilgisinin doğru ya da yanlış olduğunu kontrol eden metot
        String yanlisTc = driver.findElement(By.xpath("//*[@class='inline-block mr-8 align-middle']")).getText();
        String yanlistirMesaji = "TC Kimlik Numarası Hatalı";
        String dogruTC = driver.findElement(By.xpath("//*[@class='inline-block mr-8 align-middle']")).getText();
        String dogrudurMesaji = "Teslimat adresi başarıyla güncellendi";
        if (yanlisTc.equals(yanlistirMesaji)){
            System.out.println("Sayfa Mesajı: " + yanlisTc);

        }
        else {
            System.out.println("Geçerli Tc kimlik");
        }
        Assert.assertEquals(dogruTC,dogrudurMesaji);

    }


    public void liste() {

    //Testin 07. adımında kullanılan girilen bilgilerin doğru olduğunu bir listeye atayarak karşılaştıran metot.

        teslimatBilgileri = driver.findElements(By.tagName("li"));
        List <String> bilgiler = new ArrayList<>();

        for (int i = 0; i <= 3; i++) {
            // i değişkeni 0, 1, 2 ve 3 olacak şekilde dönecek
            WebElement liElement = teslimatBilgileri.get(i);
            String textValue = liElement.getText();

            bilgiler.add(textValue);

        }
        String[] ekle= {"Esra Are" , "Ankara", "Beypazarı Ankara", "Telefon: 1112223344"};
        List <String> girilenBilgiler = Arrays.asList(ekle);
        boolean esitMi = bilgiler.equals(girilenBilgiler);
        if (esitMi){
            System.out.println("Girilen bilgiler doğrudur: " +bilgiler);
        }
        else {
            System.out.println("Girilen bilgiler hatalı veya eksik girilmesi gereken şu şekildedir: " +girilenBilgiler);
        }

    }



    }








