package com.kodemi.LMSInsctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodemi.LMSInsctor.entites.Assignment;
import com.kodemi.LMSInsctor.entites.Course;
import com.kodemi.LMSInsctor.entites.Instructor;
import com.kodemi.LMSInsctor.service.AssignmentService;
import com.kodemi.LMSInsctor.service.CourseServiceImpl;
import com.kodemi.LMSInsctor.service.InstructorServiceImpl;

@Controller
@RequestMapping("/instructor/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private CourseServiceImpl courseService;

    @Autowired
    private InstructorServiceImpl instructorService;


    /** ---------------- CREATE FORM ---------------- **/
    @GetMapping("/create")
    public String showCreateForm(Model model) {

        model.addAttribute("assignment", new Assignment());
        model.addAttribute("courses", courseService.getAllCourses());
        model.addAttribute("instructors", instructorService.getAllInstructors());

        return "assignment-create";
    }


    /** ---------------- SAVE ASSIGNMENT ---------------- **/
    @PostMapping("/create")
    public String createAssignment(@ModelAttribute("assignment") Assignment assignment) {

        // Load course by ID
        Course course = courseService.getCourseById(
                assignment.getCourse().getId());
        assignment.setCourse(course);

        // Load instructor by ID
        Instructor instructor = instructorService.getInstructorById(
                assignment.getInstructor().getId());
        assignment.setInstructor(instructor);

        assignmentService.saveAssignment(assignment);

        return "redirect:/instructor/assignments/list";
    }


    /** ---------------- LIST PAGE ---------------- **/
    @GetMapping("/list")
    public String listAssignments(Model model) {
        model.addAttribute("assignments", assignmentService.getAllAssignments());
        return "assignment-list";
    }
}
