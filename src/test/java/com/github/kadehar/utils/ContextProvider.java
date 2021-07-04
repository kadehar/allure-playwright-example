package com.github.kadehar.utils;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

import static java.util.Optional.ofNullable;

public abstract class ContextProvider {
    private static final ThreadLocal<Page> PAGE_CONTAINER = new ThreadLocal<>();

    public static Page getPage() {
        return PAGE_CONTAINER.get();
    }

    public static void setupPage(BrowserContext context) {
        PAGE_CONTAINER.set(context.newPage());
    }

    public static void cleanUp() {
        ofNullable(getPage()).ifPresent(Page::close);
        PAGE_CONTAINER.remove();
    }
}
