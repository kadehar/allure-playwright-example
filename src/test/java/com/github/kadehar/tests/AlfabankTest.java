package com.github.kadehar.tests;

import com.github.kadehar.pages.MainPage;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class AlfabankTest extends BaseTest {
    @Test
    void archivedDepositsCountIsFive() {
        step("Проверить что страница Архивные депозиты содержит 5 элементов", () -> {
            int size = new MainPage(context.newPage())
                    .open("https://alfabank.ru/")
                    .goToSavings()
                    .savingsIsOpen()
                    .goToDeposits()
                    .depositsIsOpen()
                    .goToArchivedDeposits()
                    .depositsCount();
            assertThat(size).isEqualTo(5);
        });
    }
}
