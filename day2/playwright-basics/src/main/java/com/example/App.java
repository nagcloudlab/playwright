package com.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class App {
    public static void main(String[] args) {
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


//im here, for any Q