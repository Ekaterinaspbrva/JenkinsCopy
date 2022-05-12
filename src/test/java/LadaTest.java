import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class LadaTest extends BaseTest {
    @Test
    public void testLadaZhivitsaForOnliner() {
        getDriver().get("https://www.onliner.by/");

        WebElement button = getDriver().findElement(By.xpath("//*[text()=\"Вход\"]"));
        button.click();

        WebElement fieldNick = getDriver().findElement(By.xpath("//*[contains(@placeholder,'Ник или e-mail')]"));
        WebElement fieldPassword = getDriver().findElement(By.xpath("//*[contains(@type,'password')]"));
        WebElement Submit = getDriver().findElement(By.xpath("//*[contains(@class,\"auth-button_primary\")]"));

        fieldNick.sendKeys("invalidNick");
        fieldPassword.sendKeys("invalidPassword");
        Submit.click();

        WebElement ErrorMessage = getDriver().findElement(By.xpath("//*[contains(@class,\"description_error\")]"));

        Assert.assertEquals(ErrorMessage.getText(), "Неверный логин или пароль");

        fieldNick.clear();
        fieldPassword.clear();
    }

}
