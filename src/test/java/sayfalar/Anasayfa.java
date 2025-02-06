package sayfalar;

import org.openqa.selenium.WebDriver;

public class Anasayfa extends Komutlar{

    public final String aramaBox = "//*[@id='insider-search-input']"; //id
    public final String enterBox = "//button[@class='action search']"; //xpath


    public final String wpKapat= ".editable-text"; //css
    public final String cookiesElementi = "banner-accept-button"; //id

    public final String reklamCarpi = ".show-element"; //css


    public final String urunKontrol = ".base"; //xpath






    public Anasayfa(WebDriver driver) {
        super(driver);
    }
}