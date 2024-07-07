package com.example;

import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch();
            BrowserContext context = browser.newContext();

            // Start tracing before creating/navigating a page.
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));

            Page page = context.newPage();
            page.navigate("https://playwright.dev");

            // Stop tracing and export it into a zip archive.
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));
        }
    }
}
