package sayfalar;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Komutlar {
    WebDriver driver;
    static int milis = 1500;
    static SoftAssert softAssert;
    static List<WebElement> teslimatBilgileri ;
    List<String> classList = new ArrayList<>();




    public Komutlar(WebDriver driver) {
        this.driver = driver;
    }

    public void tiklaId(String elementId){
        driver.findElement(By.id(elementId)).click();

    }
    public void tiklaXpath(String elementId){
        driver.findElement(By.xpath(elementId)).click();

    }
    public void tiklaCss(String elementId){
        driver.findElement(By.cssSelector(elementId)).click();

    }
     public void yaziYazId(String elementId,String yaziId){
         driver.findElement(By.id(elementId)).sendKeys(yaziId);

     }
    public void yaziYazCss(String elementId,String yaziId){
        driver.findElement(By.cssSelector(elementId)).sendKeys(yaziId);

    }


    public void kontrolCss(String bulunanId,String aratılanId){
      String bulunanArama = driver.findElement(By.cssSelector(bulunanId)).getText();
         System.out.println("Arama sonuçları : "+bulunanArama);
      Assert.assertEquals(bulunanArama,aratılanId);


     }
    public void kontrolXpath(String bulunanId,String aratılanId){
        String bulunanArama = driver.findElement(By.xpath(bulunanId)).getText();
        System.out.println("Arama sonuçları : "+bulunanArama);
        Assert.assertEquals(bulunanArama,aratılanId);


    }
    public void gorunurlukKontrol (String elementId){
        WebElement emailKutusu = driver.findElement(By.id(elementId));
        boolean kutuGor = emailKutusu.isDisplayed();
        Assert.assertTrue(kutuGor);


    }
     public void gozukeneKadarBekleCss (String elementId){
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25L));
         wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementId)));

     }
    public void gozukeneKadarBekleXpath (String elementId){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25L));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementId)));

    }
    public void gozukeneKadarBekleId (String elementId){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25L));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(elementId)));

    }

    public void urlKontrol (String beklenenUrl){
     String urlContr= driver.getCurrentUrl();
     Assert.assertEquals(urlContr,beklenenUrl);


    }

    public void ekranaYazdir (String elementId){
    String yazdiralim=  driver.findElement(By.xpath(elementId)).getText();
        System.out.println("Şuanki işleminiz: "+yazdiralim);


    }

    public void mouseKaydirXpath (String elementId) throws InterruptedException {
        WebElement sec = driver.findElement(By.xpath(elementId));
        Thread.sleep(milis);

        Actions actions = new Actions(driver);
        actions.moveToElement(sec).click().perform();

    }

    public void gozukeneKadarInId(String elementId){
        WebElement kaydir = driver.findElement(By.id(elementId));

        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("arguments[0].scrollIntoView();", kaydir);


    }
    public void liste() {
        String bilger;

        teslimatBilgileri = driver.findElements(By.tagName("li"));
        List <String> bilgiler = new ArrayList<>();

        for (int i = 0; i <= 3; i++) {
            // i değişkeni 0, 1, 2 ve 3 olacak şekilde dönecek
            WebElement liElement = teslimatBilgileri.get(i);
            String textValue = liElement.getText();

           bilgiler.add(textValue);


        }
      //System.out.println( bilgiler);
        String[] ekle= {"Esra Are" , "Ankara", "Beypazarı Ankara", "Telefon: 1112223344"};
        List <String> girilenBilgiler = Arrays.asList(ekle);
        //System.out.println(girilenBilgiler);
        boolean esitMi = bilgiler.equals(girilenBilgiler);
        if (esitMi){
            System.out.println("Girilen bilgiler doğrudur: " +bilgiler);
        }
        else {
            System.out.println("Girilen bilgiler hatalı veya eksik girilmesi gereken şu şekildedir: " +girilenBilgiler);
        }
        //Assert.assertTrue(esitMi);
     //   System.out.println("Girilen bilgileriniz bunlar : "+bilgiler);
        

    }



     public void gorursenTiklaClass (String elemenId) throws InterruptedException {
       By robot = By.xpath("//a[.='Farklı bir görüntü deneyin']");
       WebElement roboti = driver.findElement(robot);

        if (roboti.isDisplayed()){
            roboti.click();
            Thread.sleep(milis);

        }
        else {

         }


     }






}
