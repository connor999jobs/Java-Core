package com.my.orm;


import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrmSystem {


    public static final String DELIMITER = ",";
    private static final String COMMENT = "--";

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
}
