import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @DisplayName("Настройки браузера")
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }
    @DisplayName("Открытие репозитория в github.com")
    @BeforeEach
    void beforeEach() {
        open("https://github.com/qa-guru/qa_guru_14_10");
    }
    @DisplayName("Закрытие веб-драйвера Selenide после выполнения каждого теста")
    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}