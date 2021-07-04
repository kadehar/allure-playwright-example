package com.github.kadehar.pages.locators;

public enum Locators {
    SAVINGS_BUTTON("a[title='Вклады']"),
    HEADER("[data-test-id='layout'] h1"),
    DEPOSIT_BUTTON("#filter a[href='/make-money/deposits/']"),
    ARCHIVE_DEPOSIT_BUTTON("text=Архивные счета и депозиты"),
    DEPOSITS_TAB("[data-test-id='tabs-list-tabTitle-1']"),
    CARDS("[data-widget-name='CatalogCard']");

    private final String locator;
    Locators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
