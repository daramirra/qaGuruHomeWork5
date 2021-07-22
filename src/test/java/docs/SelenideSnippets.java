package docs;

import com.codeborne.selenide.*;
import org.openqa.selenium.*;

import java.io.*;
import java.time.*;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// this is not a full list, just the most common
public class SelenideSnippets {

    void browser_command_examples() {

        open("https://google.com");
        open("/customer/orders");
        open("/", AuthenticationType.BASIC, "user", "password");

        Selenide.back();

        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();

        Selenide.confirm(); // OK in alert dialogs
        Selenide.dismiss(); // Cancel in alert dialogs

        Selenide.closeWindow(); // close active tab
        Selenide.closeWebDriver(); // close browser completely

        Selenide.switchTo().frame("new");
        Selenide.switchTo().defaultContent();

        Selenide.switchTo().window("The Internet");
    }

    void selectors_examples() {
        $("div").click();
        element("div").click();

        $("div", 2).click(); // the third div

        $x("//h1/div").click();
        $(byXpath("//h1/div")).click();

        $(byText("full text")).click();
        $(withText("ull tex")).click();

        $("").parent();       // find parent element
        $("").sibling(2);     // find down third sibling element
        $("").preceding(0);   // find up first sibling element
        $("").closest("div"); // find up the tree the next element with tag

        $("div").$("h1").find(byText("abc")).click();

        // very optional
        $(byAttribute("abc", "x")).click();
        $("[abc=x]").click();

        $(byId("mytext")).click();
        $("#mytext").click();

        $(byClassName("red")).click();
        $(".red").click();
    }
}