package tests;

import config.ConfigHelper;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTests {

    @Test
    void selenideSearchTest() {
        String searchItem = ConfigHelper.getSearchItem();
        String searchResult = ConfigHelper.getSearchResult();
        String searchSite = ConfigHelper.getSearchSite();

        open(searchSite);

        $(byName("q")).setValue(searchItem).pressEnter();

        $("html").shouldHave(text(searchResult));
    }
}