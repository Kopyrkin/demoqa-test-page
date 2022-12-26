package ru.appliedtech;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Junit5Tests {
    @BeforeEach
    void openYandexPage() {
        Selenide.open("https://ya.ru");
    }
    @AfterEach
    void closDriver() {
        WebDriverRunner.closeWindow();
    }
    @Test
    void assertTest() {
    }
    @Test
    void assertTestDouble() {

    }
}
