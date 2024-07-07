package com.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void appTest() {
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

}
