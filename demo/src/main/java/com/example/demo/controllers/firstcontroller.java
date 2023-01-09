package com.example.demo.controllers;

import com.example.demo.Repository.CourseRespository;
import com.example.demo.Repository.EnrolledRepository;
import com.example.demo.models.Course;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class firstcontroller {

    @Autowired
    private CourseRespository course;

    @Autowired
    private EnrolledRepository enrolled;

    @GetMapping("/courses")
    public ResponseEntity getcourses() {

        return ResponseEntity.ok(course.findAll());
    }

    @GetMapping("/enrolled")
    public ResponseEntity getenrolled() {

        return ResponseEntity.ok(enrolled.findAll());
    }

    // @GetMapping("/get_course")
    // public List<Course> getcourse(@RequestParam int id) {

    // return this.course.get_course(id);
    // }

    @PostMapping("/add_course")
    public Course addcourses(@RequestBody Course courseobj) {

        return course.save(courseobj);
    }

    @GetMapping("/get_course_by_id")
    public Optional<Course> getcourseid(@RequestParam long id) {

        return course.findById(id);
    }


    

    // @DeleteMapping("/delete_course")
    // public String deletecourses(@RequestParam int id) {

    // return this.course.delete_course(id);
    // }

}
