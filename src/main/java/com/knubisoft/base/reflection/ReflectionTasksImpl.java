package com.knubisoft.base.reflection;

import com.knubisoft.base.reflection.annotation.FirstAnnotation;
import org.reflections.Reflections;


import java.lang.reflect.*;
import java.util.*;

import static org.reflections.scanners.Scanners.SubTypes;


public class ReflectionTasksImpl implements ReflectionTasks {

    @Override
    public Object createNewInstanceForClass(Class<?> cls) {
        if (cls == null) {
            throw new NoSuchElementException();
        }
        String[] fields = {"tableName", "schemaName", "version"};
        Class[] params = Arrays.stream(fields).map(String::getClass).toArray(Class[]::new);
        try {
            Constructor<?> constructor = cls.getConstructor(params);
            return constructor.newInstance(fields);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException
                 | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> Class<? extends T> findImplementationForInterface(Class<T> cls) {

        if (cls == null) {
            throw new NoSuchElementException();
        }
        Set<Class<? extends T>> subTypesOf = new Reflections("com.knubisoft.base.reflection.model", SubTypes)
                .getSubTypesOf(cls);
        if (subTypesOf.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return new ArrayList<>(subTypesOf).get(0);
    }

    @Override
    public Map<String, Object> findAllFieldsForClass(Class<?> cls) {
        if (cls == null) {
            throw new NoSuchElementException();
        }

        Map<String, Object> map = new HashMap<>();
        while (cls != null){
            for (Field field : cls.getDeclaredFields()){
                if (!map.containsKey(field.getName())){
                    map.put(field.getName(), field);
                }
            }
            cls = cls.getSuperclass();
        }
        return map;
    }

    @Override
    public int countPrivateMethodsInClass(Class<?> cls) {
        if (cls == null) {
            throw new NoSuchElementException();
        }
        int count =0;
        List<Field> privateFields = new ArrayList<>();
        Field[] allFields = cls.getDeclaredFields();
        for (Field field : allFields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                privateFields.add(field);
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean isMethodHasAnnotation(Method method, Class<?> annotationUnderMethod) {
        try {
            annotationUnderMethod = Class.forName("com.knubisoft.base.reflection.model.ClassWithAnnotations");
            Method m = annotationUnderMethod.getMethod("classMember");
            FirstAnnotation annotation = m.getAnnotation(FirstAnnotation.class);

        } catch (ClassNotFoundException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    @Override
    public Object evaluateMethodByName(Class<?> cls, String name) {
        if (name == null) {
            throw new NoSuchElementException();
        }
        try {
            Object instance = cls.getConstructor().newInstance();
            Method method = cls.getMethod(name);
            return method.invoke(instance);
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException
                 | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object evaluateMethodWithArgsByName(Object obj, String name, Object... args) {
        if (obj == null || name == null || args == null) {
            throw new IllegalArgumentException();
        }
        Object result = "";
        try {
            Class<?> clazz = obj.getClass();
            result = clazz.newInstance();
            Class<?>[] classes = Arrays.stream(args).map(Object::getClass).toArray(Class<?>[]::new);
            Method method = clazz.getDeclaredMethod(name, classes);

            result = method.invoke(obj, args);

        }
        catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Object changePrivateFieldValue(Object instance, String name, Object newValue) {
        try {
            Object newInstance = instance.getClass().getConstructor().newInstance();
            Field declaredField = newInstance.getClass().getDeclaredField(name);
            declaredField.setAccessible(true);
            declaredField.set(newInstance, newValue);
            return newInstance;
        } catch (NoSuchFieldException | NoSuchMethodException | IllegalAccessException | InstantiationException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
