package com.knubisoft.base.reflection.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface FirstAnnotation {
    String str();
    int val();
}
