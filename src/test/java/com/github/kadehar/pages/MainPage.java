package com.github.kadehar.pages;

import com.microsoft.playwright.Page;

public class MainPage {
    private final Page page;

    public MainPage(Page page) {
        this.page = page;
    }

    public MainPage open(String url) {
        page.navigate(url);
        return this;
    }

    public SavingsPage goToSavings() {
        page.click("a[title='Вклады']");
        return new SavingsPage(page);
    }
}
