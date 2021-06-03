package ru.netology;

import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


public class DataGenerator {

    public DataGenerator() {
    }

    private int shift;

    public String getRandomCity() {
        String[] cities = new String[]{"Абакан", "Анадырь", "Архангельск", "Астрахань", "Барнаул", "Белгород",
                "Биробиджан", "Благовещенск", "Брянск", "Великий Новгород", "Владивосток", "Владикавказ", "Владимир",
                "Волгоград", "Вологда", "Воронеж", "Горно-Алтайск", "Грозный", "Екатеринбург", "Иваново", "Ижевск",
                "Иркутск", "Йошкар-Ола", "Казань", "Калининград", "Калуга", "Кемерово", "Киров", "Кострома", "Краснодар",
                "Красноярск", "Курган", "Курск", "Кызыл", "Липецк", "Магадан", "Магас", "Майкоп", "Махачкала", "Москва",
                "Мурманск", "Нальчик", "Нарьян-Мар", "Нижний Новгород", "Новосибирск", "Омск", "Орёл", "Оренбург", "Пенза",
                "Пермь", "Петрозаводск", "Петропавловск-Камчатский", "Псков", "Ростов-на-Дону", "Рязань", "Салехард",
                "Самара", "Санкт-Петербург", "Саранск", "Саратов", "Севастополь", "Симферополь", "Смоленск", "Ставрополь",
                "Сыктывкар", "Тамбов", "Тверь", "Томск", "Тула", "Тюмень", "Улан-Удэ", "Ульяновск", "Уфа", "Хабаровск",
                "Ханты-Мансийск", "Чебоксары", "Челябинск", "Черкесск", "Чита", "Элиста", "Южно-Сахалинск", "Якутск",
                "Ярославль"};
        Random rand = new Random();
        return cities[rand.nextInt(cities.length)];
    }

    public String deliveryDate(int shift) {
        LocalDate localDate = LocalDate.now().plusDays(shift);
        String text = localDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return text;
    }

    public static String generateName() {
        Faker faker = new Faker(new Locale("ru"));
        String name = faker.name().fullName() + faker.name().lastName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        return name;
    }

    public String generatePhone() {
        Faker faker = new Faker(new Locale("ru"));
        String tel = faker.phoneNumber().phoneNumber();
        return tel;
    }
}
