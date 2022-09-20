package com.my.orm;

import org.apache.commons.io.IOUtils;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;


public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
//        InputStream  stream = Main.class.getClassLoader().getResourceAsStream("reader.csv");
//        assert stream != null;
//        List<String> list = IOUtils.readLines(stream, StandardCharsets.UTF_8);
//        List<Person> personList = OrmSystem.transform(list, Person.class);


        URL xmlFile = Main.class.getClassLoader().getResource("persons.xml");
        File xmlLoadFile = new File(Objects.requireNonNull(xmlFile).getPath());
        List<Person> personList = OrmSystem.parseXml(xmlLoadFile, Person.class);


        URL jsonFile = Main.class.getClassLoader().getResource("rrr.json");
        File file2 = new File(Objects.requireNonNull(jsonFile).getPath());
        List<Person> jsonPersonList = OrmSystem.parseJson(file2,Person.class);







//        List<Person> personListXml = OrmSystem.parsePersonXML();
//        List<Person> personListJson = OrmSystem.parseJson();

    }
}
