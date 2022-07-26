package com.knubisoft.base.reflection;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno{
    String str();
    int val();
}
public class TestRefAn {

    @MyAnno(str = "Annotation", val = 22)
    public static void myMeth(){
        TestRefAn ob = new TestRefAn();

        try {
            Class<?> c = ob.getClass();
            Method m = c.getMethod("myMeth");
            MyAnno anno = m.getAnnotation(MyAnno.class);
            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        myMeth();
    }
}

