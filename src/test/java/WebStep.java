import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class WebStep {

    @Step("Открытие вкладки Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверка наличия Issue с названием {issueName}")
    public void shouldSeeIssueWithName(String issueName) {
        $(withText(issueName)).should(Condition.exist);
    }
}
