package com.github.kadehar.tests;

import com.github.kadehar.steps.Steps;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class AlfabankTest extends BaseTest {
    private Steps steps;

    @Test
    void archivedDepositsCount() {
        step("Проверить что страница Архивные депозиты содержит 5 элементов", () -> {
            steps = new Steps();

            int size = steps.goTo("https://alfabank.ru/")
                    .openSavings()
                    .openDeposits()
                    .openArchivedDeposits()
                    .getDepositsCount();

            assertThat(size).isEqualTo(8);
        });
    }
}
