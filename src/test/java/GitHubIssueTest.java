import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
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
    @DisplayName("Проверка на чистом Selenide, что в Issues содержится ' " + issueName + "'")
    public void selenideIssuesTest() {
        $("#issues-tab").click();
        $("#issue_2_link").shouldHave(text(issueName));

    }
    @Test
    @Story("Проверка с использованием лямбда шагов через step")
    @Owner("Genkel Veronika")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com/qa-guru/qa_guru_14_10/issues")
    @DisplayName("Проверка с использованием лямбда шагов через step, что в Issues содержится ' " + issueName + "'")
    public void lambdaIssuesTest() {
        step("Открытие вкладки Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверка в Issues "  + issueName, () -> {
            $(withText(issueName)).should(Condition.exist);
        });
    }
    @Test
    @Story("Проверка с использованием аннотации @Step")
    @Owner("Genkel Veronika")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com/qa-guru/qa_guru_14_10/issues")
    @DisplayName("Проверка с использованием аннотации @Step, что в Issues содержится ' " + issueName + "'")
    public void testStepIssues() {
        steps.openIssuesTab();
        steps.shouldSeeIssueWithName(issueName);
    }

}


