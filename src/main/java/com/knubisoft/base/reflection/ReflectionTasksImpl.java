package com.knubisoft.base.reflection;

import java.lang.reflect.*;
import java.util.*;

import static java.util.Collections.addAll;

public class ReflectionTasksImpl implements ReflectionTasks {

    @Override
    public Object createNewInstanceForClass(Class<?> cls) {
        Object o = null;
        try {
            cls = Class.forName("com.knubisoft.base.reflection.model.InheritedEntryModel");
            Class[] params = {String.class, String.class, String.class};
            o = cls.getConstructor(params).newInstance("1","2","3");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return o;
    }

    @Override
    public <T> Class<? extends T> findImplementationForInterface(Class<T> cls) {
        return null;
    }

    @Override
    public Map<String, Object> findAllFieldsForClass(Class<?> cls) {


        Map<String, Object> map = new HashMap<>();
        Field[] fields = cls.getClass().getDeclaredFields();
        map.put(String.valueOf(map), fields);


        Class<?> parentClass = cls.getClass().getSuperclass();
        while (parentClass != null){
            Field[] patentFields =parentClass.getDeclaredFields();
            map.put(String.valueOf(map), patentFields);
            parentClass = parentClass.getSuperclass();
        }

        return  map;

//        Field [] fields = cls.getClass().getDeclaredFields();
//        Map<String, Object> newMap = new HashMap<String , Object>();
//        Class<?> parentClass = cls.getClass().getSuperclass();
//
//        for (Field field : fields){
//            while (parentClass != null){
//                Field[] parentsField =parentClass.getDeclaredFields();
//                newMap.put(field.getName(), parentsField);
//                parentClass = parentClass.getSuperclass();
//            }
//            newMap.put(field.getName(), cls);
//        }
//
//        return newMap;
    }

    @Override
    public int countPrivateMethodsInClass(Class<?> cls) {
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
        return false;
    }

    @Override
    public Object evaluateMethodByName(Class<?> cls, String name) {
        return null;
    }

    @Override
    public Object evaluateMethodWithArgsByName(Object obj, String name, Object... args) {
        return null;
    }

    @Override
    public Object changePrivateFieldValue(Object instance, String name, Object newValue) {
        return null;
    }
}
