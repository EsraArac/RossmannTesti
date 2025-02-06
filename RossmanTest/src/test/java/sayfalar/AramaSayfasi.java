package sayfalar;

import org.openqa.selenium.WebDriver;

public class AramaSayfasi extends Komutlar{
    public final String markaButonu = "//div[@class='sidebar sidebar-main']//div[.='Markalar']";
    public final String markaSec="//div[@class='sidebar sidebar-main']//div[.='Markalar']"; //xpath //css

    public final String dahaFazlaMarka = "//div[@class='eln-filter-item filter-options-item active']//a[.='Daha Fazla']" ; //ptah

    public final String rivalSEc="//div[@class='sidebar sidebar-main']//div[@class='eln-layer']";
    public final String plumpingSec= "//div[@class='product details product-item-details eln-product-item-details eln-product-item-20671']//a[.='Lipgloss Plumping']"; //xpath


    public final String markaDogru="//div[@class='eln-breadcrumb  top']//a[contains(.,'Rival de Loop')]" ; //xpath


    public AramaSayfasi(WebDriver driver) {
        super(driver);
    }
}
