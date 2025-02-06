package sayfalar;

import org.openqa.selenium.WebDriver;

public class GlossSayfasi extends Komutlar {

    public final String sepeteEkle= "//span[.='Sepete Ekle']"; //xpath


    public final String sepeteAttı = ".counter-number";  //css

    public final String sepeteBas = ".minicart-wrapper" ; //css
    public final String alisverisiTamamla = "//div[@class='actions lastViewCart']/div[contains(.,'Alışverişi Tamamla')]" ; //xpath

    public final String sepeteEklendiYazisi="//div[@class='message-success success message']/div[contains(.,'Rival de Loop Lipgloss Plumping No.01 sepete eklendi. sepete git.')]"; // xpath

    public final String emailKutusu="login.email";



    public GlossSayfasi(WebDriver driver) {
        super(driver);
    }
}