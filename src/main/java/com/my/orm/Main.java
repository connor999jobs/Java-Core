package com.my.orm;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream  stream = Main.class.getClassLoader().getResourceAsStream("reader.csv");
        assert stream != null;
        List<String> list = IOUtils.readLines(stream, StandardCharsets.UTF_8);

        List<Person> personList = OrmSystem.transform(list, Person.class);

    }
}
