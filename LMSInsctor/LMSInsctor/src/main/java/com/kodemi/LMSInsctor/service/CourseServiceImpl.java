package com.kodemi.LMSInsctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodemi.LMSInsctor.entites.Course;
import com.kodemi.LMSInsctor.repos.CourseRepository;

@Service
public class CourseServiceImpl {
	
	@Autowired
    private CourseRepository courseRepository;

    
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + id));
    }

}
