package com.github.kadehar.pages;

import com.microsoft.playwright.Page;

import static org.assertj.core.api.Assertions.assertThat;

public class DepositsPage {
    private final Page page;

    public DepositsPage(Page page) {
        this.page = page;
    }

    public DepositsPage depositsIsOpen() {
        String header = page.innerText("[data-test-id='layout'] h1");
        assertThat(header).isEqualTo("Вклады");
        return this;
    }

    public ArchivedDeposits goToArchivedDeposits() {
        page.click("text=Архивные счета");
        return new ArchivedDeposits(page);
    }
}
