package sayfalar;

import org.openqa.selenium.WebDriver;

public class GlossSayfasi extends Komutlar {
    /**
     * GlossSayfasi , Rossman web sitesindeki gloss sayfasının ekranında bulunan öğeleri temsil eder.
     * Sepete ürün eklemek, alışverişi tamamlamak gibi işlemleri gerçekleştirmek için kullanılır.
     */

    public final String sepeteEkle= "//span[.='Sepete Ekle']"; //xpath


    public final String sepeteAtti = ".counter-number";  //css

    public final String sepetSimgesineBas = ".minicart-wrapper" ; //css
    public final String alisverisiTamamla = "//div[@class='actions lastViewCart']/div[contains(.,'Alışverişi Tamamla')]" ; //xpath

    public final String sepeteEklendiYazisi="//div[@class='message-success success message']/div[contains(.,'Rival de Loop Lipgloss Plumping No.01 sepete eklendi. sepete git.')]"; // xpath

    public final String emailKutusu="login.email";


    public GlossSayfasi(WebDriver driver) {
        super(driver);
    }
}
