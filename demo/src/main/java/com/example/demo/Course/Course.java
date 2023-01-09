package com.example.demo.Course;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {

    private long id;
    private String name;
    private Integer hours;

    public Course(long id, String name, Integer hours) {
        this.id = id;
        this.name = name;
        this.hours = hours;
    }

}
