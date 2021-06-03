package ru.netology;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryTest {

    private Faker faker;
    DataGenerator dataGenerator = new DataGenerator();

    @BeforeEach
    public void shouldOpenForm() {
        open("http://localhost:9999");
    }

    @Test
    public void shouldTestForm() {
        SelenideElement form = $("[class=\"form form_size_m form_theme_alfa-on-white\"]");
        form.$("[data-test-id=city] input").setValue(dataGenerator.getRandomCity());
        form.$("[data-test-id=date] input").doubleClick().sendKeys(Keys.DELETE);
        form.$("[data-test-id=date] input").setValue(dataGenerator.deliveryDate(4));
        form.$("[data-test-id=name] input").setValue(dataGenerator.generateName());
        form.$("[data-test-id=phone] input").setValue(dataGenerator.generatePhone());
        form.$("[data-test-id=agreement]").click();
        form.$(withText("Запланировать")).click();
        $(withText("Встреча успешно запланирована на")).should(appear, Duration.ofSeconds(15));
        $(withText("Встреча успешно запланирована на")).shouldHave(text(dataGenerator.deliveryDate(4)));
        form.$("[data-test-id=date] input").doubleClick().sendKeys(Keys.DELETE);
        form.$("[data-test-id=date] input").setValue(dataGenerator.deliveryDate(7));
        form.$(withText("Запланировать")).click();
        $(withText("У вас уже запланирована встреча на другую дату")).should(appear, Duration.ofSeconds(15));
        $(withText("Перепланировать")).click();
        $(withText("Встреча успешно запланирована на")).should(appear, Duration.ofSeconds(15));
        $(withText("Встреча успешно запланирована на")).shouldHave(text(dataGenerator.deliveryDate(7)));

    }

}
