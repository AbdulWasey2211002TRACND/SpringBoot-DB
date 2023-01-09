package com.example.demo.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    List<Course> list;

    public CourseServiceImpl() {
        list = new ArrayList<>();
        list.add(new Course(1, "wasey", 11));
        list.add(new Course(2, "maham", 11));
        list.add(new Course(3, "ayesha", 11));
    }

    @Override
    public List<Course> get_courses() {
        return list;

    }

    @Override
    public List<Course> get_course(int id) {
        return list.stream().filter(i -> i.getId() == id).collect(Collectors.toList());

    }

    @Override
    public String add_course(Course course) {

        if (list.stream().filter(i -> i.getId() == course.getId()).collect(Collectors.toList()).size() != 0) {
            return "Course Already Added";
        } else {
            list.add(course);
            return "Course Added Successfully";

        }

    }

    @Override
    public String edit_course(Course course) {

        if (list.stream().filter(i -> i.getId() == course.getId()).collect(Collectors.toList()).size() != 0) {

            list.stream().forEach(i -> i.setName(course.getName()));

            return "Course Edit Successfully";
        } else {
            return "No Courses Found";

        }

    }

    @Override
    public String delete_course(int id) {

        if (list.stream().filter(i -> i.getId() == id).collect(Collectors.toList()).size() != 0) {
            list.removeIf(i -> i.getId() == id);
            return "Course Removed Successfully";
        } else {
            return "No Course Found";

        }

    }

}
