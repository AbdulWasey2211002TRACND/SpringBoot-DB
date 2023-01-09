package com.example.demo;

import static org.hamcrest.CoreMatchers.containsString;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Collection;

import javax.print.attribute.standard.Media;

import com.example.demo.Course.Course;
import com.example.demo.Course.CourseServiceImpl;
import com.example.demo.controllers.firstcontroller;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureJsonTesters
@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

    private MockMvc mvc;

    @Mock
    private CourseServiceImpl course;

    @InjectMocks
    private firstcontroller controller;

    private JacksonTester<Course> coursejson;

    @BeforeEach
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void contextLoads() {
    }

    // AC1 : get by id of course
    @Test
    public void canCreateNewCourse() throws Exception {
        Course course = new Course(1, "wasey", 11);
        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("id", "1");
        mvc.perform(get("/get_course").params(requestParams)).andExpect(status().isOk());
    }

    // AC2 : add course
    @Test
    public void canCreateANewBook() throws Exception {
        Course course = new Course(1, "wasey", 11);
        String body = (new ObjectMapper()).valueToTree(course).toString();

        mvc.perform(post("/add_course")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(coursejson.write(course).getJson()))
                .andExpect(status().isOk());
    }

    // AC1 : delete course by id
    @Test
    public void deletebook() throws Exception {
        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("id", "1");
        mvc.perform(delete("/delete_course").params(requestParams))
        .andExpect(status().isOk());
    }

}
