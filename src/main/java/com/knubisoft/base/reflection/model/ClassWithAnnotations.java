package com.knubisoft.base.reflection.model;

import com.knubisoft.base.reflection.annotation.FirstAnnotation;
import com.knubisoft.base.reflection.annotation.SecondAnnotation;
import com.knubisoft.base.reflection.annotation.ThirdAnnotation;

public class ClassWithAnnotations {
    @FirstAnnotation(str = "Test", val = 100)
    private String classMember;
}
