package com.brajesh.rest;

import com.brajesh.binding.Course;
import com.brajesh.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/course")
    public ResponseEntity<String> createCourse(@RequestBody Course course){
       String status = courseService.upsert(course);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @GetMapping("/course/{cid}")
    public ResponseEntity<Course> getCourse(@PathVariable Integer cid){
        Course course = courseService.getById(cid);
        return new ResponseEntity<>(course,HttpStatus.OK);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> allCourse = courseService.getAllCourse();
        return new ResponseEntity<>(allCourse,HttpStatus.OK);
    }

    @PutMapping("course")
    public ResponseEntity<String> updateCourse(@RequestBody Course course){
        String status = courseService.upsert(course);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }

    @DeleteMapping("/course/{cid}")
    public ResponseEntity<String> deleteCourse(@PathVariable Integer cid){
        String status = courseService.deleteById(cid);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

}
