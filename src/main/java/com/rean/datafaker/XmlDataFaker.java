package com.rean.datafaker;

import net.datafaker.Faker;
import net.datafaker.formats.Xml;

import java.util.Arrays;
import java.util.Collection;

public class XmlDataFaker {

    public static void main(String[] args) {
        Faker faker = new Faker();
        Collection<Xml.XmlNode> address = faker.<Xml.XmlNode>collection()
                .suppliers(() -> new Xml.XmlNode("address",
                        of(new Xml.XmlNode("country", "Cambodia"),
                                new Xml.XmlNode("city", "Phnom Penh"),
                                new Xml.XmlNode("streetAddress", "St 128"))))
                .maxLen(1).build().get();

        Collection<Xml.XmlNode> persons = faker.<Xml.XmlNode>collection()
                .suppliers(() -> new Xml.XmlNode("person",
                        of(new Xml.XmlNode("firstname", "Rean"),
                                new Xml.XmlNode("lastname", "Code"),
                                new Xml.XmlNode("addresses", address)))).maxLen(1).build().get();

        String str = new Xml(new Xml.XmlNode("persons", persons)).generate(true);
        System.out.println(str);

    }

    private static <T> Collection<T> of(T... elems) {
        return Arrays.asList(elems);
    }


}
