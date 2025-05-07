package com.brajesh.service;

import com.brajesh.binding.Course;
import com.brajesh.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepository courserepo;

    @Override
    public String upsert(Course course) {
       courserepo.save(course);  //upsert nothing but insert the recode
        return "Success";
    }

    @Override
    public Course getById(Integer cid) {
        Optional<Course> findById = courserepo.findById(cid);
        if (findById.isPresent()){
            return findById.get();
        }
        return null;
    }

    @Override
    public List<Course> getAllCourse() {
        return courserepo.findAll();
        //return List.of();
    }

    @Override
    public String deleteById(Integer cid) {
        if (courserepo.existsById(cid)) {
            courserepo.deleteById(cid);
            return "Delete Success";
        } else {
            return "No Record Find";
        }
    }
}
