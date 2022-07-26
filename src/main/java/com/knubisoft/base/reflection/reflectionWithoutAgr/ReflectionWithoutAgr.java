package com.knubisoft.base.reflection.reflectionWithoutAgr;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionWithoutAgr {
    public static void main(String[] args) {

        Class<?> dogClass = null;
        try {
            dogClass = Class.forName("com.knubisoft.base.reflection.reflectionWithoutAgr.Dog");
            Object dog = dogClass.newInstance();

            String methodName = "";

            // with single parameter, return void
            methodName = "setName";
            Method setNameMethod = dog.getClass().getMethod(methodName, String.class);
            setNameMethod.invoke(dog, "Djock");
            System.out.println(setNameMethod);

            // without parameters, return string
            methodName = "getName";
            Method getNameMethod = dog.getClass().getMethod(methodName);
            String name = (String) getNameMethod.invoke(dog);
            System.out.println(getNameMethod);

            // with multiple parameters

            methodName = "printDog";
            Class<?>[] paramTypes = {String.class, int.class};
            Method printDogMethod = dog.getClass().getMethod(methodName, paramTypes);
            printDogMethod.invoke(dog,name,3);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
           e.printStackTrace();
        }

    }
}
