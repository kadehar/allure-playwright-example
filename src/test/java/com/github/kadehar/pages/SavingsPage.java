package com.github.kadehar.pages;

import com.microsoft.playwright.Page;

import static org.assertj.core.api.Assertions.assertThat;

public class SavingsPage {
    private final Page page;

    public SavingsPage(Page page) {
        this.page = page;
    }

    public SavingsPage savingsIsOpen() {
        String header = page.innerText("[data-test-id='layout'] h1");
        assertThat(header).isEqualTo("Накопительные продукты");
        return this;
    }

    public DepositsPage goToDeposits() {
        page.click("#filter a[href='/make-money/deposits/']");
        return new DepositsPage(page);
    }
}
