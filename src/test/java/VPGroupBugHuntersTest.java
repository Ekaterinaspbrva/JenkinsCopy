import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import runner.BaseTest;

public class VPGroupBugHuntersTest extends BaseTest {

    @DataProvider(name = "language")
    public static Object[][] languageData() {

        return new Object[][]{
                {"английский", "Hello World!"},
                {"немецкий", "Hallo Welt!"}
        };
    }

    @Parameters({"language"})
    @Test(dataProvider = "language")
    public void testViktorPodgornov(String language, String result) throws InterruptedException {

        getDriver().get("https://translate.google.ru");

        getDriver().findElement(By.xpath("//textarea[@aria-label='Исходный текст']"))
                .sendKeys("Привет, Мир!");

        getDriver().findElement(By.xpath("//div[5]/button/div[3]")).click();
        Thread.sleep(1000);

        WebElement searchBox = getDriver().findElement(By.xpath("//div[2]/div/div[2]/input"));
        searchBox.sendKeys(language);
        Thread.sleep(1000);
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        Assert.assertEquals(getDriver().findElement(By.xpath("//div[@class='J0lOec']")).getText(),
                result);
    }

}