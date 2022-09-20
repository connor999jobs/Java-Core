package com.my.orm;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.thoughtworks.xstream.XStream;
import lombok.SneakyThrows;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrmSystem {


    public static final String DELIMITER = ",";
    private static final String COMMENT = "--";


    public static <T extends Person> List<T> transformToType(File file, Class<T> cls) throws IOException {

        FileContentTypeEnum typeEnum = findTypeOfFile(file);
        switch (typeEnum){
            case XML:
                return parseXml(file,cls);
            case JSON:
                return parseJson(file,cls);
        }

        return null;
    }

    private static FileContentTypeEnum findTypeOfFile(File file) {
        String patternPath = file.getPath();

        return  null;
    }

    public static <T> List<T> transform(List<String> lines, Class<T> cls) {
        Map<Integer, String> map = buildMapping(lines.get(0));

        return lines.subList(1, lines.size()).stream().map(line -> toType(line, cls, map))
                .collect(Collectors.toList());
    }

    private static Map<Integer, String> buildMapping(String firstLine) {
        Map<Integer, String> stringMap = new LinkedHashMap<>();
        String[] array = splitLine(firstLine);
        for (int index = 0; index < array.length; index++) {
            String value = array[index];
            if (value.contains(COMMENT)) {
                value = value.split(COMMENT)[0];
            }
            stringMap.put(index, value.trim());
        }
        return stringMap;
    }

    @SneakyThrows
    private static <T> T toType(String lines, Class<T> cls, Map<Integer, String> map) {
        T type = cls.getDeclaredConstructor().newInstance();
        String[] array = splitLine(lines);
        for (int i = 0; i < array.length; i++) {
            String value = array[i];
            String fieldName = map.get(i);
            setValueIntoFieldOrThrow(value, fieldName, type);
        }
        return type;
    }

    private static void setValueIntoFieldOrThrow(String value, String fieldName, Object type) {
        try {
            Field field = type.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(type, transformValueToFieldType(field, value));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Object transformValueToFieldType(Field field, String value) {
        Map<Class<?>, Function<String, Object>> map = new LinkedHashMap<>();
        map.put(String.class, s -> s);
        map.put(Integer.class, Integer::parseInt);
        map.put(Float.class, Float::parseFloat);
        map.put(LocalDate.class, LocalDate::parse);
        map.put(LocalDateTime.class, LocalDateTime::parse);
        map.put(Long.class, Long::parseLong);
        map.put(BigInteger.class, BigInteger::new);

        return map.getOrDefault(field.getType(), type -> {
            throw new UnsupportedOperationException("Type is not supported by parser " + type);
        }).apply(value);
    }


    private static String[] splitLine(String firstLine) {
        return firstLine.split(DELIMITER);
    }

    public static List<Person> parsePersonXML() throws ParserConfigurationException, SAXException, IOException {
        List<Person> employees = new ArrayList<Person>();
        Person person = null;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("C:\\Users\\konno\\Downloads" +
                "\\java-education-main@28560403666\\src\\main\\resources\\person.xml"));
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("row");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                //Create new Person Object
                person = new Person();
                person.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                person.setSurname(eElement.getElementsByTagName("surname").item(0).getTextContent());
                person.setAge(Integer.valueOf(eElement.getElementsByTagName("age").item(0).getTextContent()));
                person.setDateOfBirth(LocalDate.parse(eElement.getElementsByTagName("dateOfBirth").item(0).getTextContent()));
                person.setGender(eElement.getElementsByTagName("gender").item(0).getTextContent());
                person.setCompany(eElement.getElementsByTagName("company").item(0).getTextContent());
                person.setPosition(eElement.getElementsByTagName("position").item(0).getTextContent());
                person.setSalary(Float.valueOf(eElement.getElementsByTagName("salary").item(0).getTextContent()));

                //Add Person to list
                employees.add(person);
            }
        }
        return employees;
    }


    public static <T extends Person> List<T> parseJson(File file, Class<T> cls) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JSR310Module());
        List<T> personList = objectMapper.readValue(file, new TypeReference<List<T>>() {
                }
        );
        return personList;

    }

    public static <T extends Person> List<T> parseXml(File file, Class<T> clazz) throws IOException {
        XmlMapper mapper = new XmlMapper();
        mapper.registerModule(new JSR310Module());
        List<T> person = (List<T>) mapper.readValue(file,clazz);
        return (List<T>) person;
    }



}