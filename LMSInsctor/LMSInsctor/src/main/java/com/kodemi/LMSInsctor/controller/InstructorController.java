package com.kodemi.LMSInsctor.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodemi.LMSInsctor.entites.Course;
import com.kodemi.LMSInsctor.repos.CourseRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/instructor")
@RequiredArgsConstructor
public class InstructorController {

 private final CourseRepository courseRepo;

 @GetMapping("/course/new")
 public String newCourseForm(Model model){
    model.addAttribute("course", new Course());
    return "instructor-course-form";
 }

 @PostMapping("/course/save")
 public String saveCourse(@ModelAttribute Course course){
    course.setCreatedAt(LocalDateTime.now());
    course.setUpdatedAt(LocalDateTime.now());
    courseRepo.save(course);
    return "redirect:/instructor/courses";
 }
}

