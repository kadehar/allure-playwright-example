package com.github.kadehar.pages;

import com.microsoft.playwright.Page;

public class ArchivedDeposits {
    private final Page page;

    public ArchivedDeposits(Page page) {
        this.page = page;
    }

    public int depositsCount() {
        page.click("//div[@data-test-id='tabs-list']/button/span[text()='Депозиты']");
        page.click("//div[@data-test-id='tabs-list']/button/span[text()='Депозиты']");
        return page.querySelectorAll("[data-widget-name='CatalogCard']").size();
    }
}
