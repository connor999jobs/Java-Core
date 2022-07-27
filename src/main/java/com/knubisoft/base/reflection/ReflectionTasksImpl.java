package com.knubisoft.base.reflection;

import com.knubisoft.base.reflection.annotation.FirstAnnotation;

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
        return null;
    }

    @Override
    public Object evaluateMethodWithArgsByName(Object obj, String name, Object... args) {

        Object result = "";
        try {
            Method method = obj.getClass().getMethod(name, new Class[]{String.class});

            result = method.invoke(obj, args);

        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Object changePrivateFieldValue(Object instance, String name, Object newValue) {
        return null;
    }
}
