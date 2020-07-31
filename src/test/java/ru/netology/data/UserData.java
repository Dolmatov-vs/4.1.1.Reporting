package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class UserData {
    private UserData(){
    }

    @Value
    public static class UserInfo {
        private String city;
        private String date;
        private String fullName;
        private String phone;
    }

    public static UserInfo getUserInfo() {
        Faker faker = new Faker(new Locale("ru"));
        return new UserInfo(
                getCity(),
                dateMeeting(),
                faker.name().lastName()+" "+faker.name().firstName(),
                faker.phoneNumber().phoneNumber());
    }

    public static String dateMeeting() {
        Faker faker = new Faker(new Locale("ru"));

        final String dateFormatWithDots = "dd.MM.yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatWithDots);

        int daysToAdd = faker.random().nextInt(5, 365);
        LocalDate newDateMeeting = LocalDate.now().plusDays(daysToAdd);
        String dateMeeting = newDateMeeting.format(formatter);
        return dateMeeting;
    }

    public static String getCity(){
        String[] city = new String[]{"Майкоп", "Уфа", "Улан-Удэ", "Махачкала", "Магас", "Нальчик", "Элиста",
                "Петрозаводск", "Сыктывкар", "Симферополь", "Йошкар-Ола", "Саранск", "Якутск", "Владикавказ",
                "Казань", "Кызыл", "Ижевск", "Абакан", "Грозный", "Чебоксары", "Барнаул", "Чита",
                "Петропавловск-Камчатский", "Краснодар", "Красноярск", "Пермь", "Ставрополь", "Хабаровск",
                "Благовещенск", "Астрахань", "Белгород", "Брянск", "Владимир", "Волгоград", "Вологда",
                "Воронеж", "Иваново", "Иркутск", "Калининград", "Калуга", "Кемерово", "Киров", "Кострома",
                "Курган", "Курск", "Санкт-Петербург", "Липецк", "Магадан", "Москва", "Нижний Новгород",
                "Великий Новгород", "Новосибирск", "Омск", "Оренбург", "Орёл", "Пенза", "Псков",
                "Ростов-на-Дону", "Рязань", "Самара", "Саратов", "Южно-Сахалинск", "Екатеринбург",
                "Смоленск", "Тамбов", "Тверь","Томск", "Тула", "Тюмень", "Ульяновск", "Челябинск",
                "Ярославль", "Нарьян-Мар", "Ханты-Мансийск", "Анадырь", "Салехард", "Биробиджан"};
        return city[new Random().nextInt(city.length-1)];
    }
}
