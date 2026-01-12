package com.kodemi.LMSInsctor.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodemi.LMSInsctor.entites.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
