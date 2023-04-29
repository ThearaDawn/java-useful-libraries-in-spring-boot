package com.rean.datafaker;

import net.datafaker.Faker;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DataFakerBasicUsage {

    public static void main(String[] args) {

        Faker faker = new Faker(new Locale("nl"));

        String name = faker.name().fullName(); // Miss Samanta Schmidt
        String firstName = faker.name().firstName(); // Emory
        String lastName = faker.name().lastName(); // Barton

        String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449

        System.out.println(name);
        System.out.println(firstName + " " + lastName);
        System.out.println(streetAddress);


        var s = faker.avatar().image();
        System.out.println(s);
        var colors = faker.color().name();
        System.out.println(colors);


        List<String> names =
                faker.collection(
                                () -> faker.name().firstName())
                        .len(5, 7)
                        .generate();

        System.out.println(names);


        System.out.println(faker.date().future(1, TimeUnit.HOURS, "YYYY MM.dd mm:hh:ss"));
        System.out.println(faker.date().past(1, TimeUnit.HOURS, "YYYY-MM-dd mm:hh:ss"));
        System.out.println(faker.date().birthday(1, 99, "YYYY/MM/dd"));

    }
}
