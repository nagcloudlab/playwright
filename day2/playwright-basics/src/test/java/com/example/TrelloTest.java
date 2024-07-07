package com.example;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class TrelloTest {

    private static Playwright playwright;
    private static Browser browser;
    static APIRequestContext requestContext;


    @BeforeAll
    public static void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        requestContext = playwright.request().newContext();
        APIResponse response = requestContext.post("http://localhost:3000/api/reset");
        response.dispose();
    }

    @AfterAll
    public static void teardown() {
        browser.close();
        playwright.close();
    }


    @Test
    void createNewBoardWithListAndCards() {
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        // Load the app
        page.navigate("http://localhost:3000/");

        // Create a new board
        page.locator("input[placeholder='Name of your first board']").fill("board1");
        page.locator("input[placeholder='Name of your first board']").press("Enter");
        assertThat(page.locator("[name='board-title']")).hasValue("board1");
        assertThat(page.locator("input[placeholder='Enter list title...']")).isVisible();
        assertThat(page.locator("[data-cy='list']")).not().isVisible();

        // take a screenshot
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/board1.1.png")));

        // Create a new list
        page.locator("input[placeholder='Enter list title...']").fill("list1");
        page.locator("input[placeholder='Enter list title...']").press("Enter");
        assertThat(page.locator("[data-cy='list-name']")).hasValue("list1");

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/board1.2.png")));


        // Add cards to the list
        page.locator("text=Add another card").click();
        page.getByPlaceholder("Enter a title for this card...").fill("Buy groceries", new Locator.FillOptions().setForce(true));
        page.locator("button:has-text('Add card')").click();
        page.getByPlaceholder("Enter a title for this card...").fill("Mow the lawn");
        page.locator("button:has-text('Add card')").click();
        page.getByPlaceholder("Enter a title for this card...").fill("Walk the dog");
        page.locator("button:has-text('Add card')").click();
        assertThat(page.locator("[data-cy='card-text']")).hasText(new String[]{"Buy groceries", "Mow the lawn", "Walk the dog"});

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/board1.3.png")));

        // Navigate to the home page
        page.locator("role=navigation").locator("role=button").click();
        assertThat(page.locator("text=My Boards")).isVisible();
        assertThat(page.locator("text=board1")).isVisible();

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/board1.4.png")));

        context.close();

    }

}
