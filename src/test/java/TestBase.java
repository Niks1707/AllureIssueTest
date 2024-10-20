import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeAll
    static void setUp()  {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    void openPage() {
        open("https://github.com/qa-guru/qa_guru_14_10");
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void  closeAll(){
        Selenide.closeWebDriver();
    }
}