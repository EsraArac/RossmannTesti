package sayfalar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SepetimSayfasi extends Komutlar{

    public final String isimYaz="shipping_address.firstname"; //id
    public final String soyadYaz ="shipping_address.lastname"; //id
    public final String adresYaz = "[placeholder='Adres']"; //css
    public final String ilSec = "shipping_address.region"; //id
    public final String ankaraSec = "//option[.='Ankara']";
    public final String ilceSec1="shipping_address.city"; //id
    public final String ilceSec2 = "//option[.='Beypazarı']"; //xpath
    public final String telNoYaz="shipping_address.phone"; //id
    public final String bireyselTikla="//input[@value='1']" ; //xpath
    public final String tcKimlik = "shipping_address.mnm_identity_number"; //id
    public final String kaydet="//button[.='Kaydet']"; //xpath
    public final String teslimatAdresi = "//h3[@class='text-sm font-bold text-black']"; //css






    public SepetimSayfasi(WebDriver driver) {
        super(driver);
    }
}
