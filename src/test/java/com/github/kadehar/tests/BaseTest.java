package com.github.kadehar.tests;

import com.github.kadehar.utils.ContextProvider;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
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
        ContextProvider.setupPage(context);
    }

    @AfterAll
    static void afterAll() {
        ContextProvider.cleanUp();
        context.close();
        browser.close();
        playwright.close();
    }
}
