package com.example.demo.Course;

import org.springframework.http.ResponseEntity;
import java.util.List;

public interface CourseService {

    public List<Course> get_courses();

    public List<Course> get_course(int id);

    public String add_course(Course course);

    public String edit_course(Course course);

    public String delete_course(int id);

}
