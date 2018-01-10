
package pages;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;

public class MainPage {
    WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean isAvatarPresent() {
        try {
            return webDriver.findElement(By.xpath(".//div[@class='pull-left image']//img[@class='img-circle']")).isDisplayed ();

        } catch (Exception e) {
        }

        return false;
    }

}
