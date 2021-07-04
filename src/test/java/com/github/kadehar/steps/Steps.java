package com.github.kadehar.steps;

import com.github.kadehar.pages.BaseRouter;

import java.util.concurrent.atomic.AtomicInteger;

import static com.github.kadehar.pages.locators.Locators.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class Steps {
    private final BaseRouter baseRouter = new BaseRouter();

    public Steps goTo(final String URL) {
        step("Open site " + URL, () -> {
            baseRouter.mainPage.page.navigate(URL);
        });
        return this;
    }

    public Steps openSavings() {
        step("Перейти на страницу Вклады", () -> {
            baseRouter.mainPage.page.click(SAVINGS_BUTTON.getLocator());
        });
        step("Страница Вклады открыта", () -> {
            final String header = baseRouter.savingsPage
                    .page.innerText(HEADER.getLocator());

            assertThat(header)
                    .isEqualTo("Накопительные продукты");
        });
        return this;
    }

    public Steps openDeposits() {
        step("Открыть вкладку Депозиты", () -> {
            baseRouter.savingsPage
                    .page.click(DEPOSIT_BUTTON.getLocator());
        });
        step("Страница Депозиты открыта", () -> {
            final String header = baseRouter.depositsPage
                    .page.innerText(HEADER.getLocator());

            assertThat(header)
                    .isEqualTo("Вклады");
        });
        return this;
    }

    public Steps openArchivedDeposits() {
        step("Открыть Архивные Депозиты", () -> {
            baseRouter.depositsPage
                    .page.click(ARCHIVE_DEPOSIT_BUTTON.getLocator());
        });
        return this;
    }

    public int getDepositsCount() {
        AtomicInteger count = new AtomicInteger();
        step("Получить количество архивных счетов", () -> {
            baseRouter.archivedDeposits
                    .page.dblclick(DEPOSITS_TAB.getLocator());
            count.set(baseRouter.archivedDeposits
                    .page.querySelectorAll(CARDS.getLocator()).size());
        });
        return count.get();
    }
}
