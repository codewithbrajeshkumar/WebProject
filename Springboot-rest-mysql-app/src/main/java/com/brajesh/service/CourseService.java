package com.brajesh.service;

import com.brajesh.binding.Course;

import java.util.List;

public interface CourseService {

    public  String upsert(Course course);
    public Course getById(Integer cid);
    public List<Course> getAllCourse();
    public String deleteById(Integer cid);


}
