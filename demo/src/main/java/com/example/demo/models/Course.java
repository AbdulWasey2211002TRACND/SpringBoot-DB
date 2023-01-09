package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;



@Entity
@Table(name = "Courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    //columns
    private Long id;
    private String name;
    private int hours;

    //foriegn key
    @OneToMany(mappedBy = "course")
    private List<Enrolled> enrolled;


    public Course() {
    }

    public Course( String name, int hours) {
        this.name = name;
        this.hours = hours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setDescription(int hours) {
        this.hours = hours;
    }
}