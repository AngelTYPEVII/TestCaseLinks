import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class FirstTest {
    private String baseUrl = "https://demoqa.com/links";
    private SelenideElement Forbidden = Selenide.$(By.xpath("//a[@id='forbidden']"));
    private SelenideElement NotFound = Selenide.$(By.xpath("//a[@id='invalid-url']"));
    private SelenideElement Created = Selenide.$(By.xpath("//a[@id='created']"));

    public FirstTest() {
    }

    @BeforeAll
    static void beforeConfig() {
        Configuration.timeout = 3000L;
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    public void before() {
        Selenide.open(this.baseUrl);
    }

    @Test
    public void test() {
        this.step1();
        this.step2();
        this.step3();
    }

    @Step("Кнопка")
    private void step1() {
        this.Forbidden.should(new Condition[]{Condition.visible}).click();
    }

    @Step("Кнопка2")
    private void step2() {
        this.NotFound.should(new Condition[]{Condition.visible}).click();
    }

    @Step("Кнопка3")
    private void step3() {
        this.Created.should(new Condition[]{Condition.visible}).click();
    }

    @AfterEach
    public void after() {
    }
}
