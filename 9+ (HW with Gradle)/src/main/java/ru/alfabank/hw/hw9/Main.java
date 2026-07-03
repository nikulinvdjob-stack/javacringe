package ru.alfabank.hw.hw9;

import com.github.lalyos.jfiglet.FigletFont;
import net.datafaker.Faker;

import java.io.IOException;
import java.util.Random;


public class Main {

    final static Random random = new Random();

    static String randomLastName(String[] lastnames) {
        return lastnames[random.nextInt(lastnames.length)];
    }

    static void main() throws IOException {

        Faker faker = new Faker();

        final int indexCount = 5;
        String[] lastnames = new String[indexCount];

        for (int i = 0; i < indexCount; i++) {
            lastnames[i] = faker.name().lastName();
        }

        System.out.println(
                FigletFont.convertOneLine(randomLastName(lastnames)));
        System.out.println(
                FigletFont.convertOneLine("&"));
        System.out.println(
                FigletFont.convertOneLine(faker.name().lastName()));

        System.out.format(String.format(
                "Полное ФИО: %s%n" +
                        "Телефонный номер: %s%n" +
                        "Адрес: %s",
                faker.name().fullName(),
                faker.phoneNumber().cellPhone(),
                faker.address().fullAddress()
        ));

    }
}
