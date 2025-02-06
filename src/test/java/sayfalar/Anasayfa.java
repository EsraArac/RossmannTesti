package sayfalar;

import org.openqa.selenium.WebDriver;

public class Anasayfa extends Komutlar{

    /**
     * Anasayfa, Rossman web sitesinin ana sayfasındaki  web elementlerini temsil eder.
     */
    public final String aramaBox = "search"; //id
    public final String enterBox = "//button[@class='action search']"; //xpath
    public final String wpKapat= ".editable-text"; //css
    public final String cookiesElementi = "banner-accept-button"; //id


    public final String carpi = "//div[@class='ins-notification-content ins-notification-content-2407 ins-element-link']//span[.='×']"; //xpath gidebilir!!

    public final String urunKontrol = ".base"; //xpath








    public Anasayfa(WebDriver driver) {
        super(driver);
    }
}
