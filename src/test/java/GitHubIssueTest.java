import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Feature("Проверка Issues")
@DisplayName("Проверка Issues")
public class GitHubIssueTest extends TestBase {
    private static final String issueName = "Issue for Autotest";
    WebStep steps = new WebStep();

    @Test
    @Story("Проверка на чистом Selenide")
    @Owner("Genkel Veronika")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com/qa-guru/qa_guru_14_10/")
    @DisplayName("Проверка на чистом Selenide, что Issues содержит ' " + issueName + "'")
    public void selenideIssuesTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        $("#issues-tab").click();
        $("#issue_2_link").shouldHave(text(issueName));

    }
    @Test
    @Story("Проверка с использованием лямбда шагов через step")
    @Owner("Genkel Veronika")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com/qa-guru/qa_guru_14_10/issues")
    @DisplayName("Проверка с использованием лямбда шагов через step, что Issues содержит ' " + issueName + "'")
    public void lambdaIssuesTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем вкладку Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем в Issues "  + issueName, () -> {
            $(withText(issueName)).should(Condition.exist);
        });
    }
    @Test
    @Story("Проверка с использованием аннотации @Step")
    @Owner("Genkel Veronika")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com/qa-guru/qa_guru_14_10/issues")
    @DisplayName("Проверка с использованием аннотации @Step, что Issues содержит ' " + issueName + "'")
    public void stepIssuesTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        steps.openIssuesTab();
        steps.shouldSeeIssueWithName(issueName);
    }

}


