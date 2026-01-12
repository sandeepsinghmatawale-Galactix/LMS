package com.kodemi.LMSInsctor.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodemi.LMSInsctor.entites.Assignment;
import com.kodemi.LMSInsctor.repos.AssignmentRepository;

@Service
public class AssignmentService {

	@Autowired
    private AssignmentRepository repo;

    
    public Assignment createAssignment(Assignment assignment) {
        assignment.setCreatedAt(LocalDateTime.now());
        return repo.save(assignment);
    }

    
    public List<Assignment> getAllAssignments() {
        return repo.findAll();
    }

    
    public List<Assignment> getAssignmentsByCourse(Long courseId) {
        return repo.findByCourseId(courseId);
    }

    
    public List<Assignment> getAssignmentsByInstructor(Long instructorId) {
        return repo.findByInstructorId(instructorId);
    }
    
    
    public Assignment saveAssignment(Assignment assignment) {
        return repo.save(assignment);
    }

    
    
}
