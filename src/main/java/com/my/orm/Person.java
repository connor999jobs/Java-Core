package com.my.orm;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Person {

    private String name;
    private String surname;
    private Integer age;
    private LocalDate dateOfBirth;
    private String gender;
    private String company;
    private String position;
    private Float salary;
}
