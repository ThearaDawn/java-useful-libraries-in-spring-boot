package com.rean.datafaker;

import net.datafaker.Faker;

public class JsonDataFaker {
    public static void main(String[] args) {

        Faker faker = new Faker();

        var personJson = faker.expression("#{json 'person','#{json ''first_name'',''#{Name.first_name}'',''last_name'',''#{Name.last_name}''}','address','#{json ''country'',''#{Address.country}'',''city'',''#{Address.city}''}'}");

        System.out.println(personJson);
    }
}
