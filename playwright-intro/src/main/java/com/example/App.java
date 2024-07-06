package com.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) {

       try( Playwright playwright = Playwright.create()) {
           Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
           Page page = browser.newPage();
           page.navigate("http://127.0.0.1:5500/web-ui/index.html");
           //System.out.println(page.title());
           page.screenshot(new Page.ScreenshotOptions().setPath(Path.of("screenshot.png")));
       }
    }
}
