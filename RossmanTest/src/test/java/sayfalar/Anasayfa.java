package sayfalar;

import org.openqa.selenium.WebDriver;

public class Anasayfa extends Komutlar{

    public final String aramaBox = "search"; //id
    public final String enterBox = "//button[@class='action search']"; //xpath
    public final String wpKapat= ".editable-text"; //css
    public final String cookies = "banner-accept-button"; //id

    public final String urunKontrol = ".base"; //xpath






    public Anasayfa(WebDriver driver) {
        super(driver);
    }
}
