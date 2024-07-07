package com.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class AppTest {

//    @Test
    public void test1() {
        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge"));
            Page page = browser.newPage();
            page.navigate("https://playwright.dev/");
            System.out.println(page.title());
            browser.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Test
    public void test2() {
        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge"));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://playwright.dev/");
            assertThat(page).hasTitle(Pattern.compile("Playwright"));
//            Locator getStarted=page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get Started"));
            Locator getStarted = page.locator("text=Get Started");
            assertThat(getStarted).hasAttribute("href", "/docs/intro");
            getStarted.click();
            assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Installation"))).isVisible();
            browser.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Test
    public void test3() {
        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge"));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("http://localhost:5500/");

//            Locator locator=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in"));
//            locator.hover();
//            locator.click();

//            assertThat(page
//                    .getByRole(AriaRole.HEADING,
//                            new Page.GetByRoleOptions().setName("Sign up")))
//                    .isVisible();
//
//            page.getByRole(AriaRole.CHECKBOX,
//                            new Page.GetByRoleOptions().setName("Subscribe"))
//                    .check();
//
//            page.getByRole(AriaRole.BUTTON,
//                            new Page.GetByRoleOptions().setName(
//                                    Pattern.compile("submit", Pattern.CASE_INSENSITIVE)))
//                    .click();

//            page.getByLabel("Password").fill("secret");

//            page.getByPlaceholder("name@example.com").fill("playwright@microsoft.com");


//            assertThat(page.getByText("Welcome, John")).isVisible();

//            assertThat(page
//                    .getByText("Welcome, John", new Page.GetByTextOptions().setExact(true)))
//                    .isVisible();

//            assertThat(page
//                    .getByText(Pattern.compile("welcome, john$", Pattern.CASE_INSENSITIVE)))
//                    .isVisible();

//            page.getByAltText("playwright logo").click();

//            assertThat(page.getByTitle("Issues count")).hasText("25 issues");

//            page.getByTestId("directions").click();

//            playwright.selectors().setTestIdAttribute("data-pw");

//            page.getByTestId("directions").click();


//            Locate by CSS or XPath

//            page.locator("css=button").click();
//            page.locator("xpath=//button").click();
//            page.querySelector(".box").click();

//            page.getByRole(AriaRole.LISTITEM)
//                            .filter(new Locator.FilterOptions().setHasText("Product 2"))
//                                    .getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Add to cart"))
//                            .click();

//            page.getByRole(AriaRole.LISTITEM)
//                    .filter(new Locator.FilterOptions()
//                            .setHasText(Pattern.compile("Product 2")))
//                    .getByRole(AriaRole.BUTTON,
//                            new Locator.GetByRoleOptions().setName("Add to cart"))
//                    .click();


//            assertThat(page.getByRole(AriaRole.LISTITEM)
//                    .filter(new Locator.FilterOptions().setHasNotText("Out of stock")))
//                    .hasCount(5);

            assertThat(page
                    .getByRole(AriaRole.LISTITEM)
                    .filter(new Locator.FilterOptions().setHasNot(page.getByText("Product 2")))).hasCount(1);

            browser.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
