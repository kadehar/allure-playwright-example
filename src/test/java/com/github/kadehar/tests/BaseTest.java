package com.github.kadehar.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.ViewportSize;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    private static Browser browser;
    private static Playwright playwright;
    protected static BrowserContext context;

    @BeforeAll
    static void beforeAll() {
        playwright = Playwright.create();
        browser = playwright
                .chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
    }

    @AfterAll
    static void afterAll() {
        browser.close();
        playwright.close();
    }
}
