package sayfalar;

import org.openqa.selenium.WebDriver;

public class AramaSayfasi extends Komutlar{

    /**
     * AramaSayfasi, Rossman web sitesinin marka seçme kısmındaki web elementlerini temsil eder.
     * Marka butonu, markaları görüntüleme, istenen markayı seçme gibi işlemleri gerçekleştirmek için kullanılır
     */

    public final String markaButonu = "//div[@class='sidebar sidebar-main']//div[.='Markalar']";
    public final String markaSec="//div[@class='sidebar sidebar-main']//div[.='Markalar']"; //xpath //css

    public final String dahaFazlaMarka = "//div[@class='eln-filter-item filter-options-item active']//a[.='Daha Fazla']" ; //xptah

    public final String rivalSEc="//div[@class='sidebar sidebar-main']//div[@class='eln-layer']";
    public final String plumpingSec= "//*[@id='product-image-20671']"; //xpath

    public final String markaDogru="//div[@class='eln-breadcrumb  top']//a[contains(.,'Rival de Loop')]" ; //xpath


    public AramaSayfasi(WebDriver driver) {
        super(driver);
    }
}
